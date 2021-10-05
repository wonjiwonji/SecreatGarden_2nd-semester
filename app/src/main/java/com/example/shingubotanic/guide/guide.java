package com.example.shingubotanic.guide;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.ImageButton;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.shingubotanic.R;
import com.example.shingubotanic.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class guide extends AppCompatActivity {  //관람안내(홈)

    Button intro, info, fee, members, note, street;
    ImageButton back;
    View.OnClickListener cl;
    Intent i;

    ListView myview;
    ArrayList<MyItem> mylist;
    MyAdapter  adapter;

    class MyItem {
        int icon;
        String  text;


        MyItem(int ic, String te) {
            icon = ic; text = te;
        }
    }

    class MyAdapter extends BaseAdapter {
        Context ctx;
        MyAdapter(Context c) {
            ctx = c;
        }
        @Override
        public int getCount() {
            return  mylist.size();
        }
        @Override
        public Object getItem(int position) {
            return  mylist.get(position);
        }
        @Override
        public long getItemId(int position) {
            return  position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img;
            TextView tv;
            EditText pr;

            if (convertView == null) {
                convertView = ((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.guide_item,
                        parent, false);
            }

            ((ImageView)convertView.findViewById(R.id.myimage)).setImageResource(mylist.get(position).icon);
            ((TextView)convertView.findViewById(R.id.mytext)).setText(mylist.get(position).text);
            return convertView;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        back = (ImageButton) findViewById(R.id.guide_back);

        mylist = new ArrayList<MyItem>();
        MyItem  item;
        item = new MyItem(R.drawable.guide_1, "식물원소개");
        mylist.add(item);
        item = new MyItem(R.drawable.guide_2, "관람정보");
        mylist.add(item);
        item = new MyItem(R.drawable.guide_3, "요금안내");
        mylist.add(item);
        item = new MyItem(R.drawable.guide_4, "연간회원");
        mylist.add(item);
        item = new MyItem(R.drawable.guide_5, "유의사항");
        mylist.add(item);
        item = new MyItem(R.drawable.guide_6, "길찾기");
        mylist.add(item);

        adapter = new MyAdapter(this);
        myview = (ListView) findViewById(R.id.listview);
        myview.setAdapter(adapter);

        myview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //식물원 소개
                        i = new Intent(getApplicationContext(), guide_intro.class);
                        startActivity(i);
                        break;
                    case 1: //관람정보
                        i = new Intent(getApplicationContext(), guide_info.class);
                        startActivity(i);
                        break;
                    case 2:  //요금안내
                        i = new Intent(getApplicationContext(), guide_fee.class);
                        startActivity(i);
                        break;
                    case 3:  //연간회원
                        i = new Intent(getApplicationContext(), guide_members.class);
                        startActivity(i);
                        break;
                    case 4: //유의사항
                        i = new Intent(getApplicationContext(), guide_note.class);
                        startActivity(i);
                        break;
                    case 5:   //길찾기
                        i = new Intent(getApplicationContext(), guide_street.class);
                        startActivity(i);
                        break;


                }
//                if(position == 1) {
//                    Toast.makeText(guide.this, position + "번 선택" , Toast.LENGTH_SHORT).show();
//
//                }
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.guide_back:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
//                    case R.id.intro:    //식물원 소개
//                        i = new Intent(getApplicationContext(), guide_intro.class);
//                        startActivity(i);
//                        break;
//                    case R.id.info: //관람정보
//                        i = new Intent(getApplicationContext(), guide_info.class);
//                        startActivity(i);
//                        break;
//                    case R.id.fee:  //요금안내
//                        i = new Intent(getApplicationContext(), guide_fee.class);
//                        startActivity(i);
//                        break;
//                    case R.id.members:  //연간회원
//                        i = new Intent(getApplicationContext(), guide_members.class);
//                        startActivity(i);
//                        break;
//                    case R.id.note: //유의사항
//                        i = new Intent(getApplicationContext(), guide_note.class);
//                        startActivity(i);
//                        break;
//                    case R.id.street:   //길찾기
//                        i = new Intent(getApplicationContext(), guide_street.class);
//                        startActivity(i);
//                        break;
                }
            }
        };
        back.setOnClickListener(cl);
//        intro.setOnClickListener(cl);
//        info.setOnClickListener(cl);
//        fee.setOnClickListener(cl);
//        members.setOnClickListener(cl);
//        note.setOnClickListener(cl);
//        street.setOnClickListener(cl);
    }



}