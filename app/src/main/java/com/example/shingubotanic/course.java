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

import com.example.shingubotanic.gardenMarker.central;
import com.example.shingubotanic.gardenMarker.children;
import com.example.shingubotanic.gardenMarker.echo;
import com.example.shingubotanic.gardenMarker.extinction;
import com.example.shingubotanic.gardenMarker.fivesenses;
import com.example.shingubotanic.gardenMarker.gardencafe;
import com.example.shingubotanic.gardenMarker.gardencenter;
import com.example.shingubotanic.gardenMarker.grass;
import com.example.shingubotanic.gardenMarker.herbgarden;
import com.example.shingubotanic.gardenMarker.high;
import com.example.shingubotanic.gardenMarker.lilacgarden;
import com.example.shingubotanic.gardenMarker.lycoris;
import com.example.shingubotanic.gardenMarker.maple;
import com.example.shingubotanic.gardenMarker.metasequoia;
import com.example.shingubotanic.gardenMarker.observatory;
import com.example.shingubotanic.gardenMarker.parking;
import com.example.shingubotanic.gardenMarker.peremptoryagent;
import com.example.shingubotanic.gardenMarker.roofgarden;
import com.example.shingubotanic.gardenMarker.silvergrass;
import com.example.shingubotanic.gardenMarker.toadfountain;
import com.example.shingubotanic.gardenMarker.toilet;
import com.example.shingubotanic.gardenMarker.tradition;
import com.example.shingubotanic.gardenMarker.treeinspector;
import com.example.shingubotanic.gardenMarker.vineyard;
import com.example.shingubotanic.gardenMarker.vista;
import com.example.shingubotanic.gardenMarker.wetlands;
import com.google.android.gms.maps.model.Polyline;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.overlay.PathOverlay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class

