package com.example.shingubotanic.info;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shingubotanic.R;
import com.example.shingubotanic.course;
import com.example.shingubotanic.home;
import com.example.shingubotanic.info.fall.info_fall_plant10_go;
import com.example.shingubotanic.info.fall.info_fall_plant11_yong;
import com.example.shingubotanic.info.fall.info_fall_plant12_bae;
import com.example.shingubotanic.info.fall.info_fall_plant1_ga;
import com.example.shingubotanic.info.fall.info_fall_plant2_gae;
import com.example.shingubotanic.info.fall.info_fall_plant3_dan;
import com.example.shingubotanic.info.fall.info_fall_plant4_go;
import com.example.shingubotanic.info.fall.info_fall_plant5_goo;
import com.example.shingubotanic.info.fall.info_fall_plant6_dong;
import com.example.shingubotanic.info.fall.info_fall_plant7_black;
import com.example.shingubotanic.info.fall.info_fall_plant8_hae;
import com.example.shingubotanic.info.fall.info_fall_plant9_ga;
import com.example.shingubotanic.info.spring.info_spring_plant10_jin;
import com.example.shingubotanic.info.spring.info_spring_plant11_kkang;
import com.example.shingubotanic.info.spring.info_spring_plant12_no;
import com.example.shingubotanic.info.spring.info_spring_plant1_dol;
import com.example.shingubotanic.info.spring.info_spring_plant2_soo;
import com.example.shingubotanic.info.spring.info_spring_plant3_man;
import com.example.shingubotanic.info.spring.info_spring_plant4_white;
import com.example.shingubotanic.info.spring.info_spring_plant5_je;
import com.example.shingubotanic.info.spring.info_spring_plant6_jang;
import com.example.shingubotanic.info.spring.info_spring_plant7_soo;
import com.example.shingubotanic.info.spring.info_spring_plant8_he;
import com.example.shingubotanic.info.spring.info_spring_plant9_mok;
import com.example.shingubotanic.info.summer.info_summer_plant10_bak;
import com.example.shingubotanic.info.summer.info_summer_plant11_tae;
import com.example.shingubotanic.info.summer.info_summer_plant12_ddae;
import com.example.shingubotanic.info.summer.info_summer_plant1_dol;
import com.example.shingubotanic.info.summer.info_summer_plant2_jung;
import com.example.shingubotanic.info.summer.info_summer_plant3_byeong;
import com.example.shingubotanic.info.summer.info_summer_plant4_sum;
import com.example.shingubotanic.info.summer.info_summer_plant5_ki;
import com.example.shingubotanic.info.summer.info_summer_plant6_sum;
import com.example.shingubotanic.info.summer.info_summer_plant7_mool;
import com.example.shingubotanic.info.summer.info_summer_plant8_mae;
import com.example.shingubotanic.info.summer.info_summer_plant9_hae;
import com.example.shingubotanic.info.winter.info_winter_plant1_ae;
import com.example.shingubotanic.info.winter.info_winter_plant2_bok;
import com.example.shingubotanic.qr1;
import com.example.shingubotanic.qr2;
import com.example.shingubotanic.weathercou;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class info extends AppCompatActivity {

    ImageButton back;
    View.OnClickListener cl;
    Intent i;
    EditText stxt;
    ImageButton sbtn;

    infoTab infotab;
    infoList infolist;

    IntentIntegrator qrscan;
    Button scan, p1, p2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        back = (ImageButton) findViewById(R.id.info_back);

        stxt = (EditText) findViewById(R.id.searchText);
        sbtn = (ImageButton) findViewById(R.id.searchBtn);

        infotab = new infoTab();
        infolist = new infoList();

        scan = (Button) findViewById(R.id.scanner);
        qrscan = new IntentIntegrator(this);

        p1 = (Button) findViewById(R.id.plant1);
        p2 = (Button) findViewById(R.id.plant2);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame, infotab).commitAllowingStateLoss();


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.info_back:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                    case R.id.plant1:
                        i = new Intent(getApplicationContext(), qr1.class);
                        startActivity(i);
                        break;
                    case R.id.plant2:
                        i = new Intent(getApplicationContext(), qr2.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
        p1.setOnClickListener(cl);
        p2.setOnClickListener(cl);

        while(sbtn.hasOnClickListeners() == false) {
            sbtn.setOnClickListener(new View.OnClickListener() {
                FragmentTransaction transaction = manager.beginTransaction();
                @Override
                public void onClick(View v) {
                    transaction.replace(R.id.frame, infolist);
                    transaction.commit();
                }
            });
        }

        stxt.addTextChangedListener(new TextWatcher() {   //검색 기능
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {  //텍스트 입력 후
                String searchText = s.toString();
                if(searchText.length() > 0){
                    infolist.list.setFilterText(searchText);
                } else {
                    infolist.list.clearTextFilter();
                }
            }
        });

        //스캔 중...
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrscan.setPrompt("Scanning...");
                qrscan.setBeepEnabled(true);    //인식 시 '삑'소리
                qrscan.initiateScan();
            }
        });

    }

    //스캔 결과
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){   //QR이 없으면
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show();
            } else {    //QR이 있으면
//                Toast.makeText(this, "스캔완료!", Toast.LENGTH_SHORT).show();
//                i = new Intent(getApplicationContext(), course.class);
//                startActivity(i);
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
//                    if (obj.getString("number") == "1") {
//                        Toast.makeText(this, "1입니다", Toast.LENGTH_SHORT).show();
////                        i = new Intent(getApplicationContext(), course.class);
////                        startActivity(i);
//                    } else if (obj.getString("number") == "2"){
//                        Toast.makeText(this, "2입니다.", Toast.LENGTH_SHORT).show();
//
////                        i = new Intent(getApplicationContext(), weathercou.class);
////                        startActivity(i);
//                    } else {
//                        Toast.makeText(this, obj.getString("number"), Toast.LENGTH_SHORT).show();
////                        Toast.makeText(this, "넌누구냣", Toast.LENGTH_SHORT).show();
//
//
//                    }

                } catch(JSONException e) {
                    Toast.makeText(info.this, result.getContents(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    //봄
    public void clickImg1(View v){
        info_spring_plant1_dol ispd1 = info_spring_plant1_dol.getInstance();
        ispd1.show(getSupportFragmentManager(), info_spring_plant1_dol.TAG_EVENT_DIALOG);
    }

    public void clickImg2(View v){
        info_spring_plant2_soo ispd2 = info_spring_plant2_soo.getInstance();
        ispd2.show(getSupportFragmentManager(), info_spring_plant2_soo.TAG_EVENT_DIALOG);
    }

    public void clickImg3(View v){
        info_spring_plant3_man ispd3 = info_spring_plant3_man.getInstance();
        ispd3.show(getSupportFragmentManager(), info_spring_plant3_man.TAG_EVENT_DIALOG);
    }

    public void clickImg4(View v){
        info_spring_plant4_white ispd4 = info_spring_plant4_white.getInstance();
        ispd4.show(getSupportFragmentManager(), info_spring_plant4_white.TAG_EVENT_DIALOG);
    }

    public void clickImg5(View v){
        info_spring_plant5_je ispd5 = info_spring_plant5_je.getInstance();
        ispd5.show(getSupportFragmentManager(), info_spring_plant5_je.TAG_EVENT_DIALOG);
    }

    public void clickImg6(View v){
        info_spring_plant6_jang ispd6 = info_spring_plant6_jang.getInstance();
        ispd6.show(getSupportFragmentManager(), info_spring_plant6_jang.TAG_EVENT_DIALOG);
    }

    public void clickImg7(View v){
        info_spring_plant7_soo ispd7 = info_spring_plant7_soo.getInstance();
        ispd7.show(getSupportFragmentManager(), info_spring_plant7_soo.TAG_EVENT_DIALOG);
    }

    public void clickImg8(View v){
        info_spring_plant8_he ispd8 = info_spring_plant8_he.getInstance();
        ispd8.show(getSupportFragmentManager(), info_spring_plant8_he.TAG_EVENT_DIALOG);
    }

    public void clickImg9(View v){
        info_spring_plant9_mok ispd9 = info_spring_plant9_mok.getInstance();
        ispd9.show(getSupportFragmentManager(), info_spring_plant9_mok.TAG_EVENT_DIALOG);
    }

    public void clickImg10(View v){
        info_spring_plant10_jin ispd10 = info_spring_plant10_jin.getInstance();
        ispd10.show(getSupportFragmentManager(), info_spring_plant10_jin.TAG_EVENT_DIALOG);
    }

    public void clickImg11(View v){
        info_spring_plant11_kkang ispd11 = info_spring_plant11_kkang.getInstance();
        ispd11.show(getSupportFragmentManager(), info_spring_plant11_kkang.TAG_EVENT_DIALOG);
    }

    public void clickImg12(View v){
        info_spring_plant12_no ispd12 = info_spring_plant12_no.getInstance();
        ispd12.show(getSupportFragmentManager(), info_spring_plant12_no.TAG_EVENT_DIALOG);
    }


    //여름
    public void clickImg13(View v){
        info_summer_plant1_dol isspd1 = info_summer_plant1_dol.getInstance();
        isspd1.show(getSupportFragmentManager(), info_summer_plant1_dol.TAG_EVENT_DIALOG);
    }

    public void clickImg14(View v){
        info_summer_plant2_jung isspd2 = info_summer_plant2_jung.getInstance();
        isspd2.show(getSupportFragmentManager(), info_summer_plant2_jung.TAG_EVENT_DIALOG);
    }

    public void clickImg15(View v){
        info_summer_plant3_byeong isspd3 = info_summer_plant3_byeong.getInstance();
        isspd3.show(getSupportFragmentManager(), info_summer_plant3_byeong.TAG_EVENT_DIALOG);
    }

    public void clickImg16(View v){
        info_summer_plant4_sum isspd4 = info_summer_plant4_sum.getInstance();
        isspd4.show(getSupportFragmentManager(), info_summer_plant4_sum.TAG_EVENT_DIALOG);
    }

    public void clickImg17(View v){
        info_summer_plant5_ki isspd5 = info_summer_plant5_ki.getInstance();
        isspd5.show(getSupportFragmentManager(), info_summer_plant5_ki.TAG_EVENT_DIALOG);
    }

    public void clickImg18(View v){
        info_summer_plant6_sum isspd6 = info_summer_plant6_sum.getInstance();
        isspd6.show(getSupportFragmentManager(), info_summer_plant6_sum.TAG_EVENT_DIALOG);
    }

    public void clickImg19(View v){
        info_summer_plant7_mool isspd7 = info_summer_plant7_mool.getInstance();
        isspd7.show(getSupportFragmentManager(), info_summer_plant7_mool.TAG_EVENT_DIALOG);
    }

    public void clickImg20(View v){
        info_summer_plant8_mae isspd8 = info_summer_plant8_mae.getInstance();
        isspd8.show(getSupportFragmentManager(), info_summer_plant8_mae.TAG_EVENT_DIALOG);
    }

    public void clickImg21(View v){
        info_summer_plant9_hae isspd9 = info_summer_plant9_hae.getInstance();
        isspd9.show(getSupportFragmentManager(), info_summer_plant9_hae.TAG_EVENT_DIALOG);
    }

    public void clickImg22(View v){
        info_summer_plant10_bak isspd10 = info_summer_plant10_bak.getInstance();
        isspd10.show(getSupportFragmentManager(), info_summer_plant10_bak.TAG_EVENT_DIALOG);
    }

    public void clickImg23(View v){
        info_summer_plant11_tae isspd11 = info_summer_plant11_tae.getInstance();
        isspd11.show(getSupportFragmentManager(), info_summer_plant11_tae.TAG_EVENT_DIALOG);
    }

    public void clickImg24(View v){
        info_summer_plant12_ddae isspd12 = info_summer_plant12_ddae.getInstance();
        isspd12.show(getSupportFragmentManager(), info_summer_plant12_ddae.TAG_EVENT_DIALOG);
    }

    //가을
    public void clickImg25(View v){
        info_fall_plant1_ga ifpg1 = info_fall_plant1_ga.getInstance();
        ifpg1.show(getSupportFragmentManager(), info_fall_plant1_ga.TAG_EVENT_DIALOG);
    }

    public void clickImg26(View v){
        info_fall_plant2_gae ifpg2 = info_fall_plant2_gae.getInstance();
        ifpg2.show(getSupportFragmentManager(), info_fall_plant2_gae.TAG_EVENT_DIALOG);
    }

    public void clickImg27(View v){
        info_fall_plant3_dan ifpg3 = info_fall_plant3_dan.getInstance();
        ifpg3.show(getSupportFragmentManager(), info_fall_plant3_dan.TAG_EVENT_DIALOG);
    }

    public void clickImg28(View v){
        info_fall_plant4_go ifpg4 = info_fall_plant4_go.getInstance();
        ifpg4.show(getSupportFragmentManager(), info_fall_plant4_go.TAG_EVENT_DIALOG);
    }

    public void clickImg29(View v){
        info_fall_plant5_goo ifpg5 = info_fall_plant5_goo.getInstance();
        ifpg5.show(getSupportFragmentManager(), info_fall_plant5_goo.TAG_EVENT_DIALOG);
    }

    public void clickImg30(View v){
        info_fall_plant6_dong ifpg6 = info_fall_plant6_dong.getInstance();
        ifpg6.show(getSupportFragmentManager(), info_fall_plant6_dong.TAG_EVENT_DIALOG);
    }

    public void clickImg31(View v){
        info_fall_plant7_black ifpg2 = info_fall_plant7_black.getInstance();
        ifpg2.show(getSupportFragmentManager(), info_fall_plant7_black.TAG_EVENT_DIALOG);
    }

    public void clickImg32(View v){
        info_fall_plant8_hae ifpg8 = info_fall_plant8_hae.getInstance();
        ifpg8.show(getSupportFragmentManager(), info_fall_plant8_hae.TAG_EVENT_DIALOG);
    }

    public void clickImg33(View v){
        info_fall_plant9_ga ifpg9 = info_fall_plant9_ga.getInstance();
        ifpg9.show(getSupportFragmentManager(), info_fall_plant9_ga.TAG_EVENT_DIALOG);
    }

    public void clickImg34(View v){
        info_fall_plant10_go ifpg10 = info_fall_plant10_go.getInstance();
        ifpg10.show(getSupportFragmentManager(), info_fall_plant10_go.TAG_EVENT_DIALOG);
    }

    public void clickImg35(View v){
        info_fall_plant11_yong ifpg11 = info_fall_plant11_yong.getInstance();
        ifpg11.show(getSupportFragmentManager(), info_fall_plant11_yong.TAG_EVENT_DIALOG);
    }

    public void clickImg36(View v){
        info_fall_plant12_bae ifpg12 = info_fall_plant12_bae.getInstance();
        ifpg12.show(getSupportFragmentManager(), info_fall_plant12_bae.TAG_EVENT_DIALOG);
    }

    //겨울
    public void clickImg37(View v){
        info_winter_plant1_ae iwpa1 = info_winter_plant1_ae.getInstance();
        iwpa1.show(getSupportFragmentManager(), info_winter_plant1_ae.TAG_EVENT_DIALOG);
    }

    public void clickImg38(View v){
        info_winter_plant2_bok iwpa2 = info_winter_plant2_bok.getInstance();
        iwpa2.show(getSupportFragmentManager(), info_winter_plant2_bok.TAG_EVENT_DIALOG);
    }


}
