package image.unnc.com.imagesimilarityapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import image.unnc.com.imagesimilarityapp.model.image;

import static android.R.attr.bitmap;
import static android.R.attr.path;



public class MainActivity extends Activity {

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button btnSelect;
    private ImageView ivImage;
    private String userChoosenTask;
    static boolean Usea = false;


    private Button btnConfirm;
    Hashtable<String, Integer> sample = new Hashtable<String, Integer> ();

    public Bitmap pic;
    static int tarID;

    private static final String TAG = "Mainactivity";
    static {
        if(!OpenCVLoader.initDebug()){
            Log.d(TAG, "opencv not loaded ");
        }else{
            Log.d(TAG, "opencv loaded ");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






//        SQLiteDatabase imageDB = LitePal.getDatabase();
        SQLiteDatabase db = Connector.getDatabase();

//        DataSupport.deleteAll(image.class);
//
//
        List check = DataSupport.findAll(image.class);
        if(check.size()==0){


            addImage1();
            addImage2();
            addImage3();
            addImage4();
            addImage5();
            addImage6();
            addImage7();
            addImage8();
            addImage9();
            addImage10();
            addImage11();
            addImage12();
            addImage13();
            addImage14();
            addImage15();
            addImage16();
            addImage17();
            addImage18();
            addImage19();
            addImage20();
            addImage21();
            addImage22();
            addImage23();
            addImage24();
            addImage25();
            addImage26();
            addImage27();
            addImage28();
            addImage29();
            addImage30();
            addImage31();
            addImage32();
            addImage33();
            addImage34();
            addImage35();
            addImage36();
            addImage37();
            addImage38();
            addImage39();
            addImage40();
            addImage41();
            addImage42();
            addImage43();
            addImage44();
            addImage45();
            addImage46();
            addImage47();
            addImage48();
            addImage49();
            addImage50();
            addImage51();
            addImage52();
            addImage53();
            addImage54();
            addImage55();
            addImage56();
            addImage57();
            addImage58();
            addImage59();
            addImage60();
            addImage61();
            addImage62();
            addImage63();
            addImage64();
            addImage65();
            addImage66();
            addImage67();
            addImage68();
            addImage69();
            addImage70();
            addImage71();
            addImage72();
            addImage73();
            addImage74();
            addImage75();
            addImage76();
            addImage77();
            addImage78();
            addImage79();
            addImage80();
            addImage81();
            addImage82();
            addImage83();
            addImage84();
            addImage85();
            addImage86();
            addImage87();
            addImage88();
            addImage89();
            addImage90();
            addImage91();
            addImage92();
            addImage93();
            addImage94();
            addImage95();
            addImage96();
            addImage97();
            addImage98();
            addImage99();
            addImage100();
            addImage101();
            addImage102();
            addImage103();
            addImage104();
            addImage105();
            addImage106();
            addImage107();
            addImage108();
            addImage109();
            addImage110();
            addImage111();
            addImage112();
            addImage113();
            addImage114();
            addImage115();
            addImage116();
            addImage117();
            addImage118();
            addImage119();
            addImage120();
            addImage121();
            addImage122();
            addImage123();
            addImage124();
            addImage125();
            addImage126();
            addImage127();
            addImage128();
            addImage129();
            addImage130();
            addImage131();
            addImage132();
            addImage133();
            addImage134();
            addImage135();
            addImage136();
            addImage137();
            addImage138();
            addImage139();
            addImage140();
            addImage141();
            addImage142();


        }

        Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.image001);
        similarityAlgorithm SA = new similarityAlgorithm();
//        Mat mat1 = SA.bitToGray(img1);
//        Mat mat2 = SA.bitToGray(img2);
//        Mat edge1 = SA.detectEdge(img1);
//        Mat edge2 = SA.detectEdge(img2);
        double simi = SA.detectEdge(img1, img2);
        double simi2 = SA.distance(img1,img2);

//        double simi = SA.distance(edge1, edge2);
        // double simi = SA.calSimilarity(SA.distance(edge1, edge2));
//        Log.d("The similarity is ", "(opencv++)"+String.valueOf(simi));
//        Log.d("The similarity is ", "(distance++++++++++++)"+String.valueOf(simi2));


//        TestAdapter mDbHelper = new TestAdapter(this);
//        mDbHelper.createDatabase();
//        mDbHelper.open();

//        Cursor testdata = mDbHelper.getTestData();

//        SQLiteDatabase db = Connector.getDatabase();

//        dbHelper.closeDatabase();
        setContentView(R.layout.activity_main);
        btnSelect = (Button) findViewById(R.id.btnSelectPhoto);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        // ivImage.setImageBitmap(edge1);
        btnConfirm = (Button) findViewById(R.id.btnconfrim);
        btnSelect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                selectImage();

                userChoosenTask ="Choose from Library";
                galleryIntent();

            }
        });

        ImageButton btnimage = (ImageButton) findViewById(R.id.camera);

        btnimage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                selectImage();

                userChoosenTask ="Take Photo";
                cameraIntent();

            }
        });




        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Image_grid.class);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();;

                pic = resizeBitmap(pic, 300);
                pic.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] bitmapByte = baos.toByteArray();
                intent.putExtra("bitmap", bitmapByte);


                startActivity(intent);
            }
        });


    }


    /**
     * 添加一张图片
     */
    private void addImage() {
        image db = new image ();
        db.setId(0);
        db.setName("测试");
        db.setAuthor("test");
        db.setInstro("这是一张测试图片");
        db.setRemark("测试");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/image001.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));//设置上传时间为当前时间
        db.save();
    }
    private void addImage1() {
        image db = new image ();
        db.setId(1);
        db.setName("Watermelon cup");
        db.setAuthor("Inventor: Brian Pellham");
        db.setInstro("Patent No.: US D783,362 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a watermelon cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup1.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage2() {
        image db = new image ();
        db.setId(2);
        db.setName("Drinking cup");
        db.setAuthor("Inventors: Reid Schlegel, John Traub, Wastney");
        db.setInstro("Patent No.: US D783,358 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a drinking cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup2.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage3() {
        image db = new image ();
        db.setId(3);
        db.setName("Serving cup");
        db.setAuthor("Inventors: Jeffrey R.Jetton, Tyler L.Williams, Stan A.Levltsky");
        db.setInstro("Patent No.: US D783,357 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a serving cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup3.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage4() {
        image db = new image ();
        db.setId(4);
        db.setName("Bottle");
        db.setAuthor("Inventors: Michael G.Marantis; Richard A.Ponton; Joshua W.Hubbard; Jonathan P.Richards");//设置版权名字
        db.setInstro("Patent No.: US D783,407 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a bottle, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup4.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage5() {
        image db = new image ();
        db.setId(5);
        db.setName("TNT cup");
        db.setAuthor("Inventor: Brian Pellham");
        db.setInstro("Patent No.: US D783,361 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a TNT cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup5.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage6() {
        image db = new image ();
        db.setId(6);
        db.setName("Infuser tea cup with straw");
        db.setAuthor("Inventor: Huajun Yao");
        db.setInstro("Patent No.: US D784,082 S,  Date of patent:  ** Apr.18,2017");
        db.setRemark("Claim: The omamental design for an infuser tea cup with straw, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup6.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage7() {
        image db = new image ();
        db.setId(7);
        db.setName("Push up cereal cup");
        db.setAuthor("Inventor: Noah Vilinsky");
        db.setInstro("Patent No.: US 9,624,024 B2,  Date of patent:  ** Apr.18,2017");
        db.setRemark("Claim: The omamental design for a push up cereal cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup7.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage8() {
        image db = new image ();
        db.setId(8);
        db.setName("Bottle");
        db.setAuthor("Inventor: Tadayori Nakayama");
        db.setInstro("Patent No.: US 9,617,028 B2,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a bottle, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup8.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage9() {
        image db = new image ();
        db.setId(9);
        db.setName("Snack cup");
        db.setAuthor("Inventor: Sara L. Delgado Carmona");
        db.setInstro("Patent No.: US D782,883 S,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a snack cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup9.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage10() {
        image db = new image ();
        db.setId(10);
        db.setName("Communion cup");
        db.setAuthor("Inventor: Ronald M. Rebmann");
        db.setInstro("Patent No.: US D782,876 S,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a communion cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup10.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage11() {
        image db = new image ();
        db.setId(11);
        db.setName("Multi-chamber container");
        db.setAuthor("Inventors: Matthew Lee Kolb; John C. Crawford");
        db.setInstro("Patent No.: US 9,611,077 B2,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a multi-chamber container, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup11.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage12() {
        image db = new image ();
        db.setId(12);
        db.setName("Cup for a juice extractor");
        db.setAuthor("Inventors: Jong Boo Kim; In Young Kim");
        db.setInstro("Patent No.: US D782,247 S,  Date of patent:  ** Mar.28,2017");
        db.setRemark("Claim: The omamental design for a cup for a juice extractor, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup12.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage13() {
        image db = new image ();
        db.setId(13);
        db.setName("Two-layered cup");
        db.setAuthor("Inventor: Hui Pang");
        db.setInstro("Patent No.: US D781,108 S,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a two-layered cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup13.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage14() {
        image db = new image ();
        db.setId(14);
        db.setName("Shaker cup");
        db.setAuthor("Inventor: Anthony Cerasani");
        db.setInstro("Patent No.: US D781,104 S,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a shaker cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup14.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage15() {
        image db = new image ();
        db.setId(15);
        db.setName("Oxford style sample cup");
        db.setAuthor("Inventor: Donato Pompa");
        db.setInstro("Patent No.: US 9,594,034 B1,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a Oxford style sample cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup15.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage16() {
        image db = new image ();
        db.setId(16);
        db.setName("Mug cup");
        db.setAuthor("Inventor: Mun Hyang Heo");
        db.setInstro("Patent No.: US D779,880 S,  Date of patent:  ** Feb.28,2017");
        db.setRemark("Claim: The omamental design for a mug cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup16.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage17() {
        image db = new image ();
        db.setId(17);
        db.setName("Cap and bottle");
        db.setAuthor("Inventors: John Crawford; Scott Beckerman");
        db.setInstro("Patent No.: US D9,579,262 B2,  Date of patent:  ** Feb.28,2017");
        db.setRemark("Claim: The omamental design for a cap and bottle, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup17.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage18() {
        image db = new image ();
        db.setId(18);
        db.setName("Container");
        db.setAuthor("Inventors: Bradley J. Crosby; Carter Ash; Brent Frazler; David Hull");
        db.setInstro("Patent No.: US D779,276 S,  Date of patent:  ** Feb.21,2017");
        db.setRemark("Claim: The omamental design for a container, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup18.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage19() {
        image db = new image ();
        db.setId(19);
        db.setName("Cup for soup");
        db.setAuthor("Inventor: Ewald Struggl");
        db.setInstro("Patent No.: US D777,521 S,  Date of patent:  ** Jan.31,2017");
        db.setRemark("Claim: The omamental design for a cup for soup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup19.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage20() {
        image db = new image ();
        db.setId(20);
        db.setName("Cup");
        db.setAuthor("Inventors: Dorian Levy; William Prindle");
        db.setInstro("Patent No.: US D777,519 S,  Date of patent:  ** Jan.31,2017");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup20.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage21() {
        image db = new image ();
        db.setId(21);
        db.setName("Cup with lid");
        db.setAuthor("Inventors: Jeff Hunt; Alfred Lechner");
        db.setInstro("Patent No.: US D775,957 S,  Date of patent:  ** Jan.10,2017");
        db.setRemark("Claim: The omamental design for a cup with lid, as shown");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup21.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage22() {
        image db = new image ();
        db.setId(22);
        db.setName("Cup");
        db.setAuthor("Inventor: Che-Min Chu");
        db.setInstro("Patent No.: US D775,896 S,  Date of patent:  ** Jan.10,2017");
        db.setRemark("Claim: The omamental design for a cup, as shown");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup22.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage23() {
        image db = new image ();
        db.setId(23);
        db.setName("Shoe-shape cup");
        db.setAuthor("Inventor: Robert M.Faber");
        db.setInstro("Patent No.: US D775,494 S,  Date of patent:  ** Jan.3,2017");
        db.setRemark("Claim: The omamental design for a shoe-shape cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup23.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage24() {
        image db = new image ();
        db.setId(24);
        db.setName("Cup");
        db.setAuthor("Inventor: M.Olivier");
        db.setInstro("Patent No.: US D774,829 S,  Date of patent:  ** Dec.27,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup24.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage25() {
        image db = new image ();
        db.setId(25);
        db.setName("Dispensing cup");
        db.setAuthor("Inventor: Michael David Sanders");
        db.setInstro("Patent No.: US D772,705 S,  Date of patent:  ** Nov.29,2016");
        db.setRemark("Claim: The omamental design for a dispensing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup25.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage26() {
        image db = new image ();
        db.setId(26);
        db.setName("Cup");
        db.setAuthor("Inventor: John D.O'Connor");
        db.setInstro("Patent No.: US D772,013 S,  Date of patent:  ** Nov.22,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup26.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage27() {
        image db = new image ();
        db.setId(27);
        db.setName("Slotted cup");
        db.setAuthor("Inventors: Jeffy Zwerner; Danielle Reid; Eric Pfeiffer; John Barretto");
        db.setInstro("Patent No.: US D769,971 S,  Date of patent:  ** Oct.25,2016");
        db.setRemark("Claim: The omamental design for a slotted cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup27.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage28() {
        image db = new image ();
        db.setId(28);
        db.setName("Insulating cup sleeve");
        db.setAuthor("Inventor: Robert L.Farichild, Jr.");
        db.setInstro("Patent No.: US D769,717 S,  Date of patent:  ** Oct.25,2016");
        db.setRemark("Claim: The omamental design for an insulating cup sleeve, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup28.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage29() {
        image db = new image ();
        db.setId(29);
        db.setName("Hexagonal cup");
        db.setAuthor("Inventors: William Heimsoth; Aaron Attebery ");
        db.setInstro("Patent No.: US D769,071 S,  Date of patent:  ** Oct.18,2016");
        db.setRemark("Claim: The omamental design for a hexagonal cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup29.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage30() {
        image db = new image ();
        db.setId(30);
        db.setName("Snack storage lid for a beverage cup");
        db.setAuthor("Inventor: Bonnie Sussman Strominger");
        db.setInstro("Patent No.: US 9,463,913 B2,  Date of patent:  ** Oct.11,2016");
        db.setRemark("Claim: The omamental design for a snack storage lid for a beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup30.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage31() {
        image db = new image ();
        db.setId(31);
        db.setName("Mixing/Drinking cup");
        db.setAuthor("Inventors: Augusto A.Picozza; Evan Gant; Joongoo Lee");
        db.setInstro("Patent No.: US D767,938 S,  Date of patent:  ** Oct.4,2016");
        db.setRemark("Claim: The omamental design for a mixing/drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup31.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage32() {
        image db = new image ();
        db.setId(32);
        db.setName("Cup");
        db.setAuthor("Inventor: Spiros Margaris");
        db.setImageUrl("/assets/cup32.jpg");
        db.setInstro("Patent No.: US D766,077 S,  Date of patent:  ** Sep.13,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup32.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage33() {
        image db = new image ();
        db.setId(33);
        db.setName("Stackable cup with plate cut-out");
        db.setAuthor("Inventor: Michael Altman");
        db.setInstro("Patent No.: US D9,439,525 B1,  Date of patent:  ** Sep.13,2016");
        db.setRemark("Claim: The omamental design for a stackable cup with plate cut-out, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup33.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage34() {
        image db = new image ();
        db.setId(34);
        db.setName("Stackable cup with plate cut-out");
        db.setAuthor("Inventor: Timothy Dryden Gorbold");
        db.setInstro("Patent No.: US D765,471 S,  Date of patent:  ** Sep.6,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup34.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage35() {
        image db = new image ();
        db.setId(35);
        db.setName("Trainer cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D764,235 S,  Date of patent:  ** Aug.23,2016");
        db.setRemark("Claim: The omamental design for a trainer cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup35.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage36() {
        image db = new image ();
        db.setId(36);
        db.setName("Trainer straw cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D762,419 S,  Date of patent:  ** Aug.2,2016");
        db.setRemark("Claim: The omamental design for a trainer straw cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup36.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage37() {
        image db = new image ();
        db.setId(37);
        db.setName("Spice cup");
        db.setAuthor("Inventors: Aaron Frank Fitchko; Erica Hammack; Robert G. Larkin; William H.Dickson; Jillian Christime Hartke; Michael J.Palmisano; Steven Douglas Richardson");
        db.setInstro("Patent No.: US D761,059 S,  Date of patent:  ** Jul.12,2016");
        db.setRemark("Claim: The omamental design for a spice cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup37.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage38() {
        image db = new image ();
        db.setId(38);
        db.setName("Cup");
        db.setAuthor("Inventors: Norman R.Wainwright; Eric Stimpson; Bruce J.Tomson; Thomas Preidel");
        db.setInstro("Patent No.: US D759,837 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup38.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage39() {
        image db = new image ();
        db.setId(39);
        db.setName("Cup");
        db.setAuthor("Inventors: Norman R.Wainwright; Eric Stimpson; Bruce J.Tomson; Thomas Preidel");
        db.setInstro("Patent No.: US D759,836 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup39.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage40() {
        image db = new image ();
        db.setId(40);
        db.setName("Dosing cup");
        db.setAuthor("Inventors: Luiz Fernando Arenas; Diogo Matos Rodrigues");
        db.setInstro("Patent No.: US D759,515 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a dosing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup40.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage41() {
        image db = new image ();
        db.setId(41);
        db.setName("Shoe-shape cup");
        db.setAuthor("Inventors: Luiz Fernando Arenas; Diogo Matos Rodrigues");
        db.setInstro("Patent No.: US D759,515 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a dosing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup41.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage42() {
        image db = new image ();
        db.setId(42);
        db.setName("Straw transition cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D755,572 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a straw transition cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup42.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage43() {
        image db = new image ();
        db.setId(43);
        db.setName("Paint spray gun cup");
        db.setAuthor("Inventor: Peter Dettlaff");
        db.setInstro("Patent No.: US D758,533 S,  Date of patent:  ** Jun.7,2016");
        db.setRemark("Claim: The omamental design for a paint spray gun cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup43.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage44() {
        image db = new image ();
        db.setId(44);
        db.setName("Measuring cup");
        db.setAuthor("Inventor: Shigeru Yamazaki");
        db.setInstro("Patent No.: US D758,215 S,  Date of patent:  ** Jun.7,2016");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup44.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage45() {
        image db = new image ();
        db.setId(45);
        db.setName("Can cup");
        db.setAuthor("Inventor: Robert Kushner");
        db.setInstro("Patent No.: US D756,712 S,  Date of patent:  ** May.24,2016");
        db.setRemark("Claim: The omamental design for a can cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup45.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage46() {
        image db = new image ();
        db.setId(46);
        db.setName("Serving cup");
        db.setAuthor("Inventors: Jason Covey; Ian Graves; Thomas Gurski");
        db.setInstro("Patent No.: US D756,771 S,  Date of patent:  ** May.24,2016");
        db.setRemark("Claim: The omamental design for a serving cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup46.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage47() {
        image db = new image ();
        db.setId(47);
        db.setName("Measuring cup");
        db.setAuthor("Inventor: Joseph Kent");
        db.setInstro("Patent No.: US D756,246 S,  Date of patent:  ** May.17,2016");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup47.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage48() {
        image db = new image ();
        db.setId(48);
        db.setName("Cup");
        db.setAuthor("Inventor: Eulbum Lee");
        db.setInstro("Patent No.: US D755,568 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup48.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage49() {
        image db = new image ();
        db.setId(49);
        db.setName("Cup");
        db.setAuthor("Inventor: Shun-Wen Cheng");
        db.setInstro("Patent No.: US D755,571 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup49.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage50() {
        image db = new image();
        db.setId(50);
        db.setName("Cup");
        db.setAuthor("Inventors: Vincent Valderrama; Dmitryly Faktorovich");
        db.setImageUrl("/assets/cup50.jpg");
        db.setInstro("Patent No.: US D755,016 S,  Date of patent:  ** May.3,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup50.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();

    }


    private void addImage51() {
        image db = new image();
        db.setId(51);
        db.setName("Drinking cup");
        db.setAuthor("Inventors: Cecile Thalmann; Elodie Jeanne Claudine Thomas");
        db.setInstro("Patent No.: US D748,434 S,  Date of patent:  ** Feb.2,2016");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup51.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage52() {
        image db = new image();
        db.setId(52);
        db.setName("Drinking cup");
        db.setAuthor("Inventors: Cecile Thalmann; Elodie Jeanne Claudine Thomas");
        db.setInstro("Patent No.: US D748,435 S,  Date of patent:  ** Feb.2,2016");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup52.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage53() {
        image db = new image();
        db.setId(53);
        db.setName("Snack cup");
        db.setAuthor("Inventor: Abraham Cruz");
        db.setInstro("Patent No.: US D748,497 S,  Date of patent:  ** Feb.2,2016");
        db.setRemark("Claim: The omamental design for a snack cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup53.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage54() {
        image db = new image();
        db.setId(54);
        db.setName("Smoking cup");
        db.setAuthor("Inventor: Jeffery Alan Elson");
        db.setInstro("Patent No.: US D750,836 S,  Date of patent:  ** Mar.1,2016");
        db.setRemark("Claim: The omamental design for a smoking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup54.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage55() {
        image db = new image();
        db.setId(55);
        db.setName("Single serving cup");
        db.setAuthor("Inventors: David Goldstein; Shay Zohar");
        db.setInstro("Patent No.: US D752,972 S,  Date of patent:  ** Apr.5,2016");
        db.setRemark("Claim: The omamental design for a single serving cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup55.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage56() {
        image db = new image();
        db.setId(56);
        db.setName("Beverage shaker cup");
        db.setAuthor("Inventor: Robert Charlton");
        db.setInstro("Patent No.: US D751,344 S,  Date of patent:  ** Mar.15,2016");
        db.setRemark("Claim: The omamental design for a beverage shaker cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup56.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage57() {
        image db = new image();
        db.setId(57);
        db.setName("Drinking cup vessel");
        db.setAuthor("Inventor: Nouri Edward Hakim");
        db.setInstro("Patent No.: US D747,927 S,  Date of patent:  ** Jan.26,2016");
        db.setRemark("Claim: The omamental design for a drinking cup vessel, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup57.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage58() {
        image db = new image();
        db.setId(58);
        db.setName("Drinking cup vessel");
        db.setAuthor("Inventor: Nouri Edward Hakim");
        db.setInstro("Patent No.: US D747,149 S,  Date of patent:  ** Jan.12,2016");
        db.setRemark("Claim: The omamental design for a drinking cup vessel, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup58.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage59() {
        image db = new image();
        db.setId(59);
        db.setName("Beverage cup");
        db.setAuthor("Inventors: Christopher Anzalone; Robert Kushner");
        db.setInstro("Patent No.: US D746,636 S,  Date of patent:  ** Jan.5,2016");
        db.setRemark("Claim: The omamental design for a beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup59.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage60() {
        image db = new image();
        db.setId(60);
        db.setName("Reusable menstrual cup");
        db.setAuthor("Inventor: Vilislava Petrova");
        db.setInstro("Patent No.: US D746,452 S,  Date of patent:  ** Dec.29,2015");
        db.setRemark("Claim: The omamental design for a beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup60.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage61() {
        image db = new image();
        db.setId(61);
        db.setName("Sink supported cutlery cup");
        db.setAuthor("Inventor: Dawn Guterman");
        db.setInstro("Patent No.: US D746,417 S,  Date of patent:  ** Dec.29,2015");
        db.setRemark("Claim: The omamental design for a sink supported cutlery cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup61.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage62() {
        image db = new image();
        db.setId(62);
        db.setName("Cup with handles");
        db.setAuthor("Inventors: Jessica Mary Wilson; Monica R.Rush");
        db.setInstro("Patent No.: US D746,109 S,  Date of patent:  ** Dec.29,2015");
        db.setRemark("Claim: The omamental design for a cup with handles, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup62.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage63() {
        image db = new image();
        db.setId(63);
        db.setName("Cup");
        db.setAuthor("Inventors: Jessica Mary Wilson; Monica R.Rush; Samuel D.Silva");
        db.setInstro("Patent No.: US D746,104 S,  Date of patent:  ** Dec.29,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup63.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage64() {
        image db = new image();
        db.setId(64);
        db.setName("Coconut cup");
        db.setAuthor("Inventor: Fadi Sanbar");
        db.setInstro("Patent No.: US D743,744 S,  Date of patent:  ** Nov.24,2015");
        db.setRemark("Claim: The omamental design for a coconut cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup64.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage65() {
        image db = new image();
        db.setId(65);
        db.setName("Pineapple cup");
        db.setAuthor("Inventor: Fadi Sanbar");
        db.setInstro("Patent No.: US D743,743 S,  Date of patent:  ** Nov.24,2015");
        db.setRemark("Claim: The omamental design for a pineapple cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup65.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage66() {
        image db = new image();
        db.setId(66);
        db.setName("Measuring cup");
        db.setAuthor("Inventor: Andrew Schwartz");
        db.setInstro("Patent No.: US D743,279 S,  Date of patent:  ** Nov.17,2015");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup66.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage67() {
        image db = new image();
        db.setId(67);
        db.setName("Cup");
        db.setAuthor("Inventors: Ned R.Pendleton; Ike J.Peterson; Patricia E.Tait; John O'Connor; Jeff Hautzinger");
        db.setInstro("Patent No.: US D743,207 S,  Date of patent:  ** Nov.17,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup67.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage68() {
        image db = new image();
        db.setId(68);
        db.setName("Cup");
        db.setAuthor("Inventors: Ned R.Pendleton; Ike J.Peterson; Patricia E.Tait; John O'Connor; Jeff Hautzinger");
        db.setInstro("Patent No.: US D743,206 S,  Date of patent:  ** Nov.17,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup68.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage69() {
        image db = new image();
        db.setId(69);
        db.setName("Cup");
        db.setAuthor("Inventors: Ned R.Pendleton; Ike J.Peterson; Patricia E.Tait; John O'Connor; Jeff Hautzinger");
        db.setInstro("Patent No.: US D743,206 S,  Date of patent:  ** Nov.17,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup69.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage70() {
        image db = new image();
        db.setId(70);
        db.setName("Cup with divider");
        db.setAuthor("Inventors: Aaron Switz; Andrea Switz");
        db.setInstro("Patent No.: US D742,697 S,  Date of patent:  ** Nov.10,2015");
        db.setRemark("Claim: The omamental design for a cup with divider, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup70.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage71() {
        image db = new image();
        db.setId(71);
        db.setName("Cup");
        db.setAuthor("Inventors: Ned R.Pendleton; Ike J.Peterson; Patricia E.Tait; John O'Connor; Jeff Hautzinger");
        db.setInstro("Patent No.: US D742,695 S,  Date of patent:  ** Nov.10,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup71.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage72() {
        image db = new image();
        db.setId(72);
        db.setName("Tiki cup");
        db.setAuthor("Inventor: Fadi Sanbar");
        db.setInstro("Patent No.: US D741,109 S,  Date of patent:  ** Oct.20,2015");
        db.setRemark("Claim: The omamental design for a tiki cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup72.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage73() {
        image db = new image();
        db.setId(73);
        db.setName("Cup for a sippy cup");
        db.setAuthor("Inventor: Fadi Sanbar");
        db.setInstro("Patent No.: US D740,667 S,  Date of patent:  ** Oct.13,2015");
        db.setRemark("Claim: The omamental design for a cup for a sippy cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup73.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage74() {
        image db = new image();
        db.setId(74);
        db.setName("Cup");
        db.setAuthor("Inventors: James Maki; Eric T.Henderson");
        db.setInstro("Patent No.: US D740,655 S,  Date of patent:  ** Oct.13,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup74.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage75() {
        image db = new image();
        db.setId(75);
        db.setName("Drinking cup");
        db.setAuthor("Inventor: Connie Wang");
        db.setInstro("Patent No.: US D736,035 S,  Date of patent:  ** Aug.11,2015");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup75.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage76() {
        image db = new image();
        db.setId(76);
        db.setName("Cup");
        db.setAuthor("Inventors: Debra Brady; Eric Thomas Henderson; James J.Maki");
        db.setInstro("Patent No.: US D735,574 S,  Date of patent:  ** Aug.4,2015");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup76.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage77() {
        image db = new image();
        db.setId(77);
        db.setName("Cup");
        db.setAuthor("Inventors: Martin Eduardo Broen; Christopher Erlin Granneberg");
        db.setInstro("Patent No.: US D734,640 S,  Date of patent:  ** Jul.21,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup77.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage78() {
        image db = new image();
        db.setId(78);
        db.setName("Bowl and cup combination");
        db.setAuthor("Inventor: Steve Ginsburg");
        db.setInstro("Patent No.: US D734,641 S,  Date of patent:  ** Jul.21,2015");
        db.setRemark("Claim: The omamental design for a bowl and cup combination, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup78.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage79() {
        image db = new image();
        db.setId(79);
        db.setName("Drinking cup");
        db.setAuthor("Inventor: Elodie Thomas");
        db.setInstro("Patent No.: US D734,095 S,  Date of patent:  ** Jul.14,2015");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup79.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage80() {
        image db = new image();
        db.setId(80);
        db.setName("Cup");
        db.setAuthor("Inventors: Debra Brady; Eric Thomas Henderson; James J.Maki");
        db.setInstro("Patent No.: US D733,555 S,  Date of patent:  ** Jul.7,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup80.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage81() {
        image db = new image();
        db.setId(81);
        db.setName("Drinking cup");
        db.setAuthor("Inventor: Eric Pisarevsky");
        db.setInstro("Patent No.: US D733,496 S,  Date of patent:  ** Jul.7,2015");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup81.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage82() {
        image db = new image();
        db.setId(82);
        db.setName("Cup");
        db.setAuthor("Inventors: Otto Schroeder; Annette Gucciardo");
        db.setInstro("Patent No.: US D732,949 S,  Date of patent:  ** Jun.30,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup82.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage83() {
        image db = new image();
        db.setId(83);
        db.setName("Brew funnel drip cup");
        db.setAuthor("Inventor: Chris S.Anderson");
        db.setInstro("Patent No.: US D732,906 S,  Date of patent:  ** Jun.30,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup83.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage84() {
        image db = new image();
        db.setId(84);
        db.setName("Cup");
        db.setAuthor("Inventor: Adam Liu");
        db.setInstro("Patent No.: US D732,342 S,  Date of patent:  ** Jun.23,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup84.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage85() {
        image db = new image();
        db.setId(85);
        db.setName("Insulated beverage cup");
        db.setAuthor("Inventor: Michael Romley");
        db.setInstro("Patent No.: US D732,343 S,  Date of patent:  ** Jun.23,2015");
        db.setRemark("Claim: The omamental design for an insulated beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup85.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage86() {
        image db = new image();
        db.setId(86);
        db.setName("Cup");
        db.setAuthor("Inventor: Karen Lin");
        db.setInstro("Patent No.: US D730,695 S,  Date of patent:  ** Jun.2,2015");
        db.setRemark("Claim: The omamental design for an insulated beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup86.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage87() {
        image db = new image();
        db.setId(87);
        db.setName("Cup with handle and lid");
        db.setAuthor("Inventor: Jin Bo");
        db.setInstro("Patent No.: US D730,121 S,  Date of patent:  ** May.26,2015");
        db.setRemark("Claim: The omamental design for a cup with handle and lid, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup87.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage88() {
        image db = new image();
        db.setId(88);
        db.setName("Cup");
        db.setAuthor("Inventors: Christian Wilhelm Carstensen; Michael Ring; Mads Surel");
        db.setInstro("Patent No.: US D728,314 S,  Date of patent:  ** May.5,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup88.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage89() {
        image db = new image();
        db.setId(89);
        db.setName("Beverage cup");
        db.setAuthor("Inventor: Jamie Forsyth");
        db.setInstro("Patent No.: US D727,684 S,  Date of patent:  ** Apr.28,2015");
        db.setRemark("Claim: The omamental design for a beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup89.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage90() {
        image db = new image();
        db.setId(90);
        db.setName("Combined cup and saucer");
        db.setAuthor("Inventor: Barbara Schmidt");
        db.setInstro("Patent No.: US D727,683 S,  Date of patent:  ** Apr.28,2015");
        db.setRemark("Claim: The omamental design for a combined cup and saucer, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup90.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage91() {
        image db = new image();
        db.setId(91);
        db.setName("Cup");
        db.setAuthor("Inventor: Chien-chih Lai");
        db.setInstro("Patent No.: US D727,106 S,  Date of patent:  ** Apr.21,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup91.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage92() {
        image db = new image();
        db.setId(92);
        db.setName("Cup");
        db.setAuthor("Inventors: Martin Eduardo Broen; Christopher Erlin Granneberg");
        db.setInstro("Patent No.: US D726,502 S,  Date of patent:  ** Apr.14,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup92.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage93() {
        image db = new image();
        db.setId(93);
        db.setName("Cookie dunk cup");
        db.setAuthor("Inventor: Sam Feller");
        db.setInstro("Patent No.: US D724,899 S,  Date of patent:  ** Mar.24,2015");
        db.setRemark("Claim: The omamental design for a cookie dunk cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup93.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage94() {
        image db = new image();
        db.setId(94);
        db.setName("Cup");
        db.setAuthor("Inventors: Thomas Koll Porter Gieske; Tracie L.C. Wilson");
        db.setInstro("Patent No.: US D724,897 S,  Date of patent:  ** Mar.24,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup94.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage95() {
        image db = new image();
        db.setId(95);
        db.setName("Cup");
        db.setAuthor("Inventors: Vincent Valderrama; Dmitriy Faktorovich");
        db.setInstro("Patent No.: US D723,866 S,  Date of patent:  ** Mar.10,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup95.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage96() {
        image db = new image();
        db.setId(96);
        db.setName("Coffee cup");
        db.setAuthor("Inventor: Thomas Jerry Miller");
        db.setInstro("Patent No.: US D722,830 S,  Date of patent:  ** Feb.24,2015");
        db.setRemark("Claim: The omamental design for a coffee cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup96.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage97() {
        image db = new image();
        db.setId(97);
        db.setName("Cup");
        db.setAuthor("Inventor: Betania Maria Del Mar Menendez");
        db.setInstro("Patent No.: US D722,823 S,  Date of patent:  ** Feb.24,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup97.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage98() {
        image db = new image();
        db.setId(98);
        db.setName("Bottle");
        db.setAuthor("Inventor: Lance Olson");
        db.setInstro("Patent No.: US D720,625 S,  Date of patent:  ** Jan.6,2015");
        db.setRemark("Claim: The omamental design for a bottle, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup98.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage99() {
        image db = new image();
        db.setId(99);
        db.setName("Cup");
        db.setAuthor("Inventors: Vincent Valderrama; Dmitriy Faktorovich");
        db.setInstro("Patent No.: US D722,249 S,  Date of patent:  ** Feb.10,2015");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup99.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage100() {
        image db = new image();
        db.setId(100);
        db.setName("Cup");
        db.setAuthor("Inventor: Konstantin Grcic");
        db.setInstro("Patent No.: US D719,785 S,  Date of patent:  ** Dec.23,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup100.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage101() {
        image db = new image();
        db.setId(101);
        db.setName("Insulated cup");
        db.setAuthor("Inventors: Rafael Rosas Gonzales; Elias Ortiz");
        db.setInstro("Patent No.: US D718,577 S,  Date of patent:  ** Dec.2,2014");
        db.setRemark("Claim: The omamental design for a insulated cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup101.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage102() {
        image db = new image();
        db.setId(102);
        db.setName("Starter cup");
        db.setAuthor("Inventor: Peter Roehrig");
        db.setInstro("Patent No.: US D718,090 S,  Date of patent:  ** Nov.25,2014");
        db.setRemark("Claim: The omamental design for a starter cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup102.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage103() {
        image db = new image();
        db.setId(103);
        db.setName("Cup");
        db.setAuthor("Inventors: Arnold Rees; Sandra Archer");
        db.setInstro("Patent No.: US D718,089 S,  Date of patent:  ** Nov.25,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup103.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage104() {
        image db = new image();
        db.setId(104);
        db.setName("Sippy cup");
        db.setAuthor("Inventors: Ares M.Marasligiller; Aldo Javier Barreto");
        db.setInstro("Patent No.: US D718,087 S,  Date of patent:  ** Nov.25,2014");
        db.setRemark("Claim: The omamental design for a sippy cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup104.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage105() {
        image db = new image();
        db.setId(105);
        db.setName("Cup");
        db.setAuthor("Inventor: Elgin R.Kristinik");
        db.setInstro("Patent No.: US D717,606 S,  Date of patent:  ** Nov.18,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup105.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage106() {
        image db = new image();
        db.setId(106);
        db.setName("Cup");
        db.setAuthor("Inventor: Konstantin Grcic");
        db.setInstro("Patent No.: US D715,101 S,  Date of patent:  ** Oct.14,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup106.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage107() {
        image db = new image();
        db.setId(107);
        db.setName("Suction cup");
        db.setAuthor("Inventors: Huisok Pyon; Andrea Beatriz Montes; Steven Bryan Dunn");
        db.setInstro("Patent No.: US D714,126 S,  Date of patent:  ** Sep.30,2014");
        db.setRemark("Claim: The omamental design for a suction cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup107.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage108() {
        image db = new image();
        db.setId(108);
        db.setName("Cup");
        db.setAuthor("Inventors: Arnold Rees; Sandra Archer");
        db.setInstro("Patent No.: US D713,201 S,  Date of patent:  ** Sep.16,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup108.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage109() {
        image db = new image();
        db.setId(109);
        db.setName("Measuring cup");
        db.setAuthor("Inventors: Bruce Mitchell Tharp; Stephanie M.Tharp");
        db.setInstro("Patent No.: US 8,813,563 B2,  Date of patent:  ** Aug.26,2014");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup109.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage110() {
        image db = new image();
        db.setId(110);
        db.setName("Single serving cup");
        db.setAuthor("Inventor: Patrick Albert Gowens");
        db.setInstro("Patent No.: US D710,686 S,  Date of patent:  ** Aug.12,2014");
        db.setRemark("Claim: The omamental design for a single serving cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup110.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage111() {
        image db = new image();
        db.setId(111);
        db.setName("Collapsible cup");
        db.setAuthor("Inventors: Jason A.Blum; John Adkins; Scott Hart; Elise Kiland");
        db.setInstro("Patent No.: US D710,650 S,  Date of patent:  ** Aug.12,2014");
        db.setRemark("Claim: The omamental design for a collapsible cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup111.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage112() {
        image db = new image();
        db.setId(112);
        db.setName("Cup");
        db.setAuthor("Inventor: Sami Ruotsalainen");
        db.setInstro("Patent No.: US D709,331 S,  Date of patent:  ** Jul.22,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup112.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage113() {
        image db = new image();
        db.setId(113);
        db.setName("Disposable cup");
        db.setAuthor("Inventor: Sheng-Hung Lin");
        db.setInstro("Patent No.: US D708,481 S,  Date of patent:  ** Jul.8,2014");
        db.setRemark("Claim: The omamental design for a disposable cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup113.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage114() {
        image db = new image();
        db.setId(114);
        db.setName("Drinking  cup");
        db.setAuthor("Inventor: Ronald Kramer");
        db.setInstro("Patent No.: US D708,480 S,  Date of patent:  ** Jul.8,2014");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup114.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage115() {
        image db = new image();
        db.setId(115);
        db.setName("Drinking  cup");
        db.setAuthor("Inventor: Ronald Kramer");
        db.setInstro("Patent No.: US D708,479 S,  Date of patent:  ** Jul.8,2014");
        db.setRemark("Claim: The omamental design for a drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup115.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage116() {
        image db = new image();
        db.setId(116);
        db.setName("Cup");
        db.setAuthor("Inventor: Michael Sy");
        db.setInstro("Patent No.: US D705,064 S,  Date of patent:  ** May.20,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup116.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage117() {
        image db = new image();
        db.setId(117);
        db.setName("Stackable cup");
        db.setAuthor("Inventor: Marco David Cocci");
        db.setInstro("Patent No.: US D704,003 S,  Date of patent:  ** May.6,2014");
        db.setRemark("Claim: The omamental design for a stackable cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup117.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage118() {
        image db = new image();
        db.setId(118);
        db.setName("Cup");
        db.setAuthor("Inventor: Veronique Maire");
        db.setInstro("Patent No.: US D703,490 S,  Date of patent:  ** Apr.29,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup118.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage119() {
        image db = new image();
        db.setId(119);
        db.setName("Cup");
        db.setAuthor("Inventors: Richard P.Riedel; Elizazbeth H.Apple");
        db.setInstro("Patent No.: US D702,088 S,  Date of patent:  ** Apr.8,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup119.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage120() {
        image db = new image();
        db.setId(120);
        db.setName("Parfait cup");
        db.setAuthor("Inventors: Brian Zomorodi; Loys Larpin");
        db.setInstro("Patent No.: US D699,571 S,  Date of patent:  ** Feb.18,2014");
        db.setRemark("Claim: The omamental design for a parfait cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup120.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage121() {
        image db = new image();
        db.setId(121);
        db.setName("Cup");
        db.setAuthor("Inventor: Beatrice Mariotti");
        db.setInstro("Patent No.: US D699,075 S,  Date of patent:  ** Feb.11,2014");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup121.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage122() {
        image db = new image();
        db.setId(122);
        db.setName("Stackable cup");
        db.setAuthor("Inventor: Marco David Cocci");
        db.setInstro("Patent No.: US D695,076 S,  Date of patent:  ** Dec.10,2013");
        db.setRemark("Claim: The omamental design for a stackable cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup122.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage123() {
        image db = new image();
        db.setId(123);
        db.setName("Measuring cup");
        db.setAuthor("Inventors: Jack Cogan; Brian Cogan");
        db.setInstro("Patent No.: US 8,601,870 B2,  Date of patent:  ** Dec.10,2013");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup123.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage124() {
        image db = new image();
        db.setId(124);
        db.setName("Portion cup");
        db.setAuthor("Inventors: Patrick W.Brown; Jeffrey S.Taggart; Robert D.Schilling");
        db.setInstro("Patent No.: US D694,905 S,  Date of patent:  ** Dec.3,2013");
        db.setRemark("Claim: The omamental design for a portion cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup124.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage125() {
        image db = new image();
        db.setId(125);
        db.setName("Cup");
        db.setAuthor("Inventors: Anne Babette de Wltte; Else Habraken; Patrick Michael van Baal");
        db.setInstro("Patent No.: US D693,673 S,  Date of patent:  ** Nov.19,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup125.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage126() {
        image db = new image();
        db.setId(126);
        db.setName("Cup with attached cover");
        db.setAuthor("Inventor: Anthony M.De Leo");
        db.setInstro("Patent No.: US D693,650 S,  Date of patent:  ** Nov.19,2013");
        db.setRemark("Claim: The omamental design for a cup with attached cover, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup126.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage127() {
        image db = new image();
        db.setId(127);
        db.setName("Trainer cup");
        db.setAuthor("Inventor: Stephen Paul Tollman");
        db.setInstro("Patent No.: US D693,177 S,  Date of patent:  ** Nov.12,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup127.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage128() {
        image db = new image();
        db.setId(128);
        db.setName("Acetabular cup");
        db.setAuthor("Inventors: Michael D.Ries; Karen E.Mohr");
        db.setInstro("Patent No.: US 8,574,306 B2,  Date of patent:  ** Nov.5,2013");
        db.setRemark("Claim: The omamental design for an acetabular cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup128.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage129() {
        image db = new image();
        db.setId(128);
        db.setName("Child's training cup");
        db.setAuthor("Inventors: Raymond J.Trudeau; Maxime R.Richard; Anthony M.De Leo");
        db.setInstro("Patent No.: US D691,848 S,  Date of patent:  ** Oct.22,2013");
        db.setRemark("Claim: The omamental design for a child's training cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup129.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage130() {
        image db = new image();
        db.setId(130);
        db.setName("Dustcup");
        db.setAuthor("Inventors: Christer Engstrom; Torkel Ingre");
        db.setInstro("Patent No.: US 8,539,639 B2,  Date of patent:  ** Sep.24,2013");
        db.setRemark("Claim: The omamental design for a dustcup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup130.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage131() {
        image db = new image();
        db.setId(131);
        db.setName("Cup holding assembly for a food mixing machine");
        db.setAuthor("Inventors: Eugene J.Kozlowski; John K.Barnard");
        db.setInstro("Patent No.: US 8,491,179 B2,  Date of patent:  ** Jul.23,2013");
        db.setRemark("Claim: The omamental design for a cup holding assembly for a food mixing machine, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup131.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage132() {
        image db = new image();
        db.setId(132);
        db.setName("Portion cup");
        db.setAuthor("Inventors: Patrick W.Brown; Jeffrey S.Taggart; Robert D.Schilling");
        db.setInstro("Patent No.: US D690,026 S,  Date of patent:  ** Sep.17,2013");
        db.setRemark("Claim: The omamental design for a portion cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup132.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage133() {
        image db = new image();
        db.setId(133);
        db.setName("Cup");
        db.setAuthor("Inventor: Fu-Chin Hsu");
        db.setInstro("Patent No.: US D688,524 S,  Date of patent:  ** Aug.27,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup133.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage134() {
        image db = new image();
        db.setId(134);
        db.setName("Cup");
        db.setAuthor("Inventor: Laura Maria Lees");
        db.setInstro("Patent No.: US D688,523 S,  Date of patent:  ** Aug.27,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup134.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage135() {
        image db = new image();
        db.setId(135);
        db.setName("Cup");
        db.setAuthor("Inventor: Laura Maria Lees");
        db.setInstro("Patent No.: US D688,521 S,  Date of patent:  ** Aug.27,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup135.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage136() {
        image db = new image();
        db.setId(136);
        db.setName("Cup");
        db.setAuthor("Inventor: Alrlite Plastics Co.");
        db.setInstro("Patent No.: US D688,124 S,  Date of patent:  ** Aug.20,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup136.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage137() {
        image db = new image();
        db.setId(137);
        db.setName("Two-handle cup");
        db.setAuthor("Inventor: Marvin Lao");
        db.setInstro("Patent No.: US D688,100 S,  Date of patent:  ** Aug.20,2013");
        db.setRemark("Claim: The omamental design for a two-handle cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup137.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage138() {
        image db = new image();
        db.setId(138);
        db.setName("Cup");
        db.setAuthor("Inventor: Sung-Ming Hsu");
        db.setInstro("Patent No.: US D688,099 S,  Date of patent:  ** Aug.20,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup138.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage139() {
        image db = new image();
        db.setId(139);
        db.setName("Cup");
        db.setAuthor("Inventors: Amanda Miller; Kent D.Katterheinrich");
        db.setInstro("Patent No.: US D688,098 S,  Date of patent:  ** Aug.20,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup139.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage140() {
        image db = new image();
        db.setId(140);
        db.setName("Protective cup");
        db.setAuthor("Inventor: Shing-Jiu Sheu");
        db.setInstro("Patent No.: US 8,500,669 B2,  Date of patent:  ** Aug.6,2013");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup140.jpg");
        db.setType("2");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage141() {
        image db = new image();
        db.setId(141);
        db.setName("Heating and cooling cup");
        db.setAuthor("Inventor: Pei-Chuan Liu");
        db.setInstro("A heating and cooling cup icludes a cup body, a stirring device, a heating and cooling ship, and a heat sink module. A heat conductive block is disposed under the cup body, the heat conductive block abuts against the heating and cooling chip, the stirring device has a stirring rod disposed in the cup body, and a bottom surface of the heating and cooling chip abuts against a heat conductive block of the heat sink module. A temperature of the cup body is changed through the heating and cooling chip,for cooling or heating liquid food in the cup body, and the liquid food is forced to generate convection through the stirring rod for accelerating a temperature variation process");
        db.setRemark("");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup141.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage142() {
        image db = new image();
        db.setId(142);
        db.setName("Cup lid with integrated container");
        db.setAuthor("Inventor: Ronald Mark BUCK");
        db.setInstro("Cup lid with integrated container(s) that couples with the top of a cup. The cup and cup lid form at least two containment volumes, Embodiments enable easy containment, inclusion of fresh food, transportation and access of solid or liquid in the container and cup without disengagement of the cup lid from the cup. Contents of the lid container may be accessed, partiallly consumed, replaced in the container and resealed at any time as desired by the user. Additionally, an independent drop-in container within the lid cavity may be resealed and removed from the lid cavity and taken to other locations such as home, work, or car. Simplifies eating and drinking from one unified container and cup in a theater or stadium having seats for example that provide one cup-holder per seat. Provides one free hand to hold a child's hand for safety while in stadiums and amusement parks");
        db.setRemark("");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup142.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }








    public Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);

        } else {
            return null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(MainActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();







    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);



//		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//		//将图片保存至SDcard，相机返回后直接在SDcard读取图片，这样可以解决获取的图片太小的问题。
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory())));
//		startActivityForResult(intent, REQUEST_CAMERA);

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == SELECT_FILE)
//                onSelectFromGalleryResult(data);
//            else if (requestCode == REQUEST_CAMERA){
//                onCaptureImageResult(data);
//
//
//            }
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE){
                onSelectFromGalleryResult(data);


                Uri selectedImageUri = data.getData();
                String str = selectedImageUri.toString();

                Log.d("strstr", str);


                if(sample.containsKey(str)){
                    tarID = sample.get(str);
                    Log.d("tarID",""+tarID);

                    Usea = true;

                }else{
                    Usea = false;
                }




            }



            else if (requestCode == REQUEST_CAMERA){
                onCaptureImageResult(data);
                Usea = false;


            }
        }
    }
    public String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }



    private void onCaptureImageResult(Intent data) {





        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        pic = thumbnail;



        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        ivImage.setImageBitmap(resizeBitmap(thumbnail,800));

        try {
            MediaStore.Images.Media.insertImage(getContentResolver(),
                    destination.getAbsolutePath(), System.currentTimeMillis() + ".jpg", null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {


        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pic = bm;

        ivImage.setImageBitmap(resizeBitmap(bm, 800));
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
//        bitmap.recycle();
        return resizedBitmap;
    }



}
