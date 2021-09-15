package com.example.shingubotanic;

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
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class fragment_1 extends Fragment {

    TextView text;

    public fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = null;
        view = inflater.inflate(R.layout.fragment_1,null);
        text = (TextView)view.findViewById(R.id.frag1text);

        Spannable span = (Spannable) text.getText();
        String url = "https://www.sbg.or.kr/event/event.html?bun=3";  //연결시킬 url주소 입력
        span.setSpan(new URLSpan(url), 5,26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //url표시
        text.setMovementMethod(LinkMovementMethod.getInstance());   //url로 이동
        span.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, 54, Spanned.SPAN_EXCLUSIVE_INCLUSIVE); //글자색
        span.setSpan(new StyleSpan(Typeface.BOLD), 5, 26, Spanned.SPAN_EXCLUSIVE_INCLUSIVE); //Bold글씨체 적용
        span.setSpan(new RelativeSizeSpan(1.4f), 5, 26, Spanned.SPAN_EXCLUSIVE_INCLUSIVE); //start부터 end번째 글자는 다른 글자들의 n배 키우기

        return view;

    }
}