package com.example.shingubotanic;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.shingubotanic.plantFSpring.springLilac;
import com.example.shingubotanic.plantFSpring.springTulip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;


public class smart extends MainActivity  implements MapView.POIItemEventListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener {
    Toolbar toolbar;
    ImageButton home, flower_icon, spring, summer, fall, winter, allmap, plantinfo, back_menu, eventView, gopro, gosea, psilver, left_btn, right_btn;
    View.OnClickListener cl;
    Intent i;
    int a=1;
    private DrawerLayout smartLayout;
    private View springNev, summerNev;
    private ListView list1;
    LinearLayout scon, sc, pcon, pc, webCon1, webCon2;


    private static final String LOG_TAG = "MainActivity";

    private MapView mapView;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 1000;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        home = (ImageButton) findViewById(R.id.home);
        mapView = (MapView) findViewById(R.id.map_view);

        spring = (ImageButton) findViewById(R.id.spring);
        summer = (ImageButton) findViewById(R.id.summer);
        fall = (ImageButton) findViewById(R.id.fall);
        winter = (ImageButton)findViewById(R.id.winter);
        allmap = (ImageButton) findViewById(R.id.allmap);
        plantinfo = (ImageButton) findViewById(R.id.plantinfo);

        flower_icon = (ImageButton) findViewById(R.id.tulip);

        smartLayout = (DrawerLayout) findViewById(R.id.smartLayout);
        springNev = (View) findViewById(R.id.springNev);
        summerNev = (View) findViewById(R.id.summerNev);

        back_menu = (ImageButton) findViewById(R.id.back_menu);
        eventView = (ImageButton) findViewById(R.id.eventView);

        list1 = (ListView) findViewById(R.id.list1);

        scon = (LinearLayout) findViewById(R.id.scontainer);
        gopro = (ImageButton) findViewById(R.id.gopro);
        sc = (LinearLayout) findViewById(R.id.scon);

//        View smartv = View.inflate(this, R.layout.smart, null);
        View prov = View.inflate(this, R.layout.probono, null);  //프로보노 레이아웃을 View 객체로 만들긔
//        scon.addView(prov); //스마트 linear에 View 추가
        pcon = (LinearLayout) prov.findViewById(R.id.pcontainer);
        pc = (LinearLayout) prov.findViewById(R.id.pcon);
        gosea = (ImageButton) prov.findViewById(R.id.gosea);
        psilver = (ImageButton) prov.findViewById(R.id.prosilver);

        left_btn = (ImageButton) findViewById(R.id.left_btn);
        right_btn = (ImageButton) findViewById(R.id.right_btn);

        webCon1 = (LinearLayout) findViewById(R.id.webCon1);
        webCon2 = (LinearLayout) findViewById(R.id.webCon2);


        ArrayList<String> data = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list1.setAdapter(adapter);

//        //데이터추가
//        data.add("식물1");
//        data.add("식물2");
//        data.add("식물3");
//        adapter.notifyDataSetInvalidated(); //저장완료

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");
        DatabaseReference dbRef = database.getReference("plantListSpring");

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String val = snapshot.child("plantname").getValue(String.class);
                    data.add(val);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        mapView.setPOIItemEventListener(this);
        mapView.setCurrentLocationEventListener(this);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {     //listView 클릭 이벤트
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String str = (String) parent.getItemAtPosition(position);
                switch (position){
                    case(0):
                        if (position == 0) {    //튤립
                            springTulip stul = springTulip.getInstance();
                            stul.show(getSupportFragmentManager(), springTulip.TAG_EVENT_DIALOG);
                        } break;
                    case(1):
                        if (position == 1) {    //라일락
                            springLilac slil = springLilac.getInstance();
                            slil.show(getSupportFragmentManager(), springLilac.TAG_EVENT_DIALOG);
                        } break;
                }
            }
        });



//        pcouple.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MapPoint mapPoint1= MapPoint.mapPointWithGeoCoord(37.43374990000003, 127.08111759999997);//좌표에 마커를 찍는거
//                MapPOIItem marker1 = new MapPOIItem();
//                marker1.setItemName("중앙광장");//말풍선
//                marker1.setTag(1);
//                marker1.setMapPoint(mapPoint1);
//                marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
//                marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
//            }
//        });

        flower_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==1) {
                    smartLayout.openDrawer(springNev);
                }
                else if (a==2) {
                    smartLayout.openDrawer(summerNev);
                }
            }
        });

        smartLayout.setDrawerListener(listener);
        springNev.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        summerNev.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });



        if (!checkLocationServicesStatus()) {

            showDialogForLocationServiceSetting();
        }else {

            checkRunTimePermission();
        }

// 밑 구현부는 줌고정값을 신구대 식물원 좌표로 지정하고 확대 축소 비율 고정값을 줌레벨 2로 지정한것이다
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.4340312970034, 127.08084512504904), 2, true);
        // 줌 인
        mapView.zoomIn(true);
        // 줌 아웃
        mapView.zoomOut(true);

/*
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(128, 255, 51, 0)); // Polyline 컬러 지정.

// Polyline 좌표 지정.
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43380210000001, 127.08141320000004));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43374990000003,127.08111759999997));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43378160000002,127.08068609999998));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43422110000004,127.0805944));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43428850000004, 127.08082939999997));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43441749999999,127.0810457));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43529936421379,127.07952713349141)); //15습지생태원
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43619319999999,127.07871640000008)); //16고층습지원
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.437062299999994, 127.07769869999993)); //18가을단풍길
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.43831869999999,127.07702510000001)); //20라일락원

// Polyline 지도에 올리기.
        mapView.addPolyline(polyline);

 */

// 지도뷰의 중심좌표와 줌레벨을 Polyline이 모두 나오도록 조정.
//        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
//        int padding = 100; // px
//        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));


        MapPoint mapPoint1= MapPoint.mapPointWithGeoCoord(37.43374990000003, 127.08111759999997);//좌표에 마커를 찍는거
        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("중앙광장");//말풍선
        marker1.setTag(1);
        marker1.setMapPoint(mapPoint1);
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint2= MapPoint.mapPointWithGeoCoord(37.43378160000002, 127.08068609999998);
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("하늘정원");
        marker2.setTag(2);
        marker2.setMapPoint(mapPoint2);
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint3= MapPoint.mapPointWithGeoCoord(37.43405849102472, 127.08087070726651);
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("비스타정원");
        marker3.setTag(3);
        marker3.setMapPoint(mapPoint3);
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint4= MapPoint.mapPointWithGeoCoord(37.43428850000004, 127.08082939999997);
        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("정통정원");
        marker4.setTag(4);
        marker4.setMapPoint(mapPoint4);
        marker4.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker4.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint5= MapPoint.mapPointWithGeoCoord(37.43441749999999, 127.0810457);
        MapPOIItem marker5 = new MapPOIItem();
        marker5.setItemName("작약원");
        marker5.setTag(5);
        marker5.setMapPoint(mapPoint5);
        marker5.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker5.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); //

        MapPoint mapPoint6= MapPoint.mapPointWithGeoCoord(37.434603651775085, 127.08064936148412);
        MapPOIItem marker6 = new MapPOIItem();
        marker6.setItemName("두꺼비분수");
        marker6.setTag(6);
        marker6.setMapPoint(mapPoint6);
        marker6.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양
        marker6.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint7= MapPoint.mapPointWithGeoCoord(37.43453092199691, 127.08023793052985);
        MapPOIItem marker7 = new MapPOIItem();
        marker7.setItemName("어린이정원");
        marker7.setTag(7);
        marker7.setMapPoint(mapPoint7);
        marker7.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker7.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint8= MapPoint.mapPointWithGeoCoord(37.43440920000004, 127.08032980000007);
        MapPOIItem marker8 = new MapPOIItem();
        marker8.setItemName("오감정원");
        marker8.setTag(8);
        marker8.setMapPoint(mapPoint8);
        marker8.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker8.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint9= MapPoint.mapPointWithGeoCoord(37.43431240322188, 127.08000265298142);
        MapPOIItem marker9 = new MapPOIItem();
        marker9.setItemName("수목관찰원");
        marker9.setTag(9);
        marker9.setMapPoint(mapPoint9);
        marker9.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker9.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint10= MapPoint.mapPointWithGeoCoord(37.43516570835482, 127.07920936229561);
        MapPOIItem marker10 = new MapPOIItem();
        marker10.setItemName("약초원");
        marker10.setTag(10);
        marker10.setMapPoint(mapPoint10);
        marker10.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker10.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint11= MapPoint.mapPointWithGeoCoord(37.43537991201445, 127.0788627385964);
        MapPOIItem marker11 = new MapPOIItem();
        marker11.setItemName("메타세쿼이아길");
        marker11.setTag(11);
        marker11.setMapPoint(mapPoint11);
        marker11.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker11.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint12= MapPoint.mapPointWithGeoCoord(37.43497920000003, 127.07983260000003);
        MapPOIItem marker12 = new MapPOIItem();
        marker12.setItemName("멸종위기 식물원");
        marker12.setTag(12);
        marker12.setMapPoint(mapPoint12);
        marker12.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker12.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint13= MapPoint.mapPointWithGeoCoord(37.43545487038663, 127.079948650858);
        MapPOIItem marker13 = new MapPOIItem();
        marker13.setItemName("그라스품종원");
        marker13.setTag(13);
        marker13.setMapPoint(mapPoint13);
        marker13.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker13.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint14= MapPoint.mapPointWithGeoCoord(37.4353757, 127.07966280000005);
        MapPOIItem marker14 = new MapPOIItem();
        marker14.setItemName("꽃무릇군락지");
        marker14.setTag(14);
        marker14.setMapPoint(mapPoint14);
        marker14.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker14.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint15= MapPoint.mapPointWithGeoCoord(37.43529936421379, 127.07952713349141);
        MapPOIItem marker15 = new MapPOIItem();
        marker15.setItemName("습지생태원");
        marker15.setTag(15);
        marker15.setMapPoint(mapPoint15);
        marker15.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker15.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint16= MapPoint.mapPointWithGeoCoord(37.43619319999999, 127.07871640000008);
        MapPOIItem marker16 = new MapPOIItem();
        marker16.setItemName("고층습지원");
        marker16.setTag(16);
        marker16.setMapPoint(mapPoint16);
        marker16.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker16.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint17= MapPoint.mapPointWithGeoCoord(37.436818099999975, 127.07884680000006);
        MapPOIItem marker17 = new MapPOIItem();
        marker17.setItemName("포도원");
        marker17.setTag(17);
        marker17.setMapPoint(mapPoint17);
        marker17.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker17.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint18= MapPoint.mapPointWithGeoCoord(37.437062299999994, 127.07769869999993);
        MapPOIItem marker18 = new MapPOIItem();
        marker18.setItemName("단풍나무길");
        marker18.setTag(18);
        marker18.setMapPoint(mapPoint18);
        marker18.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker18.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint19= MapPoint.mapPointWithGeoCoord(37.43732969999999 , 127.07770260000007 );
        MapPOIItem marker19 = new MapPOIItem();
        marker19.setItemName("억새원");
        marker19.setTag(19);
        marker19.setMapPoint(mapPoint19);
        marker19.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker19.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint20= MapPoint.mapPointWithGeoCoord(37.43831869999999 , 127.07702510000001 );
        MapPOIItem marker20 = new MapPOIItem();
        marker20.setItemName("라일락원");
        marker20.setTag(20);
        marker20.setMapPoint(mapPoint20);
        marker20.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker20.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint21= MapPoint.mapPointWithGeoCoord(37.43484208519403 , 127.08035347746568 );
        MapPOIItem marker21 = new MapPOIItem();
        marker21.setItemName("에코센터");
        marker21.setTag(21);
        marker21.setMapPoint(mapPoint21);
        marker21.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker21.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint22= MapPoint.mapPointWithGeoCoord(37.4349547471053, 127.080159117062);
        MapPOIItem marker22 = new MapPOIItem();
        marker22.setItemName("전망대");
        marker22.setTag(22);
        marker22.setMapPoint(mapPoint22);
        marker22.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker22.setCustomImageResourceId(R.drawable.observatory_icon);
        marker22.setCustomImageAutoscale(false);

        MapPoint mapPoint23= MapPoint.mapPointWithGeoCoord(37.433800524222114, 127.08150811566452);
        MapPOIItem marker23 = new MapPOIItem();
        marker23.setItemName("가든센터");
        marker23.setTag(23);
        marker23.setMapPoint(mapPoint23);
        marker23.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker23.setCustomImageResourceId(R.drawable.info_icon);
        marker23.setCustomImageAutoscale(false);

        MapPoint mapPoint24= MapPoint.mapPointWithGeoCoord(37.43387937864328, 127.08148560316515);
        MapPOIItem marker24 = new MapPOIItem();
        marker24.setItemName("화장실2");
        marker24.setTag(24);
        marker24.setMapPoint(mapPoint24);
        marker24.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker24.setCustomImageResourceId(R.drawable.toilet_icon);
        marker24.setCustomImageAutoscale(false);

        MapPoint mapPoint25= MapPoint.mapPointWithGeoCoord(37.433996, 127.081272);
        MapPOIItem marker25 = new MapPOIItem();
        marker25.setItemName("화장실");
        marker25.setTag(25);
        marker25.setMapPoint(mapPoint25);
        marker25.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker25.setCustomImageResourceId(R.drawable.toilet_icon);
        marker25.setCustomImageAutoscale(false);
        //marker32.setCustomImageAnchor(0.5f, 1.0f);

        MapPoint mapPoint26= MapPoint.mapPointWithGeoCoord(37.4337449824962, 127.08189373068059);
        MapPOIItem marker26 = new MapPOIItem();
        marker26.setItemName("주차장");
        marker26.setTag(26);
        marker26.setMapPoint(mapPoint26);
        marker26.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker26.setCustomImageResourceId(R.drawable.parking_icon);
        marker26.setCustomImageAutoscale(false);

        MapPoint mapPoint27= MapPoint.mapPointWithGeoCoord(37.433831, 127.081404);
        MapPOIItem marker27 = new MapPOIItem();
        marker27.setItemName("가든카페");
        marker27.setTag(27);
        marker27.setMapPoint(mapPoint27);
        marker27.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker27.setCustomImageResourceId(R.drawable.cafe_icon);
        marker27.setCustomImageAutoscale(false);


        mapView.addPOIItem(marker1);
        mapView.addPOIItem(marker2);
        mapView.addPOIItem(marker3);
        mapView.addPOIItem(marker4);
        mapView.addPOIItem(marker5);
        mapView.addPOIItem(marker6);
        mapView.addPOIItem(marker7);
        mapView.addPOIItem(marker8);
        mapView.addPOIItem(marker9);
        mapView.addPOIItem(marker10);
        mapView.addPOIItem(marker11);
        mapView.addPOIItem(marker12);
        mapView.addPOIItem(marker13);
        mapView.addPOIItem(marker14);
        mapView.addPOIItem(marker15);
        mapView.addPOIItem(marker16);
        mapView.addPOIItem(marker17);
        mapView.addPOIItem(marker18);
        mapView.addPOIItem(marker19);
        mapView.addPOIItem(marker20);
        mapView.addPOIItem(marker21);
        mapView.addPOIItem(marker22);
        mapView.addPOIItem(marker23);
        mapView.addPOIItem(marker24);
        mapView.addPOIItem(marker25);
        mapView.addPOIItem(marker26);
        mapView.addPOIItem(marker27);



        MapPolyline polyline1 = new MapPolyline();
        MapPolyline polyline2 = new MapPolyline();
        MapPolyline polyline3 = new MapPolyline();



        gopro.setOnClickListener(new View.OnClickListener() {   //프로보노 레이아웃으로 교체
            @Override
            public void onClick(View v) {
                //sc.setVisibility(View.GONE); //작은 linearlayout
                scon.addView(prov); //스마트 linear에 View 추가
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.probono, pcon, true);
            }
        });

        gosea.setOnClickListener(new View.OnClickListener() {   //스마트 레이아웃 다시 띄우기
            @Override
            public void onClick(View v) {
//                prov.setVisibility(View.GONE);
                scon.removeView(prov);
                setContentView(R.layout.smart);   //야매 성공

//                pcon.removeView(sc);
//                scon.removeView(sc);
//                scon.addView(sc);
//                pcon.removeView(scon);
            }
        });


        psilver.setOnClickListener(new View.OnClickListener() {   //프로보노 레이아웃에서 노인코스 클릭 시
            @Override
            public void onClick(View v) {
                mapView.removeAllPolylines();
                mapView.removePolyline(polyline1);
                mapView.removePolyline(polyline2);
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.433681, 127.080883)); //2-1
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.433971, 127.080796)); //2-2
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.433915, 127.080666)); //2-3
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.433963, 127.080558)); //2-4
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.433847, 127.080684)); //하늘정원
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434207, 127.080601)); //14-1
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434207, 127.080599)); //14-2
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434634, 127.080656)); //14-3
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434634, 127.080656)); //13두꺼비정원
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434875, 127.080387)); //13-2
                polyline3.addPoint(MapPoint.mapPointWithGeoCoord(37.434996, 127.080298)); //에코

                polyline3.setLineColor(Color.argb(100, 0, 0, 255));
                mapView.addPolyline(polyline3);

                mapView.removeAllPOIItems();
                //겨울코스임~~
                mapView.addPOIItem(marker1); //중앙정원
                mapView.addPOIItem(marker23); //가든센터
                mapView.addPOIItem(marker2); //하늘정원
                mapView.addPOIItem(marker6); //두꺼비분수
                mapView.addPOIItem(marker21); //중앙정원

            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.home :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                    case R.id.spring:
                        mapView.removeAllPolylines();
                        mapView.removePolyline(polyline2);
                        mapView.removePolyline(polyline3);
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43380210000001, 127.08141320000004)); //입구
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43374990000003,127.08111759999997)); //1중앙광장
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.433893499999975, 127.0808012)); //1-3
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43378160000002,127.08068609999998)); //2하늘정원
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43422110000004,127.0805944)); //D곤충생태관
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43428850000004, 127.08082939999997)); //4전통정원
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.4343151,127.08108270000002)); //4-2
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43441749999999,127.0810457)); //5작약원
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.4344465,127.08083999999997)); //5-2
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43439109999999,127.08017229999996)); //5-4
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43466556958514,127.07969404356436)); //5-6
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43504329018735,127.07952524771031)); //5-8
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43529936421379,127.07952713349141)); //15습지생태원
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43546399999999, 127.07959540000002)); //15-2
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.4355383, 127.07924389999994)); //15-4
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43569849999999, 127.07892990000005)); //15-6
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.435923399999986, 127.07885570000008)); //15-8
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43619319999999,127.07871640000008)); //16고층습지원
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.4365068, 127.07823580000002)); //16-2
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43671449999999, 127.07783919999997)); //16-4
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.437062299999994, 127.07769869999993)); //18가을단풍길
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.4383086, 127.07716189999996)); //18-2
                        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.43831869999999,127.07702510000001)); //20라일락원

                        polyline1.setLineColor(Color.argb(100, 0, 0, 255));
                        mapView.addPolyline(polyline1);

                        mapView.removeAllPOIItems();

                        mapView.addPOIItem(marker1); //중앙정원
                        mapView.addPOIItem(marker2); //하늘정원
                        mapView.addPOIItem(marker5); //작약원
                        mapView.addPOIItem(marker21); //에코센터전망대
                        mapView.addPOIItem(marker15); //습지생태원
                        mapView.addPOIItem(marker16); //고층습지원
                        mapView.addPOIItem(marker20); //라일락원
