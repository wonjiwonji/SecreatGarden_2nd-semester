package com.example.shingubotanic.guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.shingubotanic.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class guide_street extends AppCompatActivity {

    ImageButton back;
    ImageView img, img2;
    TextView t1;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_street);

        back = (ImageButton) findViewById(R.id.street_back);
        img = (ImageView) findViewById(R.id.street_img);
        img2 = (ImageView) findViewById(R.id.street_img2);
//        t1 = (TextView) findViewById(R.id.text1);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com");
        StorageReference storageRef = storage.getReference().child("guide");
        String pic = "guide_street_img.jpg";
        String pic2 = "guide_street_img2-1.png";

        //Storage
        storageRef.child(pic).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage2
        storageRef.child(pic2).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img2);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.street_back:
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
    }
}
