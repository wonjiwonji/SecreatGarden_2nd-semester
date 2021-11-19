package com.example.shingubotanic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class btnfrag_2 extends Fragment {

    ImageButton qr;
    View.OnClickListener cl;
    Intent i;

    public btnfrag_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.btnfrag_2, container, false);

        qr = (ImageButton) view.findViewById(R.id.h_qr);
        IntentIntegrator qrscan = new IntentIntegrator(getActivity());

        //스캔 중...
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrscan.setPrompt("Scanning...");
                qrscan.setBeepEnabled(true);    //인식 시 '삑'소리
                qrscan.initiateScan();
            }
        });
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){   //QR이 없으면
                Toast.makeText(this.getContext(), "실패!", Toast.LENGTH_SHORT).show();
            } else {    //QR이 있으면
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    switch (obj.getString("number")) {
                        case "1":
                            i = new Intent(getActivity().getApplicationContext(), qr1.class);
                            startActivity(i);
                            break;
                        case "2":
                            i = new Intent(getActivity().getApplicationContext(), qr2.class);
                            startActivity(i);
                            break;
                    }
                } catch(JSONException e) {
                    Toast.makeText(this.getContext(), result.getContents(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}