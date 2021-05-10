package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapView;

public class spring extends AppCompatActivity {

    ImageButton back;
    View.OnClickListener cl;
    Intent i;
    MapView mapView = new MapView(this);

    ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spring);

        back = (ImageButton) findViewById(R.id.back);
        mapViewContainer.addView(mapView);


        cl = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.back:
                        finish();
                }
            }
        };
        back.setOnClickListener(cl);
    }

}
