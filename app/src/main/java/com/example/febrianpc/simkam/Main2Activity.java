package com.example.febrianpc.simkam;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.app.Dialog;


import com.example.febrianpc.simkam.R;

import java.io.IOException;
import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {
    Button b1,b2,b3;
    SeekBar s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);



        Button b = (Button) findViewById(R.id.button);


        s1 = (SeekBar) findViewById(R.id.seekBar);
        s2 = (SeekBar) findViewById(R.id.seekBar3);
        s3 = (SeekBar) findViewById(R.id.seekBar2);

        //b1 = (Button) findViewById(R.id.button4);
        //b2 = (Button) findViewById(R.id.button2);
        //b3 = (Button) findViewById(R.id.button3);

        final ImageView prevImage = findViewById(R.id.imageView3);
        final String[] aperatureLabel = {"2.8","3.5","4","4.5","5.6","6.7","8","9.5","11","13","16","19","22"};
        //final String[] aperatureRealValue = {"01","02","03","04","05","06","07","08","09","10","11","12","13"};
        final String[] shutterLabel = {"1/1","1/2","1/3","1/4","1/6","1/8","1/10","1/15","1/20","1/30","1/45","1/60","1/90","1/125","1/180","1/250","1/350","1/500","1/750","1/1000","1/1500","1/2000","1/3000","1/4000"};
        final String[] shutterRealValue = {"1","2","3","4","6","8","10","15","20","30","45","60","90","125","180","250","350","500","750","1000","1500","2000","3000","4000"};
        final String[] isoLabel = {"100","200","400","800","1600","3200","6400"};
        final TextView isoValue = findViewById(R.id.textViewIso);
        final TextView aperatureValue = findViewById(R.id.textViewAperature);
        final TextView shutterValue = findViewById(R.id.textViewIso);
        final SeekBar isoSeekbar = findViewById(R.id.seekBar3);
        isoSeekbar.setProgress(0);
        isoSeekbar.setMax((isoLabel.length-1)*10);
        final SeekBar aperatureSeekbar = findViewById(R.id.seekBar);
        aperatureSeekbar.setProgress(0);
        aperatureSeekbar.setMax((aperatureLabel.length-1)*10);
        final SeekBar shutterSeekbar = findViewById(R.id.seekBar2);
        shutterSeekbar.setProgress(0);
        shutterSeekbar.setMax((shutterLabel.length-1)*10);
        isoValue.setText(isoLabel[0]);
        shutterValue.setText(shutterLabel[0]);
        aperatureValue.setText(aperatureLabel[0]);
        aperatureSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress= progress/10;
                aperatureValue.setText(aperatureLabel[progress]);
                progress= progress*10;
                aperatureSeekbar.setProgress(progress);
                ImageManualSetting(isoLabel[(isoSeekbar.getProgress()/10)],String.valueOf(aperatureSeekbar.getProgress()/10),shutterRealValue[(shutterSeekbar.getProgress()/10)]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        shutterSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress= progress/10;
                shutterValue.setText(shutterLabel[progress]);
                progress= progress*10;
                shutterSeekbar.setProgress(progress);
                ImageManualSetting(isoLabel[(isoSeekbar.getProgress()/10)],String.valueOf(aperatureSeekbar.getProgress()/10),shutterRealValue[(shutterSeekbar.getProgress()/10)]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        isoSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress= progress/10;
                isoValue.setText(isoLabel[progress]);
                progress= progress*10;
                isoSeekbar.setProgress(progress);
                ImageManualSetting(isoLabel[(isoSeekbar.getProgress()/10)],String.valueOf(aperatureSeekbar.getProgress()/10),shutterRealValue[(shutterSeekbar.getProgress()/10)]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
 //       b.setOnClickListener(new View.OnClickListener() {
 //           @Override
  //          public void onClick(View v) {
//                ImageManualSetting(isoValue.getText().toString(),aperatureValue.getText().toString(),shutterValue.getText().toString());
//                 startActivity(new Intent(Main2Activity.this,Pop.class));
 //           }
  //      });
    }

    private void ImageManualSetting(String iso, String aperature, String shutter){
        Drawable d;
        final ImageView prevImage = findViewById(R.id.imageView3);
        String filenameImage;
        filenameImage = iso + "_ISO_" + shutter + "_(" + (Integer.parseInt(aperature) + 1) + ").jpg";
        Log.d("name",filenameImage);
        try {
            InputStream inpS = getAssets().open(filenameImage);
            d = Drawable.createFromStream(inpS,null);
            prevImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void b1Clicked(View v)
    {
        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.GONE);
        s3.setVisibility(View.GONE);
    }
    public void b2Clicked(View v)
    {
        s1.setVisibility(View.GONE);
        s2.setVisibility(View.VISIBLE);
        s3.setVisibility(View.GONE);
    }
    public void b3Clicked(View v)
    {
        s1.setVisibility(View.GONE);
        s2.setVisibility(View.GONE);
        s3.setVisibility(View.VISIBLE);
    }

   // public void ShowPopUp (View v){

     //   myDialog.setContentView(R.layout.popwindows);
     //   ImageView imageView = myDialog.findViewById(R.id.imageView3);
     //   Drawable d;
     //   String filenameImage = ImageManualSetting(isoLabel[(isoSeekbar.getProgress()/10)],
     //           String.valueOf(aperatureSeekbar.getProgress()/10), shutterRealValue[(shutterSeekbar.getProgress()/10)]);
     //   try{
     //       //  MediaPlayer mediaPlayer = new MediaPlayer();
     //       //  assetFileDescriptor descriptor = getAssets().openFd( "BEEP-Shutter.mp3");
    //        //  mediaPlayer.setDataSource(descriptor.getFileDesceiptor(), descriptor.getStartOffset(),
    //        //          descriptor.getLength());
    //        //  descriptor.close();

   //         // mediaPlayer.prepare();
    //        // mediaPlayer.start();
   //         InputStream inpS = getAssets().open(filenameImage);
   //         d = Drawable.createFromStream(inpS, null);
   //         imageView.setImageDrawable(d);
   //     } catch (IOException e){
   //         e.printStackTrace();
   //     }

   //     TextView c = myDialog.findViewById (R.id.closePopUp);
   //     //c.setOnClickListener(myDialog.dismiss());
   //     myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
   //     myDialog.show();
   // }
}
