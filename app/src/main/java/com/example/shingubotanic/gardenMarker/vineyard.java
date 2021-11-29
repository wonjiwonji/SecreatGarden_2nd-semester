package com.example.shingubotanic.gardenMarker;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

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
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class vineyard extends DialogFragment implements View.OnClickListener{

    public static final String TAG_EVENT_DIALOG ="vineyard"; //수정  ""

    public vineyard(){} //포도원(14)

    public static vineyard getInstance() {
        vineyard vin = new vineyard(); //수정 변수명 스펠링 앞세개
        return vin; //수정
    }

    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sacedInstanceState){
        View v = inflater.inflate(R.layout.vineyard,container);// xml명 변경
        Button cancel =(Button) v.findViewById(R.id.cancel);
        TextView vinE = (TextView) v.findViewById(R.id.vinE);
        final ImageView vin =(ImageView) v.findViewById(R.id.vin);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com");
        StorageReference storageRef = storage.getReference();
        String vine = "vin.jpg";

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("vineyard");
        DatabaseReference dbRefEn = database.getReference("vineyardEn");

        Locale sysLocale = getResources().getConfiguration().locale;
        String strLang = sysLocale.getLanguage();

        //Storage
        storageRef.child(vine).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공시
                Glide.with(Objects.requireNonNull(getContext()))
                        .load(uri)
                        .into(vin);

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
                String value = dataSnapshot.getValue(String.class); //dataSnapshot(객체)을 통해서 데이터가 전달됨
                vinE.setText(value);
//              Log.d(TAG, "Value is: " + value);
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
                    String value = dataSnapshot.getValue(String.class); //dataSnapshot(객체)을 통해서 데이터가 전달됨
                    vinE.setText(value);
//              Log.d(TAG, "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        }

        cancel.setOnClickListener(this);
        setCancelable(false);
        return v;

    }

    @Override
    public void onClick(View v) {
        dismiss();

    }
}
