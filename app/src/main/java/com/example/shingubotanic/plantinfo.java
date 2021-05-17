package com.example.shingubotanic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class plantinfo extends AppCompatActivity {

    ImageButton back, search;
    EditText stext;
    View.OnClickListener cl;
    Intent i;
    ListView list;
    ArrayList<PlantList> plant;
    PlantList plist;
    MyAdapter adap;
//    List<PlantList> slist;  //검색 결과를 담은 리스트
    ImageView img;

    class PlantList{
        int pic;
        String name;
        PlantList(int a, String b){
            pic = a;
            name = b;
        }
    }

    class MyAdapter extends BaseAdapter{    //ListView - Adapter - plantlist
        Context con;
        MyAdapter(Context c){
            con = c;
        }

        @Override
        public int getCount() {
            return (plant != null ? plant.size():0);    //null(X)->list / null(o)->0
        }

        @Override
        public Object getItem(int position) {
            return plant.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.plantlist,
                        parent, false); //plantlist.xml로 보여주긔~
            }
            ((ImageView)convertView.findViewById(R.id.picture)).setImageResource(plant.get(position).pic);
            ((TextView)convertView.findViewById(R.id.infotext)).setText(plant.get(position).name);

            return convertView;
        }

//        public void filter(String searchText) {   //필터링 기능 메소드
//            slist.clear();  //사용 전 초기화
//            if(searchText.length() == 0){   //검색 전
//                slist.addAll(plant);
//            } else {    //검색했을 때
//                for(PlantList item:plant){    //plant의 데이터 가져오긔~
//                    if(item.name.contains(searchText)) {
//                        slist.add(item);
//                    }
//                }
//            }
//            notifyDataSetChanged();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantinfo);

        back = (ImageButton) findViewById(R.id.back);
        stext = (EditText) findViewById(R.id.searchtext);
        search = (ImageButton) findViewById(R.id.search);
        list = (ListView) findViewById(R.id.plantlist);
        img = (ImageView) findViewById(R.id.picture);

        //임시
        plant = new ArrayList<PlantList>();
        plist = new PlantList(R.drawable.flower0, "plant0");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower1, "plant1");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower2, "plant2");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower3, "plant3");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower4, "plant4");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower5, "plant5");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower6, "plant6");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower7, "plant7");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower8, "plant8");
        plant.add(plist);
        plist = new PlantList(R.drawable.flower9, "plant9");
        plant.add(plist);


        adap = new MyAdapter(this);
        list.setAdapter(adap);  //ListView - Adapter

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
//        StorageReference storageRef = storage.getReference("plant/");
//        String pic = "flower0.jpg";
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
//        DatabaseReference dbRef = database.getReference("plantlist");

//        //Storage
//        storageRef.child("flower.JPG").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            public void onSuccess(Uri uri) {
//                //이미지 로드 성공시
//                Glide.with(getApplicationContext())
//                        .load(uri)
//                        .into(img);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                //이미지 로드 실패시
//                Log.d("TEST", "error" + exception.getLocalizedMessage());
//            }
//        });

//        //Database
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
////                plant.clear();  //사용 전 초기화;
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String val = snapshot.child("plantname").getValue(String.class);    //"plant0/plantname" ? child().child() ?
//                    plant = new ArrayList<PlantList>();
//                    plist = new PlantList(R.drawable.flower0, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower1, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower2, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower3, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower4, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower5, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower6, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower7, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower8, val);
//                    plant.add(plist);
//                    plist = new PlantList(R.drawable.flower9, val);
//                    plant.add(plist);
////                    Log.d(TAG, "Value is: " + value);
////                    }
//                }
//                adap.notifyDataSetChanged();    //listView에 데이터가 추가/변경 되었을 때 list 업뎃
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
////                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

//        adap = new MyAdapter(this);
//        list.setAdapter(adap);  //ListView - Adapter - plantlist

//        stext.addTextChangedListener(new TextWatcher() {    //검색 기능
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {    //텍스트 바뀌기 전에 실행
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {   //텍스트 바뀌는 순간
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {  //텍스트 바뀌고 난 후
//                String searchText = stext.getText().toString();
//                adap.filter(searchText);
//            }
//        });

    }

}
