package com.example.shingubotanic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
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
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.model.Polyline;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.overlay.PathOverlay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class weathercou extends AppCompatActivity implements OnMapReadyCallback {

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
    private final int Fragment_1 = 1;
    private final int Fragment_2 = 2;
    private final int Fragment_3 = 3;
    private final int Fragment_4 = 4;
    private FrameLayout frame;


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

    PathOverlay path = new PathOverlay();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weathercou);

        //프래그 봄 추가
        FragmentView(Fragment_1);

        drawerLayout = (DrawerLayout) findViewById(R.id.course);
        drawerView = (View) findViewById(R.id.course_nevi);

        back = (ImageButton) findViewById(R.id.back);
        nevi_icon = (ImageButton) findViewById(R.id.nevi_icon);

        frame = (FrameLayout) findViewById(R.id.fragment_container);

        // 네이버 지도
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        //polyline
        path.setColor(Color.YELLOW);
        path.setOutlineColor(Color.YELLOW);
        path.setWidth(5);
        path.setPatternImage(OverlayImage.fromResource(R.drawable.poly_up));
        path.setPatternInterval(30);

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
//                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

        // 그룹이 닫힐 경우 이벤트 발생
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();

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
                delete_marker(); //모든 마커 지우기
                path.setMap(null); //폴리라인 지우기
                switch (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)) {
                    case "전체보기":
                        frame.setVisibility(FrameLayout.GONE);
                        insert_marker(0);
                        break;
                    case "봄코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_1);
                        insert_marker(1);
                        insert_polyline(1);
                        break;
                    case "여름코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_2);
                        insert_marker(2);
                        insert_polyline(2);
                        break;
                    case "가을코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_3);
                        break;
                    case "겨울코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_4);
                        break;
                    case "화장실":
                        frame.setVisibility(FrameLayout.GONE);
                        insert_marker(11);
                        break;
                    case "주차장":
                        frame.setVisibility(FrameLayout.GONE);
                        insert_marker(12);
                        break;
                    case "가든카페":
                        frame.setVisibility(FrameLayout.GONE);
                        insert_marker(13);
                        break;
                    case "가든샵":
                        frame.setVisibility(FrameLayout.GONE);
                        insert_marker(14);
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

    //상단 뷰
    private void FragmentView(int fragment) {

        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment) {
            case 1:
                // 첫번 째 프래그먼트 호출
                frag_spring fragment1 = new frag_spring();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;
            case 2:
                // 두번 째 프래그먼트 호출
                frag_summer fragment2 = new frag_summer();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
            case 3:
                // 세번 째 프래그먼트 호출
                frag_fall fragment3 = new frag_fall();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;
            case 4:
                // 네번 째 프래그먼트 호출
                frag_winter fragment4 = new frag_winter();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;
        }

    }

    //마커 커스텀
    private void setMarker(Marker marker, double lat, double lng, int resourceID, int zIndex, String text) {
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

       insert_marker(0);
    }

    //모든 마커 삭제
    private void delete_marker() {
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

    //마커 띄우기
    private void insert_marker(int a) {
        switch (a) {
            case 0:
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
                setMarker(marker19, 37.43732969999999, 127.07770260000007, R.drawable.marker_red, 0, "억새원");
                setMarker(marker20, 37.43831869999999, 127.07702510000001, R.drawable.marker_red, 0, "라일락원");
                setMarker(marker21, 37.43484208519403, 127.08035347746568, R.drawable.marker_red, 0, "에코센터");
                setMarker(marker22, 37.4349547471053, 127.080159117062, R.drawable.observatory_icon, 0, "전망대");
                setMarker(marker23, 37.433800524222114, 127.08150811566452, R.drawable.info_icon, 0, "가든센터");
                setMarker(marker24, 37.43387937864328, 127.08148560316515, R.drawable.toilet_icon, 0, "화장실");
                setMarker(marker25, 37.433996, 127.081272, R.drawable.toilet_icon, 0, "화장실");
                setMarker(marker26, 37.4337449824962, 127.08189373068059, R.drawable.parking_icon, 0, "주차장");
                setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, "가든카페");
                break;
            case 1: //봄코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, "하늘정원");
                setMarker(marker5, 37.43441749999999, 127.0810457, R.drawable.marker_red, 0, "작약원");
                setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, "습지생태원");
                setMarker(marker16, 37.43619319999999, 127.07871640000008, R.drawable.marker_red, 0, "고층습지원");
                setMarker(marker20, 37.43831869999999, 127.07702510000001, R.drawable.marker_red, 0, "라일락원");
                break;
            case 2: //여름코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, "하늘정원");
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, "정통정원");
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, "두꺼비분수");
                setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, "습지생태원");
                setMarker(marker11, 37.43537991201445, 127.0788627385964, R.drawable.marker_red, 0, "메타세쿼이아길");
                break;
            case 3: //가을코스
                break;
            case 4: //겨울코스
                break;

            case 11: //화장실
                setMarker(marker24, 37.43387937864328, 127.08148560316515, R.drawable.toilet_icon, 0, "화장실");
                setMarker(marker25, 37.433996, 127.081272, R.drawable.toilet_icon, 0, "화장실");
                break;
            case 12: //주차장
                setMarker(marker26, 37.4337449824962, 127.08189373068059, R.drawable.parking_icon, 0, "주차장");
                break;
            case 13: //가든카페
                setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, "가든카페");
                break;
            case 14: //가든샵(가든센터)
                setMarker(marker23, 37.433800524222114, 127.08150811566452, R.drawable.info_icon, 0, "가든센터");
                break;
        }

    }

    //폴리라인 띄우기
    private void insert_polyline(int b) {
        switch (b) {
            case 1:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.433893499999975, 127.0808012),//1-3
                        new LatLng(37.43378160000002, 127.08068609999998), //2하늘정원
                        new LatLng(37.43422110000004, 127.0805944),//D곤충생태관
                        new LatLng(37.43428850000004, 127.08082939999997),//4전통정원
                        new LatLng(37.4343151, 127.08108270000002),//4-2
                        new LatLng(37.43441749999999, 127.0810457), //5작약원
                        new LatLng(37.4344465, 127.08083999999997),//5-2
                        new LatLng(37.43439109999999, 127.08017229999996),//5-4
                        new LatLng(37.43466556958514, 127.07969404356436),//5-6
                        new LatLng(37.43504329018735, 127.07952524771031), //5-8
                        new LatLng(37.43529936421379, 127.07952713349141),//15습지생태원
                        new LatLng(37.43546399999999, 127.07959540000002),//15-2
                        new LatLng(37.4355383, 127.07924389999994),//15-4
                        new LatLng(37.43569849999999, 127.07892990000005), //15-6
                        new LatLng(37.435923399999986, 127.07885570000008),//15-8
                        new LatLng(37.43619319999999, 127.07871640000008),//16고층습지원
                        new LatLng(37.4365068, 127.07823580000002),//16-2
                        new LatLng(37.43671449999999, 127.07783919999997), //16-4
                        new LatLng(37.437062299999994, 127.07769869999993),//18가을단풍길
                        new LatLng(37.4383086, 127.07716189999996),//18-2
                        new LatLng(37.43831869999999, 127.07702510000001)//20라일락원
                ));
                path.setMap(naverMap);
                break;
            case 2:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.433871, 127.080796),
                        new LatLng(37.433815, 127.080666),
                        new LatLng(37.433963, 127.080558),
                        new LatLng(37.43378160000002, 127.08068609999998),
                        new LatLng(37.433847, 127.080684),//하늘정원
                        new LatLng(37.434286, 127.080644),
                        new LatLng(37.43428850000004, 127.08082939999997),
                        new LatLng(37.43428850000004, 127.08082939999997),//4전통정원
                        new LatLng(37.434286, 127.080644),//4-2
                        new LatLng(37.434603651775085, 127.08064936148412),
                        new LatLng(37.434634, 127.080587),//두꺼비분수
                        new LatLng(37.434631, 127.080024),
                        new LatLng(37.434946, 127.080272),
                        new LatLng(37.435213, 127.080114),
                        new LatLng(37.435332, 127.080365),
                        new LatLng(37.43529936421379, 127.07952713349141),
                        new LatLng(37.435426, 127.079775), //습지생태원
                        new LatLng(37.435274, 127.079558),
                        new LatLng(37.435119, 127.079433)//메타세쿼이아길
                ));
                path.setMap(naverMap);
                break;
        }
    }


    /**
     * 부모 뷰 타이틀 및 차일드 뷰 데이터 넣는 곳
     */
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // 그룹 생성
        listDataHeader.add("전체보기");
        listDataHeader.add("계절코스");
        listDataHeader.add("편의시설");

        // 그룹 내 차일드 뷰 생성
        List<String> top250 = new ArrayList<String>();
        top250.add("전체보기");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("봄코스");
        nowShowing.add("여름코스");
        nowShowing.add("가을코스");
        nowShowing.add("겨울코스");

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
