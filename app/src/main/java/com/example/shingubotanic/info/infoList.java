package com.example.shingubotanic.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.shingubotanic.R;
import com.example.shingubotanic.info.spring.info_spring_plant1_dol;
import com.example.shingubotanic.info.spring.info_spring_plant2_soo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class infoList extends Fragment {

    ListView list;
    ArrayList<String> plant;    //식물 정보를 담은 리스트
    ArrayAdapter<String> adapter;
    info info;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_list, container, false);

        list = (ListView) v.findViewById(R.id.plantlist);
        info = new info();
//        info.back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), info.class);
//                startActivity(i);
//            }
//        });

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("plantInfo").child("plantlist");

        plant = new ArrayList<String>();
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot : datasnapshot.getChildren()){    //plantname 갯수만큼
                    String val = snapshot.child("plantname").getValue(String.class);
                    plant.add(val);
                }
                adapter.notifyDataSetChanged(); //list 추가/수정 시 업뎃
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, plant);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) parent.getItemAtPosition(position);
                switch (str){
                    case("돌단풍"):
//                        Toast.makeText(getActivity(), "봄 식물입니다.", Toast.LENGTH_SHORT).show();
                        info_spring_plant1_dol ispd1 = info_spring_plant1_dol.getInstance();
                        ispd1.show(getFragmentManager(), info_spring_plant1_dol.TAG_EVENT_DIALOG);
                        break;
                    case("돌가시나무"):
                        Toast.makeText(getActivity(), "여름 식물입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case("가막살나무"):
                        Toast.makeText(getActivity(), "가을 식물입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case("애기동백나무"):
                        Toast.makeText(getActivity(), "겨울 식물입니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        return v;
    }
}