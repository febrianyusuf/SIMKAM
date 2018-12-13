package com.example.febrianpc.simkam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.febrianpc.simkam.Main2Activity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    }
    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, Main4Activity.class);
        //Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}


