package com.example.shingubotanic;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.content.ContentValues.TAG;

public class qr2 extends AppCompatActivity {

    ImageButton back;
    Intent i;
    ImageView pl1, fe1, fe2;
    TextView pltxt, fetxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr2);

        back = (ImageButton) findViewById(R.id.qr2_back);

        pl1 = (ImageView) findViewById(R.id.plant2_img);
        pltxt = (TextView) findViewById(R.id.plant2_txt);

        fe1 = (ImageView) findViewById(R.id.festival2_img1);
        fe2 = (ImageView) findViewById(R.id.festival2_img2);
        fetxt = (TextView) findViewById(R.id.festival2_txt);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("QR code");
        String pic = "aster.jpg";
        String pic1 = "festival2-1.jpg";

        //Storage1
        storageRef.child(pic).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(pl1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage2
        storageRef.child(pic1).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(fe1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("QR code");

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val1 = dataSnapshot.child("QR2").getValue(String.class);
                pltxt.setText(val1);
                String val2 = dataSnapshot.child("QR2-1").getValue(String.class);
                fetxt.setText(val2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
