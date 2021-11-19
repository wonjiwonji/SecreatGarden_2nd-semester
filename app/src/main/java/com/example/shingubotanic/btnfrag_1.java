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

import androidx.fragment.app.Fragment;

import com.example.shingubotanic.guide.guide;
import com.example.shingubotanic.info.info;


public class btnfrag_1 extends Fragment {

    ImageButton gui, wea, cou, info, shop;
    View.OnClickListener cl;
    Intent i;


    public btnfrag_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.btnfrag_1, container, false);

        gui = (ImageButton) view.findViewById(R.id.h_guide);
        wea = (ImageButton) view.findViewById(R.id.h_weathercourse);
        cou = (ImageButton) view.findViewById(R.id.h_course);
        info = (ImageButton) view.findViewById(R.id.h_info);
        shop = (ImageButton) view.findViewById(R.id.h_shop);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.h_guide:
                        i = new Intent(getActivity().getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                    case R.id.h_weathercourse:
                        i = new Intent(getActivity().getApplicationContext(), weathercou.class);
                        startActivity(i);
                        break;
                    case  R.id.h_course:
                        i = new Intent(getActivity().getApplicationContext(), course.class);
                        startActivity(i);
                        break;
                    case R.id.h_info:
                        i = new Intent(getActivity().getApplicationContext(), info.class);
                        startActivity(i);
                        break;
                    case R.id.h_shop:
                        i = new Intent(getActivity().getApplicationContext(), shop.class);
                        startActivity(i);
                        break;
                }
            }
        };
        gui.setOnClickListener(cl);
        wea.setOnClickListener(cl);
        cou.setOnClickListener(cl);
        info.setOnClickListener(cl);
        shop.setOnClickListener(cl);

        return view;
    }
}