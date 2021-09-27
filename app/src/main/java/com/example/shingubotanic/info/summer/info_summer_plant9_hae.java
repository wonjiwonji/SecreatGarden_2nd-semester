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

public class info_summer_plant9_hae extends DialogFragment {

    public static String TAG_EVENT_DIALOG = "info_summer_plant9_hae";   //해당화

    public static info_summer_plant9_hae getInstance(){
        info_summer_plant9_hae isspd9 = new info_summer_plant9_hae();
        return isspd9;
    }

    ImageButton cancel;
    ImageView img1, img2;
    Button back, next;
    View.OnClickListener cl;
    Intent i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v9 = inflater.inflate(R.layout.info_summer_plant9_hae, container);

        cancel = (ImageButton) v9.findViewById(R.id.cancel);
        img1 = (ImageView) v9.findViewById(R.id.isspd9_img1);
        img2 = (ImageView) v9.findViewById(R.id.isspd9_img2);
        back = (Button) v9.findViewById(R.id.hae_back);
        next = (Button) v9.findViewById(R.id.hae_next);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference("plantInfo").child("summer");

        //Storage
        storageRef.child("summer_plant9_hae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
        storageRef.child("summer_plant9_hae_ex.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

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
                        v9.setVisibility(v9.GONE);
                        info_summer_plant8_mae isspd8 = info_summer_plant8_mae.getInstance();
                        isspd8.show(getFragmentManager(), info_summer_plant8_mae.TAG_EVENT_DIALOG);
                        break;
                    case R.id.hae_next:
                        v9.setVisibility(v9.GONE);
                        info_summer_plant10_bak isspd10 = info_summer_plant10_bak.getInstance();
                        isspd10.show(getFragmentManager(), info_summer_plant10_bak.TAG_EVENT_DIALOG);
                        break;
                }
            }
        };
        cancel.setOnClickListener(cl);
        back.setOnClickListener(cl);
        next.setOnClickListener(cl);
        setCancelable(false);

        return v9;
    }

}
