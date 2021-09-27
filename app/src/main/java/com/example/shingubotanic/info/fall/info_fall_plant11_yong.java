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

public class info_fall_plant11_yong extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_fall_plant11_yong";   //용담

    public static info_fall_plant11_yong getInstance(){
        info_fall_plant11_yong ifpg11 = new info_fall_plant11_yong();
        return ifpg11;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v11 = inflater.inflate(R.layout.info_fall_plant11_yong, container);

        cancel = (ImageButton) v11.findViewById(R.id.cancel);
        img1 = (ImageView) v11.findViewById(R.id.ifpg11_img1);
        img2 = (ImageView) v11.findViewById(R.id.ifpg11_img2);
        back = (Button) v11.findViewById(R.id.yong_back);
        next = (Button) v11.findViewById(R.id.yong_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("fall");

        //Storage
        storageRef.child("fall_plant11_yong.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("fall_plant11_yong_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                    case R.id.yong_back:
                        v11.setVisibility(v11.GONE);
                        info_fall_plant10_go ifpg10 = info_fall_plant10_go.getInstance();
                        ifpg10.show(getFragmentManager(), info_fall_plant10_go.TAG_EVENT_DIALOG);
                        break;
                    case R.id.yong_next:
                        v11.setVisibility(v11.GONE);
                        info_fall_plant12_bae ifpg12 = info_fall_plant12_bae.getInstance();
                        ifpg12.show(getFragmentManager(), info_fall_plant12_bae.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v11;
    }

}
