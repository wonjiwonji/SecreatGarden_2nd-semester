package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.List;


public class spring extends AppCompatActivity {

    ImageButton back, flower_icon;
    Button btn_close;
    View.OnClickListener cl;
    Intent i;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spring);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerView = (View) findViewById(R.id.drawer);

        back = (ImageButton) findViewById(R.id.back);
        flower_icon = (ImageButton) findViewById(R.id.tulip);
        btn_close = (Button) findViewById(R.id.btn_close);

        list1 = (ListView) findViewById(R.id.list1);

        List<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list1.setAdapter(adapter);
        //데이터 추가
        data.add("식물1");
        data.add("식물2");
        data.add("식물3");
        adapter.notifyDataSetInvalidated(); //저장완료


        flower_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        cl = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.back:
                        finish();
                }
            }
        };
        back.setOnClickListener(cl);
    }

    //드로워레이아웃 했을때 상태값 받아옴
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {

        //슬라이더
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        //오픈
        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        //슬라이더 닫혔을때
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        //상태가 바꼈을때
        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

}
