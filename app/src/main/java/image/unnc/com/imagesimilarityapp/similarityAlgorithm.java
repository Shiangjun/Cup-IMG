package image.unnc.com.imagesimilarityapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.util.Log;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;

import static android.R.attr.bitmap;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static org.opencv.core.Core.norm;

/**
 * Created by zengye on 4/20/17.
 */



public class similarityAlgorithm {

//
//    public Mat bitToGray(Bitmap footbm) {
//        footbm = Bitmap.createScaledBitmap(footbm, 50, 50, true);
//
//        Mat footMat = new Mat();
//        //convert bitmap to opencv Mat
//        Utils.bitmapToMat(footbm, footMat);
//
//        //Convert to Gray image
//        Mat footGrayMat = new Mat();
//        Imgproc.cvtColor(footMat, footGrayMat, Imgproc.COLOR_BGR2GRAY, 1);
//        return footGrayMat;
//
//    }

    public double detectEdge ( Bitmap bmpimg1, Bitmap bmpimg2){

        bmpimg1 = Bitmap.createScaledBitmap(bmpimg1, 300, 300, true);
        bmpimg2 = Bitmap.createScaledBitmap(bmpimg2, 300, 300, true);
        Mat img1 = new Mat();
        Utils.bitmapToMat(bmpimg1, img1);
        Mat img2 = new Mat();
        Utils.bitmapToMat(bmpimg2, img2);
        Imgproc.cvtColor(img1, img1, Imgproc.COLOR_RGBA2GRAY);
        Imgproc.cvtColor(img2, img2, Imgproc.COLOR_RGBA2GRAY);
        img1.convertTo(img1, CvType.CV_32F);
        img2.convertTo(img2, CvType.CV_32F);

        Mat hist1 = new Mat();
        Mat hist2 = new Mat();
        MatOfInt histSize = new MatOfInt(180);
        MatOfInt channels = new MatOfInt(0);

        ArrayList<Mat> bgr_planes1= new ArrayList<Mat>();
        ArrayList<Mat> bgr_planes2= new ArrayList<Mat>();

        Core.split(img1, bgr_planes1);
        Core.split(img2, bgr_planes2);
        MatOfFloat histRanges = new MatOfFloat (0f, 180f);
        boolean accumulate = false;

        Imgproc.calcHist(bgr_planes1, channels, new Mat(), hist1, histSize, histRanges, accumulate);
        Core.normalize(hist1, hist1, 0, hist1.rows(), Core.NORM_MINMAX, -1, new Mat());

        Imgproc.calcHist(bgr_planes2, channels, new Mat(), hist2, histSize, histRanges, accumulate);
        Core.normalize(hist2, hist2, 0, hist2.rows(), Core.NORM_MINMAX, -1, new Mat());

        img1.convertTo(img1, CvType.CV_32F);
        img2.convertTo(img2, CvType.CV_32F);
        hist1.convertTo(hist1, CvType.CV_32F);
        hist2.convertTo(hist2, CvType.CV_32F);

        double compare = Imgproc.compareHist(hist1, hist2, 0);
        int size =  hist1.height();

        Log.d("the compare is ", String.valueOf(compare));


        double simi = Math.round(abs(compare*10000));

        Log.d("simisimisimisimi", ""+ simi);


        return  simi;

//        Bitmap bmp = Bitmap.createScaledBitmap(bitmap, 50, 50, true);
//
//        Mat img1 = new Mat();
//        Utils.bitmapToMat(bmp, img1);
//        Imgproc.cvtColor(img1, img1, Imgproc.COLOR_RGBA2GRAY);
//        img1.convertTo(img1, CvType.CV_32F);


//        Mat rgba = new Mat();   Resources res=getResources();
//        Utils.bitmapToMat(b2, rgba);
//
//        Mat edges = new Mat(rgba.size(), CvType.CV_8UC1);
//
//        Imgproc.cvtColor(rgba, edges, Imgproc.COLOR_RGB2GRAY, 4);
//        Imgproc.Canny(edges, edges, 50, 50);


//        return edges;
//        Bitmap resultBitmap = Bitmap.createBitmap(edges.cols(), edges.rows(), Bitmap.Config.ARGB_8888);
//        Utils.matToBitmap(edges, resultBitmap);
//        return resultBitmap;

//        Bitmap bmp = null;
//        Mat tmp = new Mat (bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(4));
//        try {
//            //Imgproc.cvtColor(seedsImage, tmp, Imgproc.COLOR_RGB2BGRA);        Imgproc.cvtColor(footGrayMat, tmp, Imgproc.COLOR_GRAY2RGBA, 4);
//            bmp = Bitmap.createBitmap(tmp.cols(), tmp.rows(), Bitmap.Config.ARGB_8888);
//            Utils.matToBitmap(tmp, bmp);
//        }
//        catch (Exception e){
//            Log.d("Exception",e.getMessage());}
//        return bmp;
    }

