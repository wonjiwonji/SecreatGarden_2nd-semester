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
import java.util.Locale;

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
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.Viewall)) {
                    frame.setVisibility(FrameLayout.GONE);
                    insert_marker(0);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.Spring)){
                    frame.setVisibility(View.VISIBLE);
                    FragmentView(Fragment_1);
                    insert_marker(1);
                    insert_polyline(1);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.Summer)){
                    frame.setVisibility(View.VISIBLE);
                    FragmentView(Fragment_2);
                    insert_marker(2);
                    insert_polyline(2);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.Fall)){
                    frame.setVisibility(View.VISIBLE);
                    FragmentView(Fragment_3);
                    insert_marker(3);
                    insert_polyline(3);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.Winter)){
                    frame.setVisibility(View.VISIBLE);
                    FragmentView(Fragment_4);
                    insert_marker(4);
                    insert_polyline(4);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.toilet)){
                    frame.setVisibility(FrameLayout.GONE);
                    insert_marker(11);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.parkinglot)){
                    frame.setVisibility(FrameLayout.GONE);
                    insert_marker(12);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.gardencafe)){
                    frame.setVisibility(FrameLayout.GONE);
                    insert_marker(13);
                } else if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == getString(R.string.gardenshop)){
                    frame.setVisibility(FrameLayout.GONE);
                    insert_marker(14);
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

        //다국어
        Locale sysLocale = getResources().getConfiguration().locale;
        String strLang = sysLocale.getLanguage();


        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment) {
            case 1:
                // 첫번 째 프래그먼트 호출
                if (strLang == "en") {
                    frag_spring_eng fragment1_1 = new frag_spring_eng();
                    transaction.replace(R.id.fragment_container, fragment1_1 );
                } else {
                    frag_spring fragment1 = new frag_spring();
                    transaction.replace(R.id.fragment_container, fragment1);
                }
                transaction.commit();
                break;
            case 2:
                // 두번 째 프래그먼트 호출
                if (strLang == "en") {
                    frag_summer_eng fragment2_1 = new frag_summer_eng();
                    transaction.replace(R.id.fragment_container, fragment2_1 );
                } else {
                    frag_summer fragment2 = new frag_summer();
                    transaction.replace(R.id.fragment_container, fragment2);
                }
                transaction.commit();
                break;
            case 3:
                // 세번 째 프래그먼트 호출
                if (strLang == "en") {
                    frag_fall_eng fragment3_1 = new frag_fall_eng();
                    transaction.replace(R.id.fragment_container, fragment3_1);
                } else {
                    frag_fall fragment3 = new frag_fall();
                    transaction.replace(R.id.fragment_container, fragment3);
                }
                transaction.commit();
                break;
            case 4:
                // 네번 째 프래그먼트 호출
                if (strLang == "en") {
                    frag_winter_eng fragment4_1 = new frag_winter_eng();
                    transaction.replace(R.id.fragment_container, fragment4_1);
                } else {
                    frag_winter fragment4 = new frag_winter();
                    transaction.replace(R.id.fragment_container, fragment4);
                }
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
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, getString(R.string.centralplaza)); //중앙광장
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, getString(R.string.skygarden)); //하늘정원
                setMarker(marker3, 37.43405173, 127.08083314, R.drawable.marker_red, 0, getString(R.string.VistaGarden)); //비스타정원
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, getString(R.string.traditionalgarden)); //전통정원
                setMarker(marker5, 37.43441749999999, 127.0810457, R.drawable.marker_red, 0, getString(R.string.peonygarden)); //작약원
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, getString(R.string.toadfountain)); //두꺼비분수
                setMarker(marker7, 37.43453092199691, 127.08023793052985, R.drawable.marker_red, 0, getString(R.string.childrengarden)); //어린이정원
                setMarker(marker8, 37.43440920000004, 127.08032980000007, R.drawable.marker_red, 0, getString(R.string.FiveSensesGarden)); //오감정원
                setMarker(marker9, 37.43431240322188, 127.08000265298142, R.drawable.marker_red, 0, getString(R.string.arboretum)); //수목관찰원
                setMarker(marker10, 37.43516570835482, 127.07920936229561, R.drawable.marker_red, 0, getString(R.string.herbalgarden)); //약초원
                setMarker(marker11, 37.43537991201445, 127.0788627385964, R.drawable.marker_red, 0, getString(R.string.MetasequoiaRoad)); //메타세쿼이아길
                setMarker(marker12, 37.43497920000003, 127.07983260000003, R.drawable.marker_red, 0, getString(R.string.EndangeredBotanicalGarden)); //멸종위기 식물원
                setMarker(marker13, 37.43545487038663, 127.079948650858, R.drawable.marker_red, 0, getString(R.string.Grass)); //그라스품종원
                setMarker(marker14, 37.4353757, 127.07966280000005, R.drawable.marker_red, 0, getString(R.string.clusterofflowers)); //꽃무릇군락지
                setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, getString(R.string.wetlandecologygarden)); //습지생태원
                setMarker(marker16, 37.43619319999999, 127.07871640000008, R.drawable.marker_red, 0, getString(R.string.highrise)); //고층습지원
                setMarker(marker17, 37.436818099999975, 127.07884680000006, R.drawable.marker_red, 0, getString(R.string.vineyard)); //포도원
                setMarker(marker18, 37.437062299999994, 127.07769869999993, R.drawable.marker_red, 0, getString(R.string.mapletreeroad)); //단풍나무길
                setMarker(marker19, 37.43732969999999, 127.07770260000007, R.drawable.marker_red, 0, getString(R.string.SilverSaewon)); //억새원
                setMarker(marker20, 37.43831869999999, 127.07702510000001, R.drawable.marker_red, 0, getString(R.string.lilacgarden)); //라일락원
                setMarker(marker21, 37.43484208519403, 127.08035347746568, R.drawable.marker_red, 0, getString(R.string.EcoCenter)); //에코센터
                setMarker(marker22, 37.4349547471053, 127.080159117062, R.drawable.observatory_icon, 0, getString(R.string.Observatory)); //전망대
                setMarker(marker23, 37.433800524222114, 127.08150811566452, R.drawable.info_icon, 0, getString(R.string.gardencenter)); //가든센터
                setMarker(marker24, 37.43387937864328, 127.08148560316515, R.drawable.toilet_icon, 0, getString(R.string.toilet)); //화장실
                setMarker(marker25, 37.433996, 127.081272, R.drawable.toilet_icon, 0, getString(R.string.toilet)); //화장실
                setMarker(marker26, 37.4337449824962, 127.08189373068059, R.drawable.parking_icon, 0, getString(R.string.parkinglot)); //주차장
                setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, getString(R.string.gardencafe)); //가든카페
                break;
            case 1: //봄코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, getString(R.string.centralplaza)); //중앙광장
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, getString(R.string.skygarden)); //하늘정원
                setMarker(marker5, 37.43441749999999, 127.0810457, R.drawable.marker_red, 0, getString(R.string.peonygarden)); //작약원
                setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, getString(R.string.wetlandecologygarden)); //습지생태원
                setMarker(marker16, 37.43619319999999, 127.07871640000008, R.drawable.marker_red, 0, getString(R.string.highrise)); //고층습지원
                setMarker(marker20, 37.43831869999999, 127.07702510000001, R.drawable.marker_red, 0, getString(R.string.lilacgarden)); //라일락원

                break;
            case 2: //여름코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, getString(R.string.centralplaza)); //중앙광장
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, getString(R.string.skygarden)); //하늘정원
                setMarker(marker4, 37.43428850000004, 127.08082939999997, R.drawable.marker_red, 0, getString(R.string.traditionalgarden)); //전통정원
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, getString(R.string.toadfountain)); //두꺼비분수
                setMarker(marker15, 37.43529936421379, 127.07952713349141, R.drawable.marker_red, 0, getString(R.string.wetlandecologygarden)); //습지생태원
                setMarker(marker11, 37.43537991201445, 127.0788627385964, R.drawable.marker_red, 0, getString(R.string.MetasequoiaRoad)); //메타세쿼이아길
                break;
            case 3: //가을코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, getString(R.string.centralplaza)); //중앙광장
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, getString(R.string.skygarden)); //하늘정원
                setMarker(marker22, 37.4349547471053, 127.080159117062, R.drawable.observatory_icon, 0, getString(R.string.Observatory)); //전망대
                setMarker(marker14, 37.4353757, 127.07966280000005, R.drawable.marker_red, 0, getString(R.string.clusterofflowers)); //꽃무릇군락지
                setMarker(marker13, 37.43545487038663, 127.079948650858, R.drawable.marker_red, 0, getString(R.string.Grass)); //그라스품종원
                setMarker(marker18, 37.437062299999994, 127.07769869999993, R.drawable.marker_red, 0, getString(R.string.mapletreeroad)); //단풍나무길
                setMarker(marker19, 37.43732969999999, 127.07770260000007, R.drawable.marker_red, 0, getString(R.string.SilverSaewon)); //억새원
                break;
            case 4: //겨울코스
                setMarker(marker1, 37.43374990000003, 127.08111759999997, R.drawable.marker_red, 0, getString(R.string.centralplaza)); //중앙광장
                setMarker(marker2, 37.43378160000002, 127.08068609999998, R.drawable.marker_red, 0, getString(R.string.skygarden)); //하늘정원
                setMarker(marker6, 37.434603651775085, 127.08064936148412, R.drawable.marker_red, 0, getString(R.string.toadfountain)); //두꺼비분수
                setMarker(marker22, 37.4349547471053, 127.080159117062, R.drawable.observatory_icon, 0, getString(R.string.Observatory)); //전망대
                break;
            case 11: //화장실
                setMarker(marker24, 37.43387937864328, 127.08148560316515, R.drawable.toilet_icon, 0, getString(R.string.toilet));//화장실
                setMarker(marker25, 37.433996, 127.081272, R.drawable.toilet_icon, 0, getString(R.string.toilet)); //화장실
                break;
            case 12: //주차장
                setMarker(marker26, 37.4337449824962, 127.08189373068059, R.drawable.parking_icon, 0, getString(R.string.parkinglot)); //주차장
                break;
            case 13: //가든카페
                setMarker(marker27, 37.433831, 127.081404, R.drawable.cafe_icon, 0, getString(R.string.gardencafe)); //가든카페
                break;
            case 14: //가든샵(가든센터)
                setMarker(marker23, 37.433800524222114, 127.08150811566452, R.drawable.info_icon, 0, getString(R.string.gardencenter)); //가든센터
                break;
        }

    }

    //폴리라인 띄우기
    private void insert_polyline(int b) {
        switch (b) {
            case 1:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43376900417801, 127.08111209265323),
                        new LatLng(37.43371672781531, 127.08072380739107),
//                        new LatLng(37.433893499999975, 127.0808012),//1-3
                        new LatLng(37.43371673, 127.08068601), //2하늘정원
                        new LatLng(37.43380219, 127.08071571), //2-1
                        new LatLng(37.43400906, 127.08067153), //2-2
                        new LatLng(37.43406423, 127.08061632), //2-3
                        new LatLng(37.43422110, 127.0805944),//D곤충생태관
                        new LatLng(37.43424529, 127.08075702),//3-1
                        new LatLng(37.43425523, 127.08082445),//3-2
                        new LatLng(37.43430551, 127.08080676),//3-3
                        new LatLng(37.43434741, 127.08080653),//3-4
                        new LatLng(37.43437718, 127.08086997),//3-5
                        new LatLng(37.43438805, 127.08095970),//3-6
//                        new LatLng(37.43428850, 127.08082940),//4전통정원
//                        new LatLng(37.4343151, 127.08108270000002),//4-2
                        new LatLng(37.43441952, 127.08102174), //5작약원
                        new LatLng(37.43444271, 127.08092260),//5-1
                        new LatLng(37.43442847, 127.08082982), //5-2
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43441726, 127.08056086), //5-4
                        new LatLng(37.43442032, 127.08052957), //5-5
                        new LatLng(37.43441658, 127.08031784), //5-6
                        new LatLng(37.43439734, 127.08012412), //5-7
                        new LatLng(37.43443510, 127.07992853), //5-8
                        new LatLng(37.43466557, 127.079694047),//5-9
                        new LatLng(37.43482965, 127.07954985),//5-10
                        new LatLng(37.43491473, 127.07951069), //5-11
                        new LatLng(37.43504329018735, 127.07952524771031), //5-12
                        new LatLng(37.43508543, 127.07954709), //5-595
                        new LatLng(37.43511404, 127.07960736), //5-596
                        new LatLng(37.43516035, 127.07962291), //5-597
                        new LatLng(37.43529936, 127.07952713),//15습지생태원
                        new LatLng(37.43533229, 127.07957275),//15-1
                        new LatLng(37.43539597, 127.07953293),//15-2
                        new LatLng(37.43544959, 127.07942724),//15-3
                        new LatLng(37.43549540, 127.07922926),//15-4
                        new LatLng(37.43572506, 127.07907172),//15-5
                        new LatLng(37.43567050, 127.07895984),//15-6
                        new LatLng(37.43581449, 127.07882641),//15-7
                        new LatLng(37.43585927, 127.07883189),//15-8
                        new LatLng(37.43591922, 127.07876466),//15-9
                        new LatLng(37.43601036, 127.07874191),//15-10
                        new LatLng(37.43610095, 127.07880886),//15-11
                        new LatLng(37.43619320, 127.07871640),//16고층습지원
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
                        new LatLng(37.43374990, 127.08111760),//1중앙광장
                        new LatLng(37.43377866, 127.08110970),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43385845, 127.08074636),//1-4
                        new LatLng(37.43380219, 127.08071571),//2-1(하늘정원쪽)
                        new LatLng(37.43400906, 127.08067153), //2-2
                        new LatLng(37.43406423, 127.08061632), //2-3
                        new LatLng(37.43422110, 127.0805944),//D곤충생태관
                        new LatLng(37.43424529, 127.08075702),//3-1
                        new LatLng(37.43425523, 127.08082445),//3-2
                        new LatLng(37.43429279, 127.08082940),//4전통정원
                        new LatLng(37.43430551, 127.08080676),//3-3
                        new LatLng(37.43434741, 127.08080653),//3-4
                        new LatLng(37.43437718, 127.08086997),//3-5
                        new LatLng(37.43442847, 127.08082982), //5-2
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43449218, 127.08069094), //5-31
                        new LatLng(37.434603651775085, 127.08064936148412),//두꺼비분수
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.43478689, 127.08020002), //5-56
                        new LatLng(37.43473305, 127.08010515), //5-57
                        new LatLng(37.43477558, 127.08003221), //5-58
                        new LatLng(37.43477767, 127.07995964), //5-59
                        new LatLng(37.43485353, 127.07994009), //5-591
                        new LatLng(37.43484617, 127.07987937), //5-592
                        new LatLng(37.43497053, 127.07982242), //5-593
                        new LatLng(37.43497721, 127.07970704), //5-594
                        new LatLng(37.43504329018735, 127.07952524771031), //5-12
                        new LatLng(37.43508543, 127.07954709), //5-595
                        new LatLng(37.43511404, 127.07960736), //5-596
                        new LatLng(37.43516035, 127.07962291), //5-597
                        new LatLng(37.43529936, 127.07952713),//15습지생태원
                        new LatLng(37.43531501, 127.07944880),//14-1
                        new LatLng(37.43536149, 127.07932773),//14-2
                        new LatLng(37.43541999, 127.07919529),//14-3
                        new LatLng(37.43537541, 127.07907416),//14-4
                        new LatLng(37.43540554, 127.07894746),//14-5
                        new LatLng(37.43541097, 127.07885573),//14-6
                        new LatLng(37.43537991, 127.07886273)//메타세쿼이아길
                ));
                path.setMap(naverMap);
                break;
            case 3:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990000003, 127.08111759999997),//1중앙광장
                        new LatLng(37.43377866, 127.08110970),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43385845, 127.08074636),//1-4
                        new LatLng(37.43380219, 127.08071571),//2-1(하늘정원쪽)
                        new LatLng(37.43400906, 127.08067153), //2-2
                        new LatLng(37.43406423, 127.08061632), //2-3
                        new LatLng(37.43422110, 127.0805944),//D곤충생태관
                        new LatLng(37.43442032, 127.08052957), //5-5
                        new LatLng(37.43444968, 127.08055723), //5-51
                        new LatLng(37.43455535, 127.08064222), //5-52
                        new LatLng(37.43458321, 127.08061402), //5-53
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.4349547471053, 127.080159117062),//A전망대
                        new LatLng(37.43518371, 127.08014116),//A-1
                        new LatLng(37.43506001, 127.07998110),//A-2
                        new LatLng(37.43497053, 127.07982242), //5-593
                        new LatLng(37.43497721, 127.07970704), //5-594
                        new LatLng(37.43504329018735, 127.07952524771031), //5-12
                        new LatLng(37.43508543, 127.07954709), //5-595
                        new LatLng(37.43511404, 127.07960736), //5-596
                        new LatLng(37.43516035, 127.07962291), //5-597
                        new LatLng(37.43529936, 127.07952713),//15습지생태원
                        new LatLng(37.43533229, 127.07957275),//15-1
                        new LatLng(37.4353757, 127.07966280),//꽃무릇군락지
                        new LatLng(37.43541140, 127.07973898),//16-1
                        new LatLng(37.43549305, 127.07982457),//16-2
                        new LatLng(37.43545487, 127.07994865),//그라스품종원
                        new LatLng(37.43557191, 127.07965760),//16-3
                        new LatLng(37.43571953, 127.07941762),//16-4
                        new LatLng(37.43583393, 127.07926217),//16-5
                        new LatLng(37.43597610, 127.07914476),//16-6
                        new LatLng(37.43608814, 127.07902348),//16-7
                        new LatLng(37.43628898, 127.07854094),//16-8
                        new LatLng(37.43642192, 127.07831543),//16-9
                        new LatLng(37.43653596, 127.07814390),//16-10
                        new LatLng(37.43662326, 127.07788743),//16-11
                        new LatLng(37.43706230, 127.07769870),//단풍나무길
                new LatLng(37.43732969999999, 127.07770260000007)//억새원
                ));
                path.setMap(naverMap);
                break;
            case 4:
                path.setCoords(Arrays.asList(
                        new LatLng(37.43374990, 127.08111760),//1중앙광장
                        new LatLng(37.43377866, 127.08110970),//1-1
                        new LatLng(37.43373030, 127.08083201),//1-2
                        new LatLng(37.43386580, 127.08079853),//1-3
                        new LatLng(37.43385845, 127.08074636),//1-4
                        new LatLng(37.43380219, 127.08071571),//2-1(하늘정원쪽)
                        new LatLng(37.43400906, 127.08067153), //2-2
                        new LatLng(37.43406423, 127.08061632), //2-3
                        new LatLng(37.43422110, 127.0805944),//D곤충생태관
                        new LatLng(37.43425523, 127.08082445),//3-2
                        new LatLng(37.43429279, 127.08082940),//4전통정원
                        new LatLng(37.43430551, 127.08080676),//3-3
                        new LatLng(37.43434741, 127.08080653),//3-4
                        new LatLng(37.43437718, 127.08086997),//3-5
                        new LatLng(37.43442847, 127.08082982), //5-2
                        new LatLng(37.43439938, 127.08071887), //5-3
                        new LatLng(37.43449218, 127.08069094), //5-31
                        new LatLng(37.434603651775085, 127.08064936148412),//두꺼비분수
                        new LatLng(37.43462685, 127.08062777), //5-54
                        new LatLng(37.43486577, 127.08038166), //5-55
                        new LatLng(37.4349547471053, 127.080159117062)//에코센터 전망대

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

        listDataHeader.add(getString(R.string.Viewall));
        listDataHeader.add(getString(R.string.WeatherC));
        listDataHeader.add(getString(R.string.Facilities));

        // 그룹 내 차일드 뷰 생성
        List<String> top250 = new ArrayList<String>();
        top250.add(getString(R.string.Viewall));

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add(getString(R.string.Spring));
        nowShowing.add(getString(R.string.Summer));
        nowShowing.add(getString(R.string.Fall));
        nowShowing.add(getString(R.string.Winter));

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add(getString(R.string.toilet));
        comingSoon.add(getString(R.string.parkinglot));
        comingSoon.add(getString(R.string.gardencafe));
        comingSoon.add(getString(R.string.gardenshop));

        //데이터 적용.
        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

}
