package com.example.shingubotanic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class home extends MainActivity {
    private String TAG = "VideoActivity";

    ImageButton gui,wea,cou,info,shop,fore;
    View.OnClickListener cl;
    Intent i;

    //프래그먼트 객체 선언
    guide guide;


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

        //프래그먼트 생성
        guide = new guide();

        //프래그먼트 매니저, 프래그먼트 트랜잭션 생성
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //프래그먼트 매니저란? Activity에서  fragment를 관리.
        //프래그먼트 트랜잭션이란? fragment를 동적으로 생성(add)/제거(remove)/교체(replace)하기 위해 사용.


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (v.getId()) {
                    case R.id.h_guide:
                        transaction.replace(R.id.fragment_container, guide);
                        transaction.commitAllowingStateLoss();
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