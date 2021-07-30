package com.example.shingubotanic;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class guide extends AppCompatActivity {

    ImageButton back, intro, info, money, members, note, road;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        back = (ImageButton) findViewById(R.id.back);
        intro = (ImageButton) findViewById(R.id.intro);
        info = (ImageButton) findViewById(R.id.info);
        money = (ImageButton) findViewById(R.id.money);
        members = (ImageButton) findViewById(R.id.members);
        note = (ImageButton) findViewById(R.id.note);
        road = (ImageButton) findViewById(R.id.road);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.back :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                    case R.id.intro:
                        break;
                    case R.id.info:
                        break;
                    case R.id.money:
                        break;
                    case R.id.members:
                        break;
                    case R.id.note:
                        break;
                    case R.id.road:
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
        intro.setOnClickListener(cl);
        info.setOnClickListener(cl);
        money.setOnClickListener(cl);
        members.setOnClickListener(cl);
        note.setOnClickListener(cl);
        road.setOnClickListener(cl);
    }
}
