package com.example.shingubotanic;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import net.daum.mf.map.api.MapView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class plantinfo extends AppCompatActivity {

    ImageButton back, search;
    EditText stext;
    View.OnClickListener cl;
    Intent i;
    ListView list;  //검색 필터링 기능O(textFilterEnable = true)
    ArrayList<PlantList> plant;
    PlantList plist;
    ArrayAdapter adap; //검색 필터링 지원
//    ArrayAdapter adapter;
    List<String> slist;  //검색 기능 데이터 리스트

    class PlantList{
        int pic;
        String name;
        PlantList(int a, String b){
            pic = a;
            name = b;
        }
    }

    class ArrayAdapter extends BaseAdapter {    //ListView와 plantlist.xml 연결시켜주는 다릐~
        Filter filter;
        Context con;
        ArrayAdapter(Context c){
            con = c;
        }

        @Override
        public int getCount() {
            return plant.size();
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantinfo);

        back = (ImageButton) findViewById(R.id.back);
        stext = (EditText) findViewById(R.id.searchtext);
        search = (ImageButton) findViewById(R.id.search);
        list = (ListView) findViewById(R.id.plantlist);

        plant = new ArrayList<PlantList>();
        plist = new PlantList(R.drawable.flower, "plant1");
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

        adap = new ArrayAdapter(this);
        list.setAdapter(adap);  //ListView - Adapter - plantlist

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

        stext.addTextChangedListener(new TextWatcher() {    //검색 기능
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {    //텍스트 바뀌기 전

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {   //텍스트 바뀌는 순간

            }

            @Override
            public void afterTextChanged(Editable s) {  //텍스트 바뀌고 난 후
                String text = stext.getText().toString();
                if(text.length() > 0){
                    list.setFilterText(text);   //필터링 될 문자열 전달
                }else{
                    list.clearTextFilter(); //초기상태로 복귀
                }
            }
        });

    }


    //        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
//        DatabaseReference dbRef = database.getReference("plantlist");
//
//        //Database
//        dbRef.child("plant").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String value = snapshot.child("plantname").getValue(String.class);
//                    plant = new ArrayList<PlantList>();
//                    plist = new PlantList(R.drawable.tv, value);
//                    plant.add(plist);
////              Log.d(TAG, "Value is: " + value);
//                }
//                adap.notifyDataSetChanged();    //listView에 데이터가 추가/변경 되었을 때 list 업뎃
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//        adap = new MyAdapter(this);
//        list.setAdapter(adap);  //ListView - Adapter - plantlist

}
