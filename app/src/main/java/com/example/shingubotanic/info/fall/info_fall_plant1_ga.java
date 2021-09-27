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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.shingubotanic.R;
import com.example.shingubotanic.info.info;
import com.example.shingubotanic.info.summer.info_summer_plant2_jung;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;

public class info_fall_plant1_ga extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_fall_plant1_ga";  //가막살나무

    public static info_fall_plant1_ga getInstance(){
        info_fall_plant1_ga ifpg1 = new info_fall_plant1_ga();
        return ifpg1;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.info_fall_plant1_ga, container);

        cancel = (ImageButton) v1.findViewById(R.id.cancel);
        img1 = (ImageView) v1.findViewById(R.id.ifpg1_img1);
        img2 = (ImageView) v1.findViewById(R.id.ifpg1_img2);
        back = (Button) v1.findViewById(R.id.ga_back);
        next = (Button) v1.findViewById(R.id.ga_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("fall");

        //Storage
        storageRef.child("fall_plant1_ga.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("fall_plant1_ga_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                    case R.id.ga_back:
                        Toast.makeText(getActivity(),"가을의 첫 번째 식물입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ga_next:
                        v1.setVisibility(v1.GONE);
                        info_fall_plant2_gae ifpg2  = info_fall_plant2_gae.getInstance();
                        ifpg2.show(getFragmentManager(), info_fall_plant2_gae.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v1;
    }

}
