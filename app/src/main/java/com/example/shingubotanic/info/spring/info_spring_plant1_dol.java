package com.example.shingubotanic.info.spring;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.shingubotanic.MainActivity;
import com.example.shingubotanic.R;
import com.example.shingubotanic.info.info;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;

import static androidx.core.content.ContextCompat.getSystemService;

public class info_spring_plant1_dol extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_spring_plant1_dol";   //돌단풍

    public static info_spring_plant1_dol getInstance(){
        info_spring_plant1_dol ispd1 = new info_spring_plant1_dol();
        return ispd1;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.info_spring_plant1_dol, container);

        cancel = (ImageButton) v1.findViewById(R.id.cancel);
        img1 = (ImageView) v1.findViewById(R.id.ispd1_img1);
        img2 = (ImageView) v1.findViewById(R.id.ispd1_img2);
        back = (Button) v1.findViewById(R.id.dol_back);
        next = (Button) v1.findViewById(R.id.dol_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("spring");

        //Storage
        storageRef.child("spring_plant1_dol.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("spring_plant1_dol_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                    case R.id.dol_back:
                        Toast.makeText(getActivity(),"봄의 첫 번째 식물입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dol_next:
                        v1.setVisibility(v1.GONE);
                        info_spring_plant2_soo ispd2 = info_spring_plant2_soo.getInstance();
                        ispd2.show(getFragmentManager(), info_spring_plant2_soo.TAG_EVENT_DIALOG);
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
