package com.example.shingubotanic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class home extends MainActivity {
    private String TAG = "VideoActivity";

    ImageButton gui,wea,cou,info,shop,fore;
    View.OnClickListener cl;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        gui = (ImageButton) findViewById(R.id.guide);
        wea = (ImageButton) findViewById(R.id.weathercourse);
        cou = (ImageButton) findViewById(R.id.course);
        info = (ImageButton) findViewById(R.id.info);
        shop = (ImageButton) findViewById(R.id.shop);
        fore = (ImageButton) findViewById(R.id.foreign);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        Toolbar toolbar2 = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar2);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.guide:
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                    case R.id.weathercourse:
                        i = new Intent(getApplicationContext(), weathercou.class);
                        startActivity(i);
                        break;
                    case  R.id.course:
                        i = new Intent(getApplicationContext(), course.class);
                        startActivity(i);
                        break;
                    case R.id.info:
                        i = new Intent(getApplicationContext(), info.class);
                        startActivity(i);
                        break;
                    case R.id.shop:
                        i = new Intent(getApplicationContext(), shop.class);
                        startActivity(i);
                        break;
                    case R.id.foreign:
                        i = new Intent(getApplicationContext(), foreign.class);
                        startActivity(i);
                        break;
                }
            }
        };
        gui.setOnClickListener(cl);
        wea.setOnClickListener(cl);
        cou.setOnClickListener(cl);
        info.setOnClickListener(cl);
        shop.setOnClickListener(cl);
        fore.setOnClickListener(cl);
    }
}