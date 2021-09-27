package com.example.shingubotanic.info.summer;

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

public class info_summer_plant3_byeong extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_summer_plant3_byeong";    //병아리꽃나무

    public static info_summer_plant3_byeong getInstance(){
        info_summer_plant3_byeong isspd3 = new info_summer_plant3_byeong();
        return isspd3;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v3 = inflater.inflate(R.layout.info_summer_plant3_byeong, container);

        cancel = (ImageButton) v3.findViewById(R.id.cancel);
        img1 = (ImageView) v3.findViewById(R.id.isspd3_img1);
        img2 = (ImageView) v3.findViewById(R.id.isspd3_img2);
        back = (Button) v3.findViewById(R.id.byeong_back);
        next = (Button) v3.findViewById(R.id.byeong_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("summer");

        //Storage
        storageRef.child("summer_plant3_byeong.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("summer_plant3_byeong_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                    case R.id.byeong_back:
                        v3.setVisibility(v3.GONE);
                        info_summer_plant2_jung isspd2 = info_summer_plant2_jung.getInstance();
                        isspd2.show(getFragmentManager(), info_summer_plant2_jung.TAG_EVENT_DIALOG);
                        break;
                    case R.id.byeong_next:
                        v3.setVisibility(v3.GONE);
                        info_summer_plant4_sum isspd4 = info_summer_plant4_sum.getInstance();
                        isspd4.show(getFragmentManager(), info_summer_plant4_sum.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v3;
    }

}