course extends AppCompatActivity implements OnMapReadyCallback {

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
    private final int Fragment_5 = 5;
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
        setContentView(R.layout.course);

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

        //마커 클릭이벤트
        marker1.setOnClickListener(new Overlay.OnClickListener() { //중앙광장
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                central cen = central.getInstance();
                cen.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker2.setOnClickListener(new Overlay.OnClickListener() { //하늘정원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                roofgarden roo = roofgarden.getInstance();
                roo.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker3.setOnClickListener(new Overlay.OnClickListener() { //비스타정원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                vista vis = vista.getInstance();
                vis.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker4.setOnClickListener(new Overlay.OnClickListener() { //전통정원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                tradition tra = tradition.getInstance();
                tra.show(getSupportFragmentManager(), tradition.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker5.setOnClickListener(new Overlay.OnClickListener() {//작약원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                peremptoryagent per = peremptoryagent.getInstance();
                per.show(getSupportFragmentManager(), peremptoryagent.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker6.setOnClickListener(new Overlay.OnClickListener() {//두꺼비 분수
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                toadfountain toa = toadfountain.getInstance();
                toa.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker7.setOnClickListener(new Overlay.OnClickListener() { //어린이정원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                children chi = children.getInstance();
                chi.show(getSupportFragmentManager(), children.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker8.setOnClickListener(new Overlay.OnClickListener() { //오감정원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                fivesenses fiv = fivesenses.getInstance();
                fiv.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker9.setOnClickListener(new Overlay.OnClickListener() {//수목관찰원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                treeinspector tre = treeinspector.getInstance();
                tre.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker10.setOnClickListener(new Overlay.OnClickListener() {//약초원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                herbgarden herbg = herbgarden.getInstance();
                herbg.show(getSupportFragmentManager(), herbgarden.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker11.setOnClickListener(new Overlay.OnClickListener() {//메타세쿼이아길
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                metasequoia met = metasequoia.getInstance();
                met.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker12.setOnClickListener(new Overlay.OnClickListener() {//멸종위기 식물원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                extinction ext = extinction.getInstance();
                ext.show(getSupportFragmentManager(), extinction.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker13.setOnClickListener(new Overlay.OnClickListener() {//그라스품종원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                grass gra = grass.getInstance();
                gra.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker14.setOnClickListener(new Overlay.OnClickListener() {//꽃무릇군락지
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                lycoris lyc = lycoris.getInstance();
                lyc.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker15.setOnClickListener(new Overlay.OnClickListener() {//습지생태원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                wetlands wet = wetlands.getInstance();
                wet.show(getSupportFragmentManager(), wetlands.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker16.setOnClickListener(new Overlay.OnClickListener() {//고층습지원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                high hig = high.getInstance();
                hig.show(getSupportFragmentManager(), high.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker17.setOnClickListener(new Overlay.OnClickListener() {//포도원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                vineyard vin = vineyard.getInstance();
                vin.show(getSupportFragmentManager(), vineyard.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker18.setOnClickListener(new Overlay.OnClickListener() {//포도원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                maple map = maple.getInstance();
                map.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker19.setOnClickListener(new Overlay.OnClickListener() {//억새원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                silvergrass sil = silvergrass.getInstance();
                sil.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker20.setOnClickListener(new Overlay.OnClickListener() {//라일락원
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                lilacgarden lil = lilacgarden.getInstance();
                lil.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker21.setOnClickListener(new Overlay.OnClickListener() { //에코센터
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                echo ech = echo.getInstance();
                ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker22.setOnClickListener(new Overlay.OnClickListener() {//전망대
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                observatory obs = observatory.getInstance();
                obs.show(getSupportFragmentManager(), observatory.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker23.setOnClickListener(new Overlay.OnClickListener() {//가든센터
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                gardencenter cen = gardencenter.getInstance();
                cen.show(getSupportFragmentManager(), gardencenter.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker24.setOnClickListener(new Overlay.OnClickListener() {//화장실
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                toilet toi = toilet.getInstance();
                toi.show(getSupportFragmentManager(), toilet.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker25.setOnClickListener(new Overlay.OnClickListener() {//화장실
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                toilet toi = toilet.getInstance();
                toi.show(getSupportFragmentManager(), toilet.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker26.setOnClickListener(new Overlay.OnClickListener() {//주차장
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                parking par = parking.getInstance();
                par.show(getSupportFragmentManager(), parking.TAG_EVENT_DIALOG);
                return false;
            }
        });
        marker27.setOnClickListener(new Overlay.OnClickListener() {//가든카페
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                gardencafe caf = gardencafe.getInstance();
                caf.show(getSupportFragmentManager(), gardencafe.TAG_EVENT_DIALOG);
                return false;
            }
        });

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
                    case "어린이체험코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_1);
                        insert_marker(1);
                        insert_polyline(1);
                        break;
                    case "어르신추천코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_2);
                        insert_marker(2);
                        insert_polyline(2);
                        break;
                    case "단체관람코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_3);
                        insert_marker(3);
                        insert_polyline(3);
                        break;
                    case "커플코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_4);
                        insert_marker(4);
                        insert_polyline(4);
                        break;
                    case "산책로코스":
                        frame.setVisibility(View.VISIBLE);
                        FragmentView(Fragment_5);
                        insert_marker(5);
                        insert_polyline(5);
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
                frag_children fragment1 = new frag_children();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;
            case 2:
                // 두번 째 프래그먼트 호출
                frag_old fragment2 = new frag_old();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
            case 3:
                // 세번 째 프래그먼트 호출
                frag_group fragment3 = new frag_group();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;
            case 4:
                // 네번 째 프래그먼트 호출
                frag_couple fragment4 = new frag_couple();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;
            case 5:
                // 네번 째 프래그먼트 호출
                frag_walk fragment5 = new frag_walk();
                transaction.replace(R.id.fragment_container, fragment5);
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
                setMarker(marker3, 37.43405173, 127.08083314, R.drawable.marker_red, 0, "비스타정원");
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, "전통정원");
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
            case 1: //어린이체험코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker3, 37.43405173, 127.08083314, R.drawable.marker_red, 0, "비스타정원");
                setMarker(marker8, 37.43440920000004, 127.08032980000007, R.drawable.marker_red, 0, "오감정원");
                setMarker(marker7, 37.43453092199691, 127.08023793052985, R.drawable.marker_red, 0, "어린이정원");
                break;
            case 2: //어르신추천코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, "전통정원");
                setMarker(marker5, 37.43441749999999, 127.0810457, R.drawable.marker_red, 0, "작약원");
                setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, "가든카페");
                break;
            case 3: //단체관람코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, "전통정원");
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, "두꺼비분수");
                setMarker(marker21, 37.43484208519403, 127.08035347746568, R.drawable.marker_red, 0, "에코센터");
                setMarker(marker9, 37.43431240322188, 127.08000265298142, R.drawable.marker_red, 0, "수목관찰원");
                break;
            case 4: //커플코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker3, 37.43405173, 127.08083314, R.drawable.marker_red, 0, "비스타정원");
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, "두꺼비분수");
                setMarker(marker21, 37.43484208519403, 127.08035347746568, R.drawable.marker_red, 0, "에코센터");
                setMarker(marker13, 37.43545487038663, 127.079948650858, R.drawable.marker_red, 0, "그라스품종원");
                setMarker(marker14, 37.4353757, 127.07966280000005, R.drawable.marker_red, 0, "꽃무릇군락지");
                break;
            case 5: //산책로코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, "중앙광장");
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, "두꺼비분수");
                setMarker(marker21, 37.43484208519403, 127.08035347746568, R.drawable.marker_red, 0, "에코센터");
                setMarker(marker12, 37.43497920000003, 127.07983260000003, R.drawable.marker_red, 0, "멸종위기식물원");
                setMarker(marker10, 37.43516570835482, 127.07920936229561, R.drawable.marker_red, 0, "약초원");
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
            case 1: //어린이 체험 코스
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43377891, 127.08111052),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43390241, 127.08085059),//11-1
                        new LatLng(37.43405173, 127.08083314), //비스타정원
                        new LatLng(37.43424529, 127.08075702),//3-1
                        new LatLng(37.43422110, 127.0805944),//D곤충생태관
                        new LatLng(37.43442032, 127.08052957), //5-5
                        new LatLng(37.43440920000004, 127.08032980000007), //오감정원
                        new LatLng(37.43441658, 127.08031784), //5-6
                        new LatLng(37.43443637, 127.08030376),//11-3
                        new LatLng(37.43448109, 127.08028809),//11-4
                        new LatLng(37.43453683, 127.08030303),//11-5
//                        new LatLng(37.43453092199691, 127.08023793052985), //어린이정원
                        new LatLng(37.43456191, 127.08024117),//11-6
                        new LatLng(37.43458736, 127.08021037),//11-7
                        new LatLng(37.43459371, 127.08016809),//11-8
                        new LatLng(37.43463169, 127.08011143),//11-9
                        new LatLng(37.43473305, 127.08010515), //5-57
                        new LatLng(37.43477558, 127.08003221), //5-58
                        new LatLng(37.43477767, 127.07995964), //5-59
                        new LatLng(37.43485353, 127.07994009), //5-591
                        new LatLng(37.43484617, 127.07987937), //5-592
                        new LatLng(37.43482409, 127.07981628),//11-10
                        new LatLng(37.43483412, 127.07970377)//나무놀이터
                ));
                path.setMap(naverMap);
                break;
            case 2:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43377891, 127.08111052),//1-1
                        new LatLng(37.43390314, 127.08108805),//21-1
                        new LatLng(37.43394846, 127.08111904),//21-2
                        new LatLng(37.43420119, 127.08104565),//21-3
                        new LatLng(37.43414930, 127.08095571),//21-4
                        new LatLng(37.43415852, 127.08083621),//ㄴ
                        new LatLng(37.43425523, 127.08082445),//3-2
                        new LatLng(37.43428850, 127.08082940),//4전통정원
                        new LatLng(37.43430551, 127.08080676),//3-3
                        new LatLng(37.43434741, 127.08080653),//3-4
                        new LatLng(37.43437718, 127.08086997),//3-5
                        new LatLng(37.43442847, 127.08082982), //5-2
                        new LatLng(37.43444271, 127.08092260),//5-1
                        new LatLng(37.43441952, 127.08102174),//5작약원
                        new LatLng(37.43432686, 127.08113675),//21-5
                        new LatLng(37.43416335, 127.08126818),//21-6
                        new LatLng(37.433831, 127.0814045)//가든카페
                ));
                path.setMap(naverMap);
                break;
            case 3:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43377891, 127.08111052),//1-1
                        new LatLng(37.43390314, 127.08108805),//21-1
                        new LatLng(37.43394846, 127.08111904),//21-2
                        new LatLng(37.43420119, 127.08104565),//21-3
                        new LatLng(37.43414930, 127.08095571),//21-4
                        new LatLng(37.43415852, 127.08083621),//ㄴ
                        new LatLng(37.43425523, 127.08082445),//3-2
                        new LatLng(37.43428850, 127.08082940),//4전통정원
                        new LatLng(37.43430551, 127.08080676),//3-3
                        new LatLng(37.43434741, 127.08080653),//3-4
                        new LatLng(37.43437718, 127.08086997),//3-5
                        new LatLng(37.43442847, 127.08082982), //5-2
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43449218, 127.08069094), //5-31
                        new LatLng(37.434603651775085, 127.08064936148412),//두꺼비분수
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.43484208519403, 127.08035347746568), //에코센터
                        new LatLng(37.43478689, 127.08020002), //5-56
                        new LatLng(37.43473305, 127.08010515), //5-57
                        new LatLng(37.43477558, 127.08003221), //5-58
                        new LatLng(37.43477767, 127.07995964), //5-59
                        new LatLng(37.43471140, 127.07989673), //13-2
                        new LatLng(37.43461875, 127.07991741), //13-3
                        new LatLng(37.43459732, 127.07988033), //13-4
                        new LatLng(37.43456145, 127.07986826), //13-5
                        new LatLng(37.43452013, 127.07989321), //13-6
                        new LatLng(37.43446856, 127.07995762), //13-7
                        new LatLng(37.43440256, 127.07995455), //13-8
                        new LatLng(37.43437587, 127.07995599), //13-9
                        new LatLng(37.43431240322188, 127.08000265298142)//수목관찰원
                ));
                path.setMap(naverMap);
                break;
            case 4:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43377891, 127.08111052),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43390241, 127.08085059),//11-1
                        new LatLng(37.43405173, 127.08083314), //비스타정원
                        new LatLng(37.43415679, 127.08077932),//11-2
                        new LatLng(37.43424529, 127.08075702),//3-1
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43449218, 127.08069094), //5-31
                        new LatLng(37.434603651775085, 127.08064936148412),//두꺼비분수
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.43518371, 127.08014116),//A-1
                        new LatLng(37.43528661, 127.08037174),//31-1
                        new LatLng(37.43545487, 127.07994865),//그라스품종원
                        new LatLng(37.43549305, 127.07982457),//16-2
                        new LatLng(37.43541140, 127.07973898),//16-1
                        new LatLng(37.4353757, 127.07966280)//꽃무릇군락지
                ));
                path.setMap(naverMap);
                break;
            case 5:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990, 127.08111760),//1중앙광장
                        new LatLng(37.43377866, 127.08110970),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43390241, 127.08085059),//11-1
                        new LatLng(37.43415679, 127.08077932),//11-2
                        new LatLng(37.43424529, 127.08075702),//3-1
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43449218, 127.08069094), //5-31
                        new LatLng(37.434603651775085, 127.08064936148412),//두꺼비분수
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.43478689, 127.08020002), //5-56
                        new LatLng(37.43473305, 127.08010515), //5-57
                        new LatLng(37.43477558, 127.08003221), //5-58
                        new LatLng(37.43477767, 127.07995964), //5-59
                        new LatLng(37.43485353, 127.07994009), //5-591
                        new LatLng(37.43484617, 127.07987937), //5-592
                        new LatLng(37.43497920000003, 127.07983260000003), //멸종위기 식물원
                        new LatLng(37.43497053, 127.07982242), //5-593
                        new LatLng(37.43497721, 127.07970704), //5-594
                        new LatLng(37.43504329018735, 127.07952524771031), //5-12
                        new LatLng(37.43516570835482, 127.07920936229561)//약초원

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
