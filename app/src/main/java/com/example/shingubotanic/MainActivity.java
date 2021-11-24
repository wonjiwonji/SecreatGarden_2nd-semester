package com.example.shingubotanic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoview;
    private Button button;
    Intent i;
    View.OnClickListener cl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoview = (VideoView) findViewById(R.id.videoview);
        button = (Button) findViewById(R.id.button);
        //play video
        mVideoview.setVideoURI( Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.loading_real));
        mVideoview.start();
        //loop
        mVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                }
            }
        };
        button.setOnClickListener(cl);


    }
}
