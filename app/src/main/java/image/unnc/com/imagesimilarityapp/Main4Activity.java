package image.unnc.com.imagesimilarityapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Resources res=getResources();
        Bitmap bmp= BitmapFactory.decodeResource(res, R.drawable.cup1);
        Bitmap bmp1= BitmapFactory.decodeResource(res, R.drawable.cup22);

        similarityAlgorithm sm = new similarityAlgorithm();
        double m = sm.distance(bmp,bmp1);

        Log.d("aba", ""+m);
    }
}
