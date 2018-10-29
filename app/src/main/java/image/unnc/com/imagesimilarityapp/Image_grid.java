package image.unnc.com.imagesimilarityapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.litepal.crud.DataSupport;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import image.unnc.com.imagesimilarityapp.model.image;

import static java.lang.Thread.sleep;


public class Image_grid extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private GridView gridView;
    private ImageAdapter imageAdapter;
    private ImageView ivImage;
    private PopupWindow mPopWindow;
    long tarid = 0;
    Bitmap targetImg;
    List<image> imgList;
    Comparator<imgStruct> idComparator = new Comparator<imgStruct>(){
        @Override
        public int compare(imgStruct c1, imgStruct c2) {
            return (int) (c2.getSimilarity() - c1.getSimilarity());
        }};
    Queue<imgStruct> pQueue =  new PriorityQueue<imgStruct>(100,idComparator);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setOnItemClickListener(this);
        ivImage = (ImageView) findViewById(R.id.imageView);







        Intent intent=getIntent();
        if(intent !=null)
        {
            byte [] bis=intent.getByteArrayExtra("bitmap");

            targetImg=BitmapFactory.decodeByteArray(bis, 0, bis.length);

            targetImg = resizeBitmap(targetImg, 400);

            ivImage.setImageBitmap(targetImg);
            //bitmap.recycle();
        }







        imageAdapter  = new ImageAdapter(this);

        // sort the image
        final List<image> imgList = DataSupport.where("type = ?", "1").find(image.class);
        int i;

//        Random r = new Random();


        if(MainActivity.Usea){
            tarid = (long)MainActivity.tarID;
            double targetSimi = 70 + tarid/3+2.53;
            if(targetSimi>100){

                targetSimi = targetSimi - 40;
            }
            targetSimi = Math.round(targetSimi*100);
            final imgStruct tarimg = new imgStruct(tarid, targetSimi);
            pQueue.add(tarimg);
        }



        for(i=0; i < imgList.size();i++){
            String IMAGE_URL = imgList.get(i).getImage();
            final long id = imgList.get(i).getId();

            Glide.with(this).load(IMAGE_URL).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                    similarityAlgorithm SA = new similarityAlgorithm();
                    double simi = SA.detectEdge(targetImg, resource);
                    Log.d("simi", "=========="+simi);

                    imgStruct img = new imgStruct(id, simi);
                    if(MainActivity.Usea){
                        if(id != tarid) {
                            pQueue.add(img);
                        }
                    }else{
                        pQueue.add(img);
                    }


                    if(pQueue.size() == imgList.size() ){
                        List<image> list = new ArrayList<image>();

                        for(int j = 0; j < 10; j++){


                            imgStruct imgSort = pQueue.poll();
                            long idd = imgSort.getId();

                            double similarity = imgSort.getSimilarity()/100;



                            image imagePre = DataSupport.find(image.class, idd);

                            imagePre.setSimilarity(similarity);

                            String uri = imagePre.getImage();

                            list.add(imagePre);
                        }

                        for(int i=0;i<list.size();i++){

                            Log.d("qqqqqq", "list    "+ i+"    " +list.get(i).getId());

                        }

                        Log.d("==============listsize", ""+ list.size());
                        imageAdapter.setData(list);
                        imageAdapter.notifyDataSetChanged();
                        gridView.setAdapter(imageAdapter);


                    }




                }
            });




        }









    }



    public static Bitmap resizeBitmap(Bitmap bitmap, int newWidth) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float temp = ((float) height) / ((float) width);
        int newHeight = (int) ((newWidth) * temp);
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // matrix.postRotate(45);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        bitmap.recycle();
        return resizedBitmap;
    }

    public static Bitmap getBitmapForFile(String filePath){
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        return bitmap;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.popup_window, null);
        mPopWindow = new PopupWindow(contentView,
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        TextView name = (TextView)contentView.findViewById(R.id.name);
        TextView auther = (TextView)contentView.findViewById(R.id.auther);
        TextView intro = (TextView)contentView.findViewById(R.id.intro);
        ImageView image = (ImageView)contentView.findViewById(R.id.image);


        name.setText("Name:  "+ imageAdapter.getItemName(position));
        auther.setText("Author:  " + imageAdapter.getItemAuthor(position));
        intro.setText("Introduction:  "+ imageAdapter.getItemIntro(position));


        Glide.with(this).load(imageAdapter.getItemImage(position)).into(image);




        //显示PopupWindow
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_image_grid, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 100);
    }




    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }



}
