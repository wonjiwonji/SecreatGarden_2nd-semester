package com.example.shingubotanic.info.fall;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.shingubotanic.R;
import com.example.shingubotanic.info.info;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;

public class info_fall_plant7_black extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_fall_plant7_black";   //흑산도비비추

    public static info_fall_plant7_black getInstance(){
        info_fall_plant7_black ifpg7 = new info_fall_plant7_black();
        return ifpg7;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v7 = inflater.inflate(R.layout.info_fall_plant7_black, container);

        cancel = (ImageButton) v7.findViewById(R.id.cancel);
        img1 = (ImageView) v7.findViewById(R.id.ifpg7_img1);
        img2 = (ImageView) v7.findViewById(R.id.ifpg7_img2);
        back = (Button) v7.findViewById(R.id.black_back);
        next = (Button) v7.findViewById(R.id.black_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("fall");

        //Storage
        storageRef.child("fall_plant7_black.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(Objects.requireNonNull(getContext()))
                        .load(uri)
                        .into(img1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage2
        storageRef.child("fall_plant7_black_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(Objects.requireNonNull(getContext()))
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
                    case R.id.cancel:
                        i = new Intent(getActivity().getApplicationContext(), info.class);
                        startActivity(i);
                        break;
                    case R.id.black_back:
                        v7.setVisibility(v7.GONE);
                        info_fall_plant6_dong ifpg6 = info_fall_plant6_dong.getInstance();
                        ifpg6.show(getFragmentManager(), info_fall_plant6_dong.TAG_EVENT_DIALOG);
                        break;
                    case R.id.black_next:
                        v7.setVisibility(v7.GONE);
                        info_fall_plant8_hae ifpg8 = info_fall_plant8_hae.getInstance();
                        ifpg8.show(getFragmentManager(), info_fall_plant8_hae.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v7;
    }

}
