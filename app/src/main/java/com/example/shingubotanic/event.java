package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class event extends MainActivity {
    Toolbar toolbar;
    ImageButton home;
    WebView ev;
    MyClient mc;

    class MyClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        home = (ImageButton) findViewById(R.id.home);
        ev = (WebView) findViewById(R.id.event);
        mc = new MyClient();
        ev.setWebViewClient(mc);
        ev.setWebViewClient(new WebViewClient());

// 페이지 크기를 조정할수있게 허용
        ev.getSettings().setJavaScriptEnabled(true);
// 돋보기 기능을 가능할수있게 하는 기능 허가
        ev.getSettings().setBuiltInZoomControls(true);
        ev.getSettings().setSupportZoom(true);
// 앱의 크기의 맞게 자동 조정해주는 기능 허가
        ev.getSettings().setLoadWithOverviewMode(true);
        ev.getSettings().setUseWideViewPort(true);
        //웹페이지의 주소를 통해 웹페이지를 불러오는 코드
        ev.loadUrl("https://www.sbg.or.kr/event/event.html?bun=3");

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.home :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                }
            }
        };
        home.setOnClickListener(cl);

    }

}