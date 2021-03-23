package com.example.shingubotanic;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;


public class smart extends MainActivity  implements MapView.POIItemEventListener, MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener {
    Toolbar toolbar;
    ImageButton home;
    View.OnClickListener cl;
    Intent i;

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
        mapView.setPOIItemEventListener(this);
        mapView.setCurrentLocationEventListener(this);


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

        MapPoint mapPoint1= MapPoint.mapPointWithGeoCoord(37.43406843548958, 127.08090837897127);//좌표에 마커를 찍는거
        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("비스타정원");//말풍선
        marker1.setTag(1);
        marker1.setMapPoint(mapPoint1);
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint2= MapPoint.mapPointWithGeoCoord(37.434282693201176, 127.0809222257851);
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("전통정원");
        marker2.setTag(2);
        marker2.setMapPoint(mapPoint2);
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint3= MapPoint.mapPointWithGeoCoord(37.434571931125646, 127.08064142102448);
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("계절초화원");
        marker3.setTag(3);
        marker3.setMapPoint(mapPoint3);
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint4= MapPoint.mapPointWithGeoCoord(37.43419135468029, 127.08031776252568);
        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("허브원");
        marker4.setTag(4);
        marker4.setMapPoint(mapPoint4);
        marker4.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker4.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint5= MapPoint.mapPointWithGeoCoord(37.433850428182524, 127.08013819838744);
        MapPOIItem marker5 = new MapPOIItem();
        marker5.setItemName("나무관찰원");
        marker5.setTag(5);
        marker5.setMapPoint(mapPoint5);
        marker5.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker5.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); //

        MapPoint mapPoint6= MapPoint.mapPointWithGeoCoord(37.43435816381426, 127.0796013989216);
        MapPOIItem marker6 = new MapPOIItem();
        marker6.setItemName("과수원");
        marker6.setTag(6);
        marker6.setMapPoint(mapPoint6);
        marker6.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.

        marker6.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint7= MapPoint.mapPointWithGeoCoord(37.434486483563205, 127.080208907736);
        MapPOIItem marker7 = new MapPOIItem();
        marker7.setItemName("어린이정원");
        marker7.setTag(7);
        marker7.setMapPoint(mapPoint7);
        marker7.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker7.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint8= MapPoint.mapPointWithGeoCoord(37.43520530787439, 127.08007102464198);
        MapPOIItem marker8 = new MapPOIItem();
        marker8.setItemName("멸종위기식물원");
        marker8.setTag(8);
        marker8.setMapPoint(mapPoint8);
        marker8.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker8.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint9= MapPoint.mapPointWithGeoCoord(37.43521926809207, 127.07986762448489);
        MapPOIItem marker9 = new MapPOIItem();
        marker9.setItemName("교재식물원");
        marker9.setTag(9);
        marker9.setMapPoint(mapPoint9);
        marker9.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker9.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint10= MapPoint.mapPointWithGeoCoord(37.43511836703489, 127.079205708244);
        MapPOIItem marker10 = new MapPOIItem();
        marker10.setItemName("약초원");
        marker10.setTag(10);
        marker10.setMapPoint(mapPoint10);
        marker10.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker10.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint11= MapPoint.mapPointWithGeoCoord(37.43550389869101, 127.07941623173194);
        MapPOIItem marker11 = new MapPOIItem();
        marker11.setItemName("습지생태원");
        marker11.setTag(11);
        marker11.setMapPoint(mapPoint11);
        marker11.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker11.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint12= MapPoint.mapPointWithGeoCoord(37.43590750001707, 127.07825171431514);
        MapPOIItem marker12 = new MapPOIItem();
        marker12.setItemName("고층습지원");
        marker12.setTag(12);
        marker12.setMapPoint(mapPoint12);
        marker12.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker12.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint13= MapPoint.mapPointWithGeoCoord(37.43606538907537, 127.07916877704947);
        MapPOIItem marker13 = new MapPOIItem();
        marker13.setItemName("돌탑정원");
        marker13.setTag(13);
        marker13.setMapPoint(mapPoint13);
        marker13.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker13.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint14= MapPoint.mapPointWithGeoCoord(37.43610038907537, 127.07956877704947);
        MapPOIItem marker14 = new MapPOIItem();
        marker14.setItemName("포도원");
        marker14.setTag(14);
        marker14.setMapPoint(mapPoint14);
        marker14.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker14.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint15= MapPoint.mapPointWithGeoCoord(37.43542384250206, 127.080090763757377);
        MapPOIItem marker15 = new MapPOIItem();
        marker15.setItemName("수국원");
        marker15.setTag(15);
        marker15.setMapPoint(mapPoint15);
        marker15.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker15.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint16= MapPoint.mapPointWithGeoCoord(37.43543384250206, 127.08050763757377);
        MapPOIItem marker16 = new MapPOIItem();
        marker16.setItemName("둥글래원");
        marker16.setTag(16);
        marker16.setMapPoint(mapPoint16);
        marker16.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker16.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint17= MapPoint.mapPointWithGeoCoord(37.43519818429987, 127.08143146681111);
        MapPOIItem marker17 = new MapPOIItem();
        marker17.setItemName("붓꽃원");
        marker17.setTag(17);
        marker17.setMapPoint(mapPoint17);
        marker17.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker17.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint18= MapPoint.mapPointWithGeoCoord(37.435015959858774, 127.08172630048755);
        MapPOIItem marker18 = new MapPOIItem();
        marker18.setItemName("국화원");
        marker18.setTag(18);
        marker18.setMapPoint(mapPoint18);
        marker18.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker18.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint19= MapPoint.mapPointWithGeoCoord(37.434447479596436, 127.08139853628394);
        MapPOIItem marker19 = new MapPOIItem();
        marker19.setItemName("철쭉원");
        marker19.setTag(19);
        marker19.setMapPoint(mapPoint19);
        marker19.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker19.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint20= MapPoint.mapPointWithGeoCoord(37.434297479596436, 127.08185853628394);
        MapPOIItem marker20 = new MapPOIItem();
        marker20.setItemName("작약원");
        marker20.setTag(20);
        marker20.setMapPoint(mapPoint20);
        marker20.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker20.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint21= MapPoint.mapPointWithGeoCoord(37.433447479596436, 127.08230853628394);
        MapPOIItem marker21 = new MapPOIItem();
        marker21.setItemName("수련원");
        marker21.setTag(21);
        marker21.setMapPoint(mapPoint21);
        marker21.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker21.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint22= MapPoint.mapPointWithGeoCoord(37.433735858281224, 127.08135266869336);
        MapPOIItem marker22 = new MapPOIItem();
        marker22.setItemName("옥상정원");
        marker22.setTag(22);
        marker22.setMapPoint(mapPoint22);
        marker22.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker22.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.


        MapPoint mapPoint30 = MapPoint.mapPointWithGeoCoord(37.43419776612524, 127.08051065343979);
        MapPOIItem marker30 = new MapPOIItem();
        marker30.setItemName("곤충생태관");
        marker30.setTag(23);
        marker30.setMapPoint(mapPoint30);
        marker30.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker30.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        MapPoint mapPoint31= MapPoint.mapPointWithGeoCoord(37.434921215200994, 127.08022310897256);
        MapPOIItem marker31 = new MapPOIItem();
        marker31.setItemName("에코센터");
        marker31.setTag(24);
        marker31.setMapPoint(mapPoint31);
        marker31.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker31.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        //지원 마커 테스트 0312
        MapPoint mapPoint32= MapPoint.mapPointWithGeoCoord(37.43388922486748, 127.08145621370461);
        MapPOIItem marker32 = new MapPOIItem();
        marker32.setItemName("화장실");
        marker32.setTag(25);
        marker32.setMapPoint(mapPoint32);
        marker32.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker32.setCustomImageResourceId(R.drawable.toilet_icon);
        marker32.setCustomImageAutoscale(false);
        //marker32.setCustomImageAnchor(0.5f, 1.0f);

        //BitmapDrawable bitmapDrawable = (BitmapDrawable)getResources().getDrawable(R.drawable.markertest1);
        //marker32.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        //marker32.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        //지원 0321
        MapPoint mapPoint33= MapPoint.mapPointWithGeoCoord(37.43363231505473, 127.0815122406204);
        MapPOIItem marker33 = new MapPOIItem();
        marker33.setItemName("가든센터");
        marker33.setTag(26);
        marker33.setMapPoint(mapPoint33);
        marker33.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker33.setCustomImageResourceId(R.drawable.info_icon);
        marker33.setCustomImageAutoscale(false);

        MapPoint mapPoint34= MapPoint.mapPointWithGeoCoord(37.43346025768689, 127.08067100793033);
        MapPOIItem marker34 = new MapPOIItem();
        marker34.setItemName("관리사무소");
        marker34.setTag(27);
        marker34.setMapPoint(mapPoint34);
        marker34.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker34.setCustomImageResourceId(R.drawable.office_icon);
        marker34.setCustomImageAutoscale(false);

        MapPoint mapPoint35= MapPoint.mapPointWithGeoCoord(37.433832155925806, 127.08157364924348);
        MapPOIItem marker35 = new MapPOIItem();
        marker35.setItemName("가든카페");
        marker35.setTag(28);
        marker35.setMapPoint(mapPoint35);
        marker35.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker35.setCustomImageResourceId(R.drawable.cafe_icon);
        marker35.setCustomImageAutoscale(false);

        MapPoint mapPoint36= MapPoint.mapPointWithGeoCoord(37.4341714160026, 127.08090441048031);
        MapPOIItem marker36 = new MapPOIItem();
        marker36.setItemName("전망대");
        marker36.setTag(29);
        marker36.setMapPoint(mapPoint36);
        marker36.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker36.setCustomImageResourceId(R.drawable.observatory_icon);
        marker36.setCustomImageAutoscale(false);

        MapPoint mapPoint37= MapPoint.mapPointWithGeoCoord(37.43380166655613, 127.08203120670491);
        MapPOIItem marker37 = new MapPOIItem();
        marker37.setItemName("주차장");
        marker37.setTag(30);
        marker37.setMapPoint(mapPoint37);
        marker37.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker37.setCustomImageResourceId(R.drawable.parking_icon);
        marker37.setCustomImageAutoscale(false);






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
        mapView.addPOIItem(marker30);
        mapView.addPOIItem(marker31);
        mapView.addPOIItem(marker32);
        mapView.addPOIItem(marker33);
        mapView.addPOIItem(marker34);
        mapView.addPOIItem(marker35);
        mapView.addPOIItem(marker36);
        mapView.addPOIItem(marker37);





        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.home :
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;

                }
            }
        };
        home.setOnClickListener(cl);

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

        switch (mapPOIItem.getTag()){
            case (1):
                if (mapPOIItem.getTag() ==1){
                    vista vis = vista.getInstance();
                    vis.show(getSupportFragmentManager(), vista.TAG_EVENT_DIALOG);
                }break;
            case (2):
                if (mapPOIItem.getTag() ==2){
                    tradition tra = tradition.getInstance();
                    tra.show(getSupportFragmentManager(), tradition.TAG_EVENT_DIALOG);
                }break;
            case (3):
                if (mapPOIItem.getTag() ==3){
                    seasonalherbgarden sea = seasonalherbgarden.getInstance();
                    sea.show(getSupportFragmentManager(), seasonalherbgarden.TAG_EVENT_DIALOG);
                }break;
            case (4):
                if (mapPOIItem.getTag() ==4){
                    herb her = herb.getInstance();
                    her.show(getSupportFragmentManager(), herb.TAG_EVENT_DIALOG);
                }break;
            case (5):
                if (mapPOIItem.getTag() ==5){
                    treeinspector tre = treeinspector.getInstance();
                    tre.show(getSupportFragmentManager(), treeinspector.TAG_EVENT_DIALOG);
                }break;
            case (6):
                if (mapPOIItem.getTag() ==6){
                    fruitfirm fru = fruitfirm.getInstance();
                    fru.show(getSupportFragmentManager(), fruitfirm.TAG_EVENT_DIALOG);
                }break;
            case (7):
                if (mapPOIItem.getTag() ==7){
                    children chi = children.getInstance();
                    chi.show(getSupportFragmentManager(), children.TAG_EVENT_DIALOG);
                }break;
            case (8):
                if (mapPOIItem.getTag() ==8){
                    extinction ext = extinction.getInstance();
                    ext.show(getSupportFragmentManager(), extinction.TAG_EVENT_DIALOG);
                }break;
            case (9):
                if (mapPOIItem.getTag() ==9){
                    textbook tex = textbook.getInstance();
                    tex.show(getSupportFragmentManager(), textbook.TAG_EVENT_DIALOG);
                }break;
            case (10):
                if (mapPOIItem.getTag() ==10){
                    herbgarden herbg = herbgarden.getInstance();
                    herbg.show(getSupportFragmentManager(), herbgarden.TAG_EVENT_DIALOG);
                }break;
            case (11):
                if (mapPOIItem.getTag() ==11){
                    wetlands wet = wetlands.getInstance();
                    wet.show(getSupportFragmentManager(), wetlands.TAG_EVENT_DIALOG);
                }break;
            case (12):
                if (mapPOIItem.getTag() ==12){
                    high hig = high.getInstance();
                    hig.show(getSupportFragmentManager(), high.TAG_EVENT_DIALOG);
                }break;
            case (13):
                if (mapPOIItem.getTag() ==13){
                    stonegarden sto = stonegarden.getInstance();
                    sto.show(getSupportFragmentManager(), stonegarden.TAG_EVENT_DIALOG);
                }break;
            case (14):
                if (mapPOIItem.getTag() ==14){
                    vineyard vin = vineyard.getInstance();
                    vin.show(getSupportFragmentManager(), vineyard.TAG_EVENT_DIALOG);
                }break;
            case (15):
                if (mapPOIItem.getTag() ==15){
                    hydroponics hyd = hydroponics.getInstance();
                    hyd.show(getSupportFragmentManager(), hydroponics.TAG_EVENT_DIALOG);
                }break;
            case (16):
                if (mapPOIItem.getTag() ==16){
                    donglewon don = donglewon.getInstance();
                    don.show(getSupportFragmentManager(), donglewon.TAG_EVENT_DIALOG);
                }break;
            case (17):
                if (mapPOIItem.getTag() ==17){
                    brushflower brush = brushflower.getInstance();
                    brush.show(getSupportFragmentManager(), brushflower.TAG_EVENT_DIALOG);
                }break;
            case (18):
                if (mapPOIItem.getTag() ==18){
                    chrysanthemum chr = chrysanthemum.getInstance();
                    chr.show(getSupportFragmentManager(), chrysanthemum.TAG_EVENT_DIALOG);
                }break;
            case (19):
                if (mapPOIItem.getTag() ==19){
                    azalea aza = azalea.getInstance();
                    aza.show(getSupportFragmentManager(), azalea.TAG_EVENT_DIALOG);
                }break;
            case (20):
                if (mapPOIItem.getTag() ==20){
                    peremptoryagent per = peremptoryagent.getInstance();
                    per.show(getSupportFragmentManager(), peremptoryagent.TAG_EVENT_DIALOG);
                }break;
            case (21):
                if (mapPOIItem.getTag() ==21){
                    training trai = training.getInstance();
                    trai.show(getSupportFragmentManager(), training.TAG_EVENT_DIALOG);
                }break;
            case (22):
                if (mapPOIItem.getTag() ==22){
                    roofgarden roof = roofgarden.getInstance();
                    roof.show(getSupportFragmentManager(), roofgarden.TAG_EVENT_DIALOG);
                }break;

            case (23):
                if (mapPOIItem.getTag() ==23){
                    insect ins = insect.getInstance();
                    ins.show(getSupportFragmentManager(), insect.TAG_EVENT_DIALOG);
                }break;
            case (24):
                if (mapPOIItem.getTag() ==24){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (25):
                if (mapPOIItem.getTag() ==25){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (26):
                if (mapPOIItem.getTag() ==26){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (27):
                if (mapPOIItem.getTag() ==27){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (28):
                if (mapPOIItem.getTag() ==28){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (29):
                if (mapPOIItem.getTag() ==29){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
                }break;
            case (30):
                if (mapPOIItem.getTag() ==30){
                    echo ech = echo.getInstance();
                    ech.show(getSupportFragmentManager(), echo.TAG_EVENT_DIALOG);
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
            mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);


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
}
