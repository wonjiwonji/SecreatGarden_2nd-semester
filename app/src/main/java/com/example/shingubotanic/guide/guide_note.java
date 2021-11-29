package com.example.shingubotanic.guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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

import java.util.Locale;

import static android.content.ContentValues.TAG;

public class guide_note extends AppCompatActivity {

    ImageButton back;
    TextView x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_note);

        back = (ImageButton) findViewById(R.id.note_back);
        x0 = (TextView) findViewById(R.id.text0);
        x1 = (TextView) findViewById(R.id.text1);
        x2 = (TextView) findViewById(R.id.text2);
        x3 = (TextView) findViewById(R.id.text3);
        x4 = (TextView) findViewById(R.id.text4);
        x5 = (TextView) findViewById(R.id.text5);
        x6 = (TextView) findViewById(R.id.text6);
        x7 = (TextView) findViewById(R.id.text7);
        x8 = (TextView) findViewById(R.id.text8);
        x9 = (TextView) findViewById(R.id.text9);
        x10 = (TextView) findViewById(R.id.text10);


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("guide");
        DatabaseReference dbRefEn = database.getReference("guideEn");

        Locale sysLocale = getResources().getConfiguration().locale;
        String strLang = sysLocale.getLanguage();

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val0 = dataSnapshot.child("note0").getValue(String.class);
                x0.setText(val0);
                String val1 = dataSnapshot.child("note1").getValue(String.class);
                x1.setText(val1);
                String val2 = dataSnapshot.child("note2").getValue(String.class);
                x2.setText(val2);
                String val3 = dataSnapshot.child("note3").getValue(String.class);
                x3.setText(val3);
                String val4 = dataSnapshot.child("note4").getValue(String.class);
                x4.setText(val4);
                String val5 = dataSnapshot.child("note5").getValue(String.class);
                x5.setText(val5);
                String val6 = dataSnapshot.child("note6").getValue(String.class);
                x6.setText(val6);
                String val7 = dataSnapshot.child("note7").getValue(String.class);
                x7.setText(val7);
                String val8 = dataSnapshot.child("note8").getValue(String.class);
                x8.setText(val8);
                String val9 = dataSnapshot.child("note9").getValue(String.class);
                x9.setText(val9);
                String val10 = dataSnapshot.child("note10").getValue(String.class);
                x10.setText(val10);
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
                    String val0 = dataSnapshot.child("note0").getValue(String.class);
                    x0.setText(val0);
                    String val1 = dataSnapshot.child("note1").getValue(String.class);
                    x1.setText(val1);
                    String val2 = dataSnapshot.child("note2").getValue(String.class);
                    x2.setText(val2);
                    String val3 = dataSnapshot.child("note3").getValue(String.class);
                    x3.setText(val3);
                    String val4 = dataSnapshot.child("note4").getValue(String.class);
                    x4.setText(val4);
                    String val5 = dataSnapshot.child("note5").getValue(String.class);
                    x5.setText(val5);
                    String val6 = dataSnapshot.child("note6").getValue(String.class);
                    x6.setText(val6);
                    String val7 = dataSnapshot.child("note7").getValue(String.class);
                    x7.setText(val7);
                    String val8 = dataSnapshot.child("note8").getValue(String.class);
                    x8.setText(val8);
                    String val9 = dataSnapshot.child("note9").getValue(String.class);
                    x9.setText(val9);
                    String val10 = dataSnapshot.child("note10").getValue(String.class);
                    x10.setText(val10);
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
                    case R.id.note_back:
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);
    }
}
