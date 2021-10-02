package com.example.shingubotanic;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class course extends AppCompatActivity implements OnMapReadyCallback {

    ImageButton back, nevi_icon;
    View.OnClickListener cl;
    Intent i;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private MapView mapView;
    private static NaverMap naverMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);

        drawerLayout = (DrawerLayout) findViewById(R.id.course);
        drawerView = (View) findViewById(R.id.course_nevi);

        back = (ImageButton) findViewById(R.id.back);
        nevi_icon = (ImageButton) findViewById(R.id.nevi_icon);

        // 네이버 지도
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        //jiwon listview
        // 확장 리스트뷰를 가져온다.
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // 리스트뷰에 데이터를 넣는 곳.
        ChildListData();

        listAdapter = new com.example.shingubotanic.ExpandableListAdapter(this, listDataHeader, listDataChild);

        // 리스트어댑터 세팅
        expListView.setAdapter(listAdapter);

        // 리스트뷰 그룹(부모)뷰를 클릭 했을 경우
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        nevi_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        // 그룹이 열릴 경우 이벤트 발생
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // 그룹이 닫힐 경우 이벤트 발생
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        // 차일드 뷰를 눌렀을 경우 이벤트 발생
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                return false;
//            }

            //지원 0921
//            ImageView imageView = (ImageView) findViewById(R.id.child_image);

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
//                //자식 중 "봄코스"를 클릭하면 => 토스트메시지 + 이미지 변경 테스트
//                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "어린이체험코스")
//                {
//                    Toast.makeText(getApplicationContext(), listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + "입니다", Toast.LENGTH_SHORT).show(); //토스트메시지
//                    imageView.setImageResource(R.drawable.shingu_logo); //이미지 뷰 이미지 변경
//                    drawerLayout.closeDrawers();
//                }
//                else {
//                    // TODO Auto-generated method stub
//                    Toast.makeText(
//                            getApplicationContext(),
//                            listDataHeader.get(groupPosition)
//                                    + " : "
//                                    + listDataChild.get(
//                                    listDataHeader.get(groupPosition)).get(
//                                    childPosition), Toast.LENGTH_SHORT)
//                            .show();
//                }
                switch (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)) {
                    case "전체코스" :
                        break;
                    case "어린이체험코스":
                        break;
                    case "어르신추천코스":
                        break;
                    case "단체관람코스" :
                        break;
                    case "커플코스":
                        break;
                    case "산책로코스":
                        break;
                    case "화장실":
                        break;
                    case "주차장":
                        break;
                    case "가든카페":
                        break;
                    case "가든샵":
                        break;

                }
                Toast.makeText(getApplicationContext(), listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + "입니다", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                return false;
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.back:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;

                }
            }
        };
        back.setOnClickListener(cl);
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

//        naverMap.setLayerGroupEnabled(naverMap.LAYER_GROUP_BUILDING, true);
//        //건물표시

        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(37.434412970034, 127.08084512504904),   //위치 지정
                17   //줌 레벨
        );
        naverMap.setCameraPosition(cameraPosition);

    }


    /**
     * 부모 뷰 타이틀 및 차일드 뷰 데이터 넣는 곳
     */
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // 그룹 생성
        listDataHeader.add("전체보기");
        listDataHeader.add("추천코스");
        listDataHeader.add("편의시설");

        // 그룹 내 차일드 뷰 생성
        List<String> top250 = new ArrayList<String>();
        top250.add("전체보기");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("어린이체험코스");
        nowShowing.add("어르신추천코스");
        nowShowing.add("단체관람코스");
        nowShowing.add("커플코스");
        nowShowing.add("산책로코스");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("화장실");
        comingSoon.add("주차장");
        comingSoon.add("가든카페");
        comingSoon.add("가든샵");

        //데이터 적용.
        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

}
