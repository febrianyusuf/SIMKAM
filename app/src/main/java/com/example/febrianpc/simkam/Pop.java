package com.example.febrianpc.simkam;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * Created by Febrian Pc on 3/16/2018.
 */

public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.popwindows);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels ;
        int height = dm.heightPixels;

      //ImageView prevMyImage = findViewById(R.id.pop_imagre_view);
      getWindow().setLayout((int)(width*.8),(int)(height*.4));
      //prevMyImage.setImageURI();
    }
}
