package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shingubotanic.guide.guide;

public class home extends AppCompatActivity {
    private String TAG = "VideoActivity";

    ImageButton gui,wea,cou,info,shop,fore;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        gui = (ImageButton) findViewById(R.id.h_guide);
        wea = (ImageButton) findViewById(R.id.h_weathercourse);
        cou = (ImageButton) findViewById(R.id.h_course);
        info = (ImageButton) findViewById(R.id.h_info);
        shop = (ImageButton) findViewById(R.id.h_shop);
        fore = (ImageButton) findViewById(R.id.h_foreign);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        Toolbar toolbar2 = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar2);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.h_guide:
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                    case R.id.h_weathercourse:
                        i = new Intent(getApplicationContext(), weathercou.class);
                        startActivity(i);
                        break;
                    case  R.id.h_course:
                        i = new Intent(getApplicationContext(), course.class);
                        startActivity(i);
                        break;
                    case R.id.h_info:
                        i = new Intent(getApplicationContext(), info.class);
                        startActivity(i);
                        break;
                    case R.id.h_shop:
                        i = new Intent(getApplicationContext(), shop.class);
                        startActivity(i);
                        break;
                    case R.id.h_foreign:
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