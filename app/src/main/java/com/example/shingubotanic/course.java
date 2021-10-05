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
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;

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

    //마커 변수 선언 및 초기화
    private Marker marker1 = new Marker();
    private Marker marker2 = new Marker();
    private Marker marker3 = new Marker();
    private Marker marker4 = new Marker();
    private Marker marker5 = new Marker();
    private Marker marker6 = new Marker();
    private Marker marker7 = new Marker();
    private Marker marker8 = new Marker();
    private Marker marker9 = new Marker();
    private Marker marker10 = new Marker();
    private Marker marker11 = new Marker();
    private Marker marker12 = new Marker();
    private Marker marker13 = new Marker();
    private Marker marker14 = new Marker();
    private Marker marker15 = new Marker();
    private Marker marker16 = new Marker();
    private Marker marker17 = new Marker();
    private Marker marker18 = new Marker();
    private Marker marker19 = new Marker();
    private Marker marker20 = new Marker();
    private Marker marker21 = new Marker();
    private Marker marker22 = new Marker();
    private Marker marker23 = new Marker();
    private Marker marker24 = new Marker();
    private Marker marker25 = new Marker();
    private Marker marker26 = new Marker();
    private Marker marker27 = new Marker();

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

    private void deleteMarker() {
        marker1.setMap(null);
        marker2.setMap(null);
        marker3.setMap(null);
        marker4.setMap(null);
        marker5.setMap(null);
        marker6.setMap(null);
        marker7.setMap(null);
        marker8.setMap(null);
        marker9.setMap(null);
        marker10.setMap(null);
        marker11.setMap(null);
        marker12.setMap(null);
        marker13.setMap(null);
        marker14.setMap(null);
        marker15.setMap(null);
        marker16.setMap(null);
        marker17.setMap(null);
        marker18.setMap(null);
        marker19.setMap(null);
        marker20.setMap(null);
        marker21.setMap(null);
        marker22.setMap(null);
        marker23.setMap(null);
        marker24.setMap(null);
        marker25.setMap(null);
        marker26.setMap(null);
        marker27.setMap(null);

    }

    //마커 커스텀
    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex, String text)
    {
        //마커 크기
        marker.setWidth(marker.SIZE_AUTO);
        marker.setHeight(marker.SIZE_AUTO);
        //원근감 표시
        marker.setIconPerspectiveEnabled(true);
        //아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
//        //마커의 투명도
//        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 텍스트
        marker.setCaptionText(text);
        //마커 표시
        marker.setMap(naverMap);
    }

    //지도 특성
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

        //마커 지정
        setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
        setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, "하늘정원");
        setMarker(marker3, 37.43405849102472, 127.08087070726651, R.drawable.marker_red, 0, "비스타정원");
        setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, "정통정원");
        setMarker(marker5, 37.43441749999999, 127.0810457, R.drawable.marker_red, 0, "작약원");
        setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, "두꺼비분수");
        setMarker(marker7, 37.43453092199691, 127.08023793052985, R.drawable.marker_red, 0, "어린이정원");
        setMarker(marker8, 37.43440920000004, 127.08032980000007, R.drawable.marker_red, 0, "오감정원");
        setMarker(marker9, 37.43431240322188, 127.08000265298142, R.drawable.marker_red, 0, "수목관찰원");
        setMarker(marker10, 37.43516570835482, 127.07920936229561, R.drawable.marker_red, 0, "약초원");
        setMarker(marker11, 37.43537991201445, 127.0788627385964, R.drawable.marker_red, 0, "메타세쿼이아길");
        setMarker(marker12, 37.43497920000003, 127.07983260000003, R.drawable.marker_red, 0, "멸종위기식물원");
        setMarker(marker13, 37.43545487038663, 127.079948650858, R.drawable.marker_red, 0, "그라스품종원");
        setMarker(marker14, 37.4353757, 127.07966280000005, R.drawable.marker_red, 0, "꽃무릇군락지");
        setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, "습지생태원");
        setMarker(marker16, 37.43619319999999, 127.07871640000008, R.drawable.marker_red, 0, "고층습지원");
        setMarker(marker17, 37.436818099999975, 127.07884680000006, R.drawable.marker_red, 0, "포도원");
        setMarker(marker18, 37.437062299999994, 127.07769869999993, R.drawable.marker_red, 0, "단풍나무길");
        setMarker(marker19, 37.43732969999999 , 127.07770260000007, R.drawable.marker_red, 0, "억새원");
        setMarker(marker20, 37.43831869999999 , 127.07702510000001, R.drawable.marker_red, 0, "라일락원");
        setMarker(marker21, 37.43484208519403 , 127.08035347746568, R.drawable.marker_red, 0, "에코센터");
        setMarker(marker22, 37.4349547471053, 127.080159117062, R.drawable.observatory_icon, 0, "전망대");
        setMarker(marker23, 37.433800524222114, 127.08150811566452, R.drawable.info_icon, 0, "가든센터");
        setMarker(marker24, 37.43387937864328, 127.08148560316515, R.drawable.toilet_icon, 0, "화장실");
        setMarker(marker25, 37.433996, 127.081272, R.drawable.toilet_icon, 0, "화장실");
        setMarker(marker26, 37.4337449824962, 127.08189373068059, R.drawable.parking_icon, 0, "주차장");
        setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, "가든카페");

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
