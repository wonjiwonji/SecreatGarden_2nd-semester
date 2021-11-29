package com.example.shingubotanic.guide;

import android.content.Intent;
import android.media.Image;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Locale;

import static android.content.ContentValues.TAG;

public class guide_fee extends AppCompatActivity {

    ImageButton back;
    ImageView img, img2;
//    TextView t1, t2, t3, t4, t5;
    TextView x1, x2, x3, x4;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_fee);

        back = (ImageButton) findViewById(R.id.fee_back);
        img = (ImageView) findViewById(R.id.fee_img);
        img2 = (ImageView) findViewById(R.id.fee_img2);

//        t1 = (TextView) findViewById(R.id.title1);
//        t2 = (TextView) findViewById(R.id.title2);
//        t3 = (TextView) findViewById(R.id.title3);
//        t4 = (TextView) findViewById(R.id.title4);
//        t5 = (TextView) findViewById(R.id.title5);

        x1 = (TextView) findViewById(R.id.text1);
        x2 = (TextView) findViewById(R.id.text2);
        x3 = (TextView) findViewById(R.id.text3);
        x4 = (TextView) findViewById(R.id.text4);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com");
        StorageReference storageRef = storage.getReference().child("guide");
        String pic = "guide_fee_img1-1.png";
        String pic2 = "guide_fee_img2-2.png";

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("guide");
        DatabaseReference dbRefEn = database.getReference("guideEn");

        Locale sysLocale = getResources().getConfiguration().locale;
        String strLang = sysLocale.getLanguage();

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

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val1 = dataSnapshot.child("fee1").getValue(String.class);
                x1.setText(val1);
                String val2 = dataSnapshot.child("fee2").getValue(String.class);
                x2.setText(val2);
                String val3 = dataSnapshot.child("fee3").getValue(String.class);
                x3.setText(val3);
                String val4 = dataSnapshot.child("fee4").getValue(String.class);
                x4.setText(val4);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        if (strLang == "en") {
            //Database
            dbRefEn.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String val1 = dataSnapshot.child("fee1").getValue(String.class);
                    x1.setText(val1);
                    String val2 = dataSnapshot.child("fee2").getValue(String.class);
                    x2.setText(val2);
                    String val3 = dataSnapshot.child("fee3").getValue(String.class);
                    x3.setText(val3);
                    String val4 = dataSnapshot.child("fee4").getValue(String.class);
                    x4.setText(val4);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        }

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fee_back:
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
    }
}