//                        i = new Intent(getApplicationContext(), spring.class);
//                        startActivity(i);
                        break;
                    case R.id.summer:
                        //i = new Intent(getApplicationContext(), summer.class);
                        //startActivity(i);
                        mapView.removeAllPolylines();
                        mapView.removePolyline(polyline1);
                        mapView.removePolyline(polyline3);
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.433681, 127.080833));//중앙광장
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.433871,127.080796));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.433815,127.080666));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.433963,127.080558));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.43378160000002, 127.08068609999998));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.433847,127.080684));//하늘정원
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434286,127.080644));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.43428850000004, 127.08082939999997));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434218,127.08084));//전통정원
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434603651775085, 127.08064936148412));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434634,127.080587));//두꺼비분수
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434631,127.080024));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.434946,127.080272));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.435213,127.080114));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.435332,127.080365));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.43529936421379, 127.07952713349141));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.435426,127.079775));//습지생태원
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.435274,127.079558));
                        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.435119,127.079433));//메타세쿼이아길

                        polyline2.setLineColor(Color.argb(100, 0, 0, 255));
                        mapView.removeAllPOIItems();

                        mapView.addPOIItem(marker1); //중앙광장
                        mapView.addPOIItem(marker2); //하늘정원
                        mapView.addPOIItem(marker4); //전통정원
                        mapView.addPOIItem(marker6); //두꺼비분수
                        mapView.addPOIItem(marker15); //습지생태원
                        mapView.addPOIItem(marker11); //메타세쿼이아길
                        mapView.addPolyline(polyline2);

                        break;
                    case R.id.fall:
                        i = new Intent(getApplicationContext(), fall.class);
                        startActivity(i);
                        break;
                    case R.id.winter:
                        i = new Intent(getApplicationContext(), winter.class);
                        startActivity(i);
                        break;
                    case R.id.allmap:
                        i = new Intent(getApplicationContext(), allmap.class);
                        startActivity(i);
                        break;
                    case R.id.plantinfo:
                        i = new Intent(getApplicationContext(), plantinfo.class);
                        startActivity(i);
                        break;
                    case R.id.back_menu:
                        smartLayout.closeDrawers();
                        break;
                    case R.id.eventView:
                        i = new Intent(getApplicationContext(), webv.class);
                        startActivity(i);
                        break;
                    case R.id.right_btn :
                        LayoutInflater inflater3 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        inflater3.inflate(R.layout.sub_menu, webCon1, true);
                        webCon2.setVisibility(View.GONE);
                        break;

                    case R.id.left_btn :
                        LayoutInflater inflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        inflater2.inflate(R.layout.sub_menu2, webCon1, true);
                        webCon2.setVisibility(View.GONE);
                        break;
                }
            }
        };
        home.setOnClickListener(cl);
        spring.setOnClickListener(cl);
        summer.setOnClickListener(cl);
        fall.setOnClickListener(cl);
        winter.setOnClickListener(cl);
        allmap.setOnClickListener(cl);
        plantinfo.setOnClickListener(cl);
        back_menu.setOnClickListener(cl);
        eventView.setOnClickListener(cl);
        left_btn.setOnClickListener(cl);
        right_btn.setOnClickListener(cl);
    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }


    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

        switch (mapPOIItem.getTag()) {
            case (1):
                if (mapPOIItem.getTag() == 1) { //중앙광장
                    central cen = central.getInstance();
                    cen.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                } break;
            case (2):
                if (mapPOIItem.getTag() == 2) { //하늘정원
                    roofgarden roo = roofgarden.getInstance();
                    roo.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                } break;
            case (3):
                if (mapPOIItem.getTag() == 3) { //비스타정원
                    vista vis = vista.getInstance();
                    vis.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                } break;
            case (4):
                if (mapPOIItem.getTag() == 4){ //전통정원
                    tradition tra = tradition.getInstance();
                    tra.show(getSupportFragmentManager(), tradition.TAG_EVENT_DIALOG);
                }break;
            case (5):
                if (mapPOIItem.getTag() == 5){ //작약원
                    peremptoryagent per = peremptoryagent.getInstance();
                    per.show(getSupportFragmentManager(), peremptoryagent.TAG_EVENT_DIALOG);
                }break;
            case (6):
                if (mapPOIItem.getTag() == 6){  //두꺼비 분수
                    toadfountain toa = toadfountain.getInstance();
                    toa.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                }break;
            case (7):
                if (mapPOIItem.getTag() ==7){ //어린이정원
                    children chi = children.getInstance();
                    chi.show(getSupportFragmentManager(), children.TAG_EVENT_DIALOG);
                }break;
            case (8):
                if (mapPOIItem.getTag() == 8){  //오감정원
                    fivesenses fiv = fivesenses.getInstance();
                    fiv.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                }break;
            case (9):
                if (mapPOIItem.getTag() == 9){ //수목관찰원
                    treeinspector tre = treeinspector.getInstance();
                    tre.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (10):
                if (mapPOIItem.getTag() ==10){ //약초원
                    herbgarden herbg = herbgarden.getInstance();
                    herbg.show(getSupportFragmentManager(), herbgarden.TAG_EVENT_DIALOG);
                }break;
            case (11):
                if (mapPOIItem.getTag() == 11){ //메타세쿼이아길
                    metasequoia met = metasequoia.getInstance();
                    met.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (12):
                if (mapPOIItem.getTag() == 12){ //멸종위기 식물원
                    extinction ext = extinction.getInstance();
                    ext.show(getSupportFragmentManager(), extinction.TAG_EVENT_DIALOG);
                }break;
            case (13):
                if (mapPOIItem.getTag() == 13){  //그라스품종원
                    grass gra = grass.getInstance();
                    gra.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                }break;
            case (14):
                if (mapPOIItem.getTag() == 14){ //꽃무릇군락지
                    lycoris lyc = lycoris.getInstance();
                    lyc.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (15):
                if (mapPOIItem.getTag() == 15){ //습지생태원
                    wetlands wet = wetlands.getInstance();
                    wet.show(getSupportFragmentManager(), wetlands.TAG_EVENT_DIALOG);
                }break;
            case (16):
                if (mapPOIItem.getTag() == 16){ //고층습지원
                    high hig = high.getInstance();
                    hig.show(getSupportFragmentManager(), high.TAG_EVENT_DIALOG);
                }break;
            case (17):
                if (mapPOIItem.getTag() == 17){ //포도원
                    vineyard vin = vineyard.getInstance();
                    vin.show(getSupportFragmentManager(), vineyard.TAG_EVENT_DIALOG);
                }break;
            case (18):
                if (mapPOIItem.getTag() == 18){ //단풍나무길
                    maple map = maple.getInstance();
                    map.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (19):
                if (mapPOIItem.getTag() ==19){  //억새원
                    silvergrass sil = silvergrass.getInstance();
                    sil.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (20):
                if (mapPOIItem.getTag() ==20){  //라일락원
                    lilacgarden lil = lilacgarden.getInstance();
                    lil.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                }break;
            case (21):
                if (mapPOIItem.getTag() ==21){ //A 에코센터
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (22):
                if (mapPOIItem.getTag() ==22){  //전망대, 에코센터 2층
                    observatory obs = observatory.getInstance();
                    obs.show(getSupportFragmentManager(), observatory.TAG_EVENT_DIALOG);
                }break;
            case (23):
                if (mapPOIItem.getTag() ==23){  //가든센터
                    gardencenter cen = gardencenter.getInstance();
                    cen.show(getSupportFragmentManager(), gardencenter.TAG_EVENT_DIALOG);
                }break;
            case (24):
                if (mapPOIItem.getTag() ==24){ //화장실2
                    toilet toi = toilet.getInstance();
                    toi.show(getSupportFragmentManager(), toilet.TAG_EVENT_DIALOG);
                }break;
            case (25):
                if (mapPOIItem.getTag() ==25){ //화장실
                    toilet toi = toilet.getInstance();
                    toi.show(getSupportFragmentManager(), toilet.TAG_EVENT_DIALOG);
                }break;
            case (26):
                if (mapPOIItem.getTag() ==26){ //주차장
                    parking par = parking.getInstance();
                    par.show(getSupportFragmentManager(), parking.TAG_EVENT_DIALOG);
                }break;
            case (27):
                if (mapPOIItem.getTag() ==27){ //가든카페
                    gardencafe caf = gardencafe.getInstance();
                    caf.show(getSupportFragmentManager(), gardencafe.TAG_EVENT_DIALOG);
                }break;
        }

//        Log.d("MainActivity", "click :" + mapPOIItem); 말풍선 클릭이 되는지 확인하는코드
//        다이얼로그 프래그먼트 불러오는 코드
//        fragment f =fragment.getInstance();
//        f.show(getSupportFragmentManager(),fragment.TAG_EVENT_DIALOG);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
        mapView.setShowCurrentLocationMarker(false);
    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {
        mapReverseGeoCoder.toString();
        onFinishReverseGeoCoding(s);
    }

    private void onFinishReverseGeoCoding(String result) {
    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {
        onFinishReverseGeoCoding("Fail");
    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint currentLocation, float accuracyInMeters) {
        MapPoint.GeoCoordinate mapPointGeo = currentLocation.getMapPointGeoCoord();
        Log.i(LOG_TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            boolean check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if ( check_result ) {
                Log.d("@@@", "start");
                //위치 값을 가져올 수 있음
                mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
            }
            else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {

                    Toast.makeText(smart.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    finish();


                }else {

                    Toast.makeText(smart.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    void checkRunTimePermission(){

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(smart.this,
                Manifest.permission.ACCESS_FINE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED ) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음
            mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);


        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(smart.this, REQUIRED_PERMISSIONS[0])) {

                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(smart.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(smart.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);


            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(smart.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(smart.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하실래요?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
                        checkRunTimePermission();
                        return;
                    }
                }

                break;
        }
    }
    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    //드로워레이아웃 했을때 상태값 받아옴
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {

        //슬라이더
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        //오픈
        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        //슬라이더 닫혔을때
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        //상태가 바꼈을때
        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };


}
