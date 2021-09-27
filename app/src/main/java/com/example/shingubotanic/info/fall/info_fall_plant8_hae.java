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

public class info_fall_plant8_hae extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_fall_plant8_hae"; //해국

    public static info_fall_plant8_hae getInstance(){
        info_fall_plant8_hae ifpg8 = new info_fall_plant8_hae();
        return ifpg8;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v8 = inflater.inflate(R.layout.info_fall_plant8_hae, container);

        cancel = (ImageButton) v8.findViewById(R.id.cancel);
        img1 = (ImageView) v8.findViewById(R.id.ifpg8_img1);
        img2 = (ImageView) v8.findViewById(R.id.ifpg8_img2);
        back = (Button) v8.findViewById(R.id.hae_back);
        next = (Button) v8.findViewById(R.id.hae_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("fall");

        //Storage
        storageRef.child("fall_plant8_hae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("fall_plant8_hae_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                    case R.id.hae_back:
                        v8.setVisibility(v8.GONE);
                        info_fall_plant7_black ifpg7 = info_fall_plant7_black.getInstance();
                        ifpg7.show(getFragmentManager(), info_fall_plant7_black.TAG_EVENT_DIALOG);
                        break;
                    case R.id.hae_next:
                        v8.setVisibility(v8.GONE);
                        info_fall_plant9_ga ifpg9 = info_fall_plant9_ga.getInstance();
                        ifpg9.show(getFragmentManager(), info_fall_plant9_ga.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v8;
    }


}
