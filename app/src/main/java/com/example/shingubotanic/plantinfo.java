package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shingubotanic.plantListF.plantCamellia;
import com.example.shingubotanic.plantListF.plantFlower;
import com.example.shingubotanic.plantListF.plantLilac;
import com.example.shingubotanic.plantListF.plantMountain;
import com.example.shingubotanic.plantListF.plantTulip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class plantinfo extends AppCompatActivity {

    ImageButton back, search;
    EditText stext;
    View.OnClickListener cl;
    Intent i;
    ListView list;
    ArrayList<String> plant; //식물 정보를 담은 리스트
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantinfo);

        back = (ImageButton) findViewById(R.id.back);
        stext = (EditText) findViewById(R.id.searchtext);
        search = (ImageButton) findViewById(R.id.search);
        list = (ListView) findViewById(R.id.plantlist);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("plantlist");

        plant = new ArrayList<String>();
        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {  //plantlist 내에 있는 item만큼
                    String val = snapshot.child("plantname").getValue(String.class);
                    plant.add(val);
                }
                adapter.notifyDataSetChanged();    //list 추가/수정 시 업뎃
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, plant);
        list.setAdapter(adapter);  //ListView - Adapter

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {     //listView 클릭 이벤트
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String str = (String) parent.getItemAtPosition(position);
                switch (position){
                    case(1):
                    if (position == 1) {    //(봄)튤립
                        plantTulip tul = plantTulip.getInstance();
                        tul.show(getSupportFragmentManager(), plantTulip.TAG_EVENT_DIALOG);
                    } break;
                    case(2):
                        if (position == 2) {    //(봄)라일락
                            plantLilac lil = plantLilac.getInstance();
                            lil.show(getSupportFragmentManager(), plantLilac.TAG_EVENT_DIALOG);
                        } break;
                    case(5):
                        if (position == 5) {    //(여름)산수국
                            plantMountain mou = plantMountain.getInstance();
                            mou.show(getSupportFragmentManager(), plantMountain.TAG_EVENT_DIALOG);
                        } break;
                    case(9):
                        if (position == 9) {    //(가을)꽃무릇
                            plantFlower flo = plantFlower.getInstance();
                            flo.show(getSupportFragmentManager(), plantFlower.TAG_EVENT_DIALOG);
                        } break;
                    case(14):
                        if (position == 14) {    //(겨울)동백나무
                            plantCamellia cam = plantCamellia.getInstance();
                            cam.show(getSupportFragmentManager(), plantCamellia.TAG_EVENT_DIALOG);
                        } break;
                }
            }
        });

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

//        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com");
//        StorageReference listRef = storage.getReference("plant");

//        plant = new ArrayList<PlantList>();
        //Storage
//        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {    //폴더 내에 모든 이미지 가져오는 메소드
//            public void onSuccess(ListResult listResult) {
//                for (StorageReference item : listResult.getItems()) {   //폴더 내에 모든 item 가져오기
//                    // All the items under listRef.
//                    //레이아웃 가져오기?
//                    item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() { //참조의 item uri 받아오기
//                        @Override
//                        public void onComplete(@NonNull Task<Uri> task) {
//                            if(task.isSuccessful()) {
//                                int i = item.;
//                                plist = new PlantList(i, "plant0");
//                                plant.add(plist);
//                                Glide.with(getApplicationContext())
//                                        .load(task.getResult())
//                                        .into(img);
//                            } else {
//                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception exception) {
//                            //이미지 로드 실패시
//                            Log.d("TEST", "error" + exception.getLocalizedMessage());
//                        }
//                    });
//                }
//                adap.notifyDataSetChanged();
//            }
//        });


        stext.addTextChangedListener(new TextWatcher() {    //검색 기능
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {    //텍스트 바뀌기 전에 실행

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {   //텍스트 바뀌는 순간

            }

            @Override
            public void afterTextChanged(Editable s) {  //텍스트 바뀌고 난 후
                String searchText = s.toString();
                if (searchText.length() > 0) {
                    list.setFilterText(searchText); //textFilterEnabled = true 필수
                } else {
                    list.clearTextFilter();
                }
            }
        });

    }

}
