package com.example.shingubotanic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.shingubotanic.plantFSpring.springTulip;
import com.example.shingubotanic.plantListF.camellia;
import com.example.shingubotanic.plantListF.flower;
import com.example.shingubotanic.plantListF.mountain;
import com.example.shingubotanic.plantListF.tulip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.inflate;


public class spring extends AppCompatActivity {

    ImageButton back, flower_icon, back_menu, eventView, left_btn, right_btn;
    View.OnClickListener cl;
    Intent i;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private ListView list1;
    LinearLayout webCon1, webCon2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spring);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerView = (View) findViewById(R.id.drawer);

        back = (ImageButton) findViewById(R.id.back);
        flower_icon = (ImageButton) findViewById(R.id.tulip);
        back_menu = (ImageButton) findViewById(R.id.back_menu);
        eventView = (ImageButton) findViewById(R.id.eventView);
        left_btn = (ImageButton) findViewById(R.id.left_btn);
        right_btn = (ImageButton) findViewById(R.id.right_btn);

        list1 = (ListView) findViewById(R.id.list1);

        webCon1 = (LinearLayout) findViewById(R.id.webCon1);
        webCon2 = (LinearLayout) findViewById(R.id.webCon2);

        ArrayList<String> data = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list1.setAdapter(adapter);

//        //데이터 추가
//        data.add("식물1");
//        data.add("식물2");
//        data.add("식물3");
//        adapter.notifyDataSetInvalidated(); //저장완료

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("plantListSpring");

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String val = snapshot.child("plantname").getValue(String.class);
                    data.add(val);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        flower_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {     //listView 클릭 이벤트
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String str = (String) parent.getItemAtPosition(position);
                switch (position){
                    case(0):
                        if (position == 0) {    //튤립
                            springTulip stul = springTulip.getInstance();
                            stul.show(getSupportFragmentManager(), springTulip.TAG_EVENT_DIALOG);
                        } break;
                }
            }
        });


        cl = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.back :
                        i = new Intent(getApplicationContext(), smart.class);
                        startActivity(i);
                        //finish();
                        break;
                    case R.id.back_menu :
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.eventView :
                        i = new Intent(getApplicationContext(), webv.class);
                        startActivity(i);
                        break;
                    case R.id.right_btn :
                        LayoutInflater inflater3 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        inflater3.inflate(R.layout.sub_menu, webCon1, true);
                        webCon2.setVisibility(View.GONE);
                        break;

                    case R.id.left_btn :
                        LayoutInflater inflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        inflater2.inflate(R.layout.sub_menu2, webCon1, true);
                        webCon2.setVisibility(View.GONE);
                        break;

                }
            }
        };
        back.setOnClickListener(cl);
        back_menu.setOnClickListener(cl);
        eventView.setOnClickListener(cl);
        left_btn.setOnClickListener(cl);
        right_btn.setOnClickListener(cl);

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