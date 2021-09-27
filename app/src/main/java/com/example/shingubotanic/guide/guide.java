package com.example.shingubotanic.guide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shingubotanic.R;
import com.example.shingubotanic.home;

public class guide extends AppCompatActivity {  //관람안내(홈)

    Button intro, info, fee, members, note, street;
    ImageButton back;
    View.OnClickListener cl;
    Intent i;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        back = (ImageButton) findViewById(R.id.guide_back);
        intro = (Button) findViewById(R.id.intro);
        info = (Button) findViewById(R.id.info);
        fee = (Button) findViewById(R.id.fee);
        members = (Button) findViewById(R.id.members);
        note = (Button) findViewById(R.id.note);
        street = (Button) findViewById(R.id.street);


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.guide_back :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                    case R.id.intro:    //식물원 소개
                        i = new Intent(getApplicationContext(), guide_intro.class);
                        startActivity(i);
                        break;
                    case R.id.info: //관람정보
                        i = new Intent(getApplicationContext(), guide_info.class);
                        startActivity(i);
                        break;
                    case R.id.fee:  //요금안내
                        i = new Intent(getApplicationContext(), guide_fee.class);
                        startActivity(i);
                        break;
                    case R.id.members:  //연간회원
                        i = new Intent(getApplicationContext(), guide_members.class);
                        startActivity(i);
                        break;
                    case R.id.note: //유의사항
                        i = new Intent(getApplicationContext(), guide_note.class);
                        startActivity(i);
                        break;
                    case R.id.street:   //길찾기
                        i = new Intent(getApplicationContext(), guide_street.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
        intro.setOnClickListener(cl);
        info.setOnClickListener(cl);
        fee.setOnClickListener(cl);
        members.setOnClickListener(cl);
        note.setOnClickListener(cl);
        street.setOnClickListener(cl);
    }
}