    public double distance(Bitmap bmpimg1, Bitmap bmpimg2){
        bmpimg1 = Bitmap.createScaledBitmap(bmpimg1, 8, 8, true);
        bmpimg2 = Bitmap.createScaledBitmap(bmpimg2, 8, 8, true);
        Bitmap resultBitmap1 = toGrayscale(bmpimg1);
        Bitmap resultBitmap2 = toGrayscale(bmpimg2);

        int average1 = getAveragePixel(resultBitmap1);
        int average2 = getAveragePixel(resultBitmap2);

        Log.d("average1 is ", String.valueOf(average1));
        Log.d("average2 is ", String.valueOf(average2));

        int [] pixel1= new int[64];
        int[] pixel2 = new int[64];
//        for(int i = 0; i<50; i++){
//            for(int j = 0; j<50; j++){
//
//            }
//        }


//        Bitmap resultBitmap1 = Bitmap.createBitmap(edge1.cols(), edge1.rows(), Bitmap.Config.ARGB_8888);
//        Utils.matToBitmap(edge1, resultBitmap1);
//
//        Bitmap resultBitmap2 = Bitmap.createBitmap(edge2.cols(), edge2.rows(), Bitmap.Config.ARGB_8888);
//        Utils.matToBitmap(edge2, resultBitmap2);
//        Log.d("the bitmap2 heoght", String.valueOf(resultBitmap2.getHeight()));
//        Log.d("the bitmap1 heoght", String.valueOf(resultBitmap1.getHeight()));

        double diff=0;
        int count = 0;
        Log.d("the height is ", String.valueOf(bmpimg1.getHeight()));

        for(int i = 0; i< resultBitmap1.getWidth(); i++)
            for (int j = 0; j < resultBitmap1.getHeight(); j++) {
                int p1 = abs(resultBitmap1.getPixel(i, j));

                if(average1 > p1){
                    pixel1[i*j] = 0;
                }else{
                    pixel1[i*j] = 1;
                }
//                long num1 = abs(resultBitmap1.getPixel(i, j));
//                long num2 = abs(resultBitmap2.getPixel(i, j));
//                Log.d("origin pixel", String.valueOf(resultBitmap2.getPixel(i, j)));
//                if(num1==num2){
//                    count++;
//                    Log.d("count is ", String.valueOf(count));
//                }
//
//                // Log.d("the pixel is ", String.valueOf(resultBitmap1.getPixel(i, j)));
//                diff += abs(num1 - num2)/max(num1, num2);

//                Log.d("diff is +++", String.valueOf(diff));
            }

        for(int i = 0; i< resultBitmap2.getWidth(); i++)
            for (int j = 0; j < resultBitmap2.getHeight(); j++) {
                int p2 = abs(resultBitmap2.getPixel(i, j));

                Log.d("p2 is ", "+++++"+ p2);
                if(average2 > p2){
                    pixel2[i*j] = 0;
                    Log.d("p2 distance<<<<<<: ", "p2 < average");
                }else{
                    pixel2[i*j] =1;
                    Log.d("p2 distance>>>>>>: ", "p2 > average");

                }
            }

        int count1 = 0;
        for(int i = 0; i< 64; i++){
            if (pixel1[i] == pixel2[i]){
                count1++;
            }
        }









//
//        double errorL2 = norm( edge1);
//         double errorL3 = norm(edge2);
//        System.out.println("The erro is " + errorL2);

        double m = count1*100/64;
        double similarity = Math.round(count*100)/100;

        return m;
    }
    //    public double calSimilarity(int totalDis){
//        int length = 50*50;
//        double similarity = (length - totalDis) / (double) length;
//
//        // 使用指数曲线调整相似度结果
//        similarity = java.lang.Math.pow(similarity, 2);
//        return similarity;
//    }
    public Bitmap toGrayscale(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
    public int getAveragePixel(Bitmap bmpimg1){
        int width = bmpimg1.getWidth();
        int height = bmpimg1.getHeight();
        int total=0;
        for(int i=0; i < width; i++){
            for(int j = 0; j < height; j++){
                total += abs(bmpimg1.getPixel(i, j));
            }

        }

        int average = total/(width*height);
        return average;
    }




}
