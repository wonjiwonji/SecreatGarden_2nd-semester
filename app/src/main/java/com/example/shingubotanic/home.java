package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shingubotanic.guide.guide;
import com.example.shingubotanic.info.info;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class home extends AppCompatActivity {
    private String TAG = "VideoActivity";

    private ViewPager2 mPager, mPager2 ;
    private FragmentStateAdapter pagerAdapter, pagerAdapter2 ;
    private int num_page=4; //ViewPager 넘길 페이지 수
    private int num_page2=2; //ViewPager 넘길 페이지 수

    ImageButton  qr;
    View.OnClickListener cl;
    Intent i;

    IntentIntegrator qrscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        qr = (ImageButton) findViewById(R.id.h_qr);
        qrscan = new IntentIntegrator(this);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        Toolbar toolbar2 = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar2);

        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        mPager2 = findViewById(R.id.viewpager2);
        //Adapter
        pagerAdapter = new MyAdapter(this,num_page);
        pagerAdapter2 = new btnAdapter(this,num_page2);
        mPager.setAdapter(pagerAdapter); //ViewPager랑 Adapter랑 연결
        mPager2.setAdapter(pagerAdapter2);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1000); //시작지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager2.setCurrentItem(1000); //시작지점
        mPager2.setOffscreenPageLimit(2); //최대 이미지 수


        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrscan.setPrompt("Scanning...");
                qrscan.setBeepEnabled(true);    //인식 시 '삑'소리
                qrscan.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){   //QR이 없으면
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show();
            } else {    //QR이 있으면
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    switch (obj.getString("number")) {
                        case "1":
                            i = new Intent(getApplicationContext(), qr1.class);
                            startActivity(i);
                            break;
                        case "2":
                            i = new Intent(getApplicationContext(), qr2.class);
                            startActivity(i);
                            break;
                    }
                } catch(JSONException e) {
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}