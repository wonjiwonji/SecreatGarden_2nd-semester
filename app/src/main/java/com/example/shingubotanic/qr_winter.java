package com.example.shingubotanic;

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

public class qr_winter extends AppCompatActivity {

    ImageButton back;
    Intent i;
    TextView qwT, qwT2;
    ImageView qwI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_winter);

        back = (ImageButton) findViewById(R.id.qrW_back);
        qwT = (TextView) findViewById(R.id.qrW_txt);
        qwT2 = (TextView) findViewById(R.id.qrW_txt2);
        qwI = (ImageView) findViewById(R.id.qrW_img);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("QR code");
        String pic = "QR_winter.jpg";

        storageRef.child(pic).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(qwI);
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
                String val1 = dataSnapshot.child("QR_winter").getValue(String.class);
                qwT.setText(val1);
                String val2 = dataSnapshot.child("QR_winter2").getValue(String.class);
                qwT2.setText(val2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
