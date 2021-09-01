package com.example.shingubotanic.info;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.shingubotanic.R;
import com.example.shingubotanic.home;
import com.example.shingubotanic.info.fall.info_fall_plant10_go;
import com.example.shingubotanic.info.fall.info_fall_plant11_yong;
import com.example.shingubotanic.info.fall.info_fall_plant12_bae;
import com.example.shingubotanic.info.fall.info_fall_plant1_ga;
import com.example.shingubotanic.info.fall.info_fall_plant2_gae;
import com.example.shingubotanic.info.fall.info_fall_plant3_dan;
import com.example.shingubotanic.info.fall.info_fall_plant4_go;
import com.example.shingubotanic.info.fall.info_fall_plant5_goo;
import com.example.shingubotanic.info.fall.info_fall_plant6_dong;
import com.example.shingubotanic.info.fall.info_fall_plant7_black;
import com.example.shingubotanic.info.fall.info_fall_plant8_hae;
import com.example.shingubotanic.info.fall.info_fall_plant9_ga;
import com.example.shingubotanic.info.spring.info_spring_plant10_jin;
import com.example.shingubotanic.info.spring.info_spring_plant11_kkang;
import com.example.shingubotanic.info.spring.info_spring_plant12_no;
import com.example.shingubotanic.info.spring.info_spring_plant1_dol;
import com.example.shingubotanic.info.spring.info_spring_plant2_soo;
import com.example.shingubotanic.info.spring.info_spring_plant3_man;
import com.example.shingubotanic.info.spring.info_spring_plant4_white;
import com.example.shingubotanic.info.spring.info_spring_plant5_je;
import com.example.shingubotanic.info.spring.info_spring_plant6_jang;
import com.example.shingubotanic.info.spring.info_spring_plant7_soo;
import com.example.shingubotanic.info.spring.info_spring_plant8_he;
import com.example.shingubotanic.info.spring.info_spring_plant9_mok;
import com.example.shingubotanic.info.summer.info_summer_plant10_bak;
import com.example.shingubotanic.info.summer.info_summer_plant11_tae;
import com.example.shingubotanic.info.summer.info_summer_plant12_ddae;
import com.example.shingubotanic.info.summer.info_summer_plant1_dol;
import com.example.shingubotanic.info.summer.info_summer_plant2_jung;
import com.example.shingubotanic.info.summer.info_summer_plant3_byeong;
import com.example.shingubotanic.info.summer.info_summer_plant4_sum;
import com.example.shingubotanic.info.summer.info_summer_plant5_ki;
import com.example.shingubotanic.info.summer.info_summer_plant6_sum;
import com.example.shingubotanic.info.summer.info_summer_plant7_mool;
import com.example.shingubotanic.info.summer.info_summer_plant8_mae;
import com.example.shingubotanic.info.summer.info_summer_plant9_hae;
import com.example.shingubotanic.info.winter.info_winter_plant1_ae;
import com.example.shingubotanic.info.winter.info_winter_plant2_bok;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.content.ContentValues.TAG;

public class info extends AppCompatActivity {

    ImageButton back;
    View.OnClickListener cl;
    Intent i;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12,
                img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24,
                img25, img26, img27, img28, img29, img30, img31, img32, img33, img34, img35, img36,
                img37, img38;
    TextView x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12,
            x13, x14, x15, x16, x17, x18, x19, x20, x21, x22, x23, x24,
            x25, x26, x27, x28, x29, x30, x31, x32, x33, x34, x35, x36,
            x37, x38;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        back = (ImageButton) findViewById(R.id.info_back);
        img1 = (ImageView) findViewById(R.id.info_img1);
        img2 = (ImageView) findViewById(R.id.info_img2);
        img3 = (ImageView) findViewById(R.id.info_img3);
        img4 = (ImageView) findViewById(R.id.info_img4);
        img5 = (ImageView) findViewById(R.id.info_img5);
        img6 = (ImageView) findViewById(R.id.info_img6);
        img7 = (ImageView) findViewById(R.id.info_img7);
        img8 = (ImageView) findViewById(R.id.info_img8);
        img9 = (ImageView) findViewById(R.id.info_img9);
        img10 = (ImageView) findViewById(R.id.info_img10);
        img11 = (ImageView) findViewById(R.id.info_img11);
        img12 = (ImageView) findViewById(R.id.info_img12);

        img13 = (ImageView) findViewById(R.id.info_img13);
        img14 = (ImageView) findViewById(R.id.info_img14);
        img15 = (ImageView) findViewById(R.id.info_img15);
        img16 = (ImageView) findViewById(R.id.info_img16);
        img17 = (ImageView) findViewById(R.id.info_img17);
        img18 = (ImageView) findViewById(R.id.info_img18);
        img19 = (ImageView) findViewById(R.id.info_img19);
        img20 = (ImageView) findViewById(R.id.info_img20);
        img21 = (ImageView) findViewById(R.id.info_img21);
        img22 = (ImageView) findViewById(R.id.info_img22);
        img23 = (ImageView) findViewById(R.id.info_img23);
        img24 = (ImageView) findViewById(R.id.info_img24);

        img25 = (ImageView) findViewById(R.id.info_img25);
        img26 = (ImageView) findViewById(R.id.info_img26);
        img27 = (ImageView) findViewById(R.id.info_img27);
        img28 = (ImageView) findViewById(R.id.info_img28);
        img29 = (ImageView) findViewById(R.id.info_img29);
        img30 = (ImageView) findViewById(R.id.info_img30);
        img31 = (ImageView) findViewById(R.id.info_img31);
        img32 = (ImageView) findViewById(R.id.info_img32);
        img33 = (ImageView) findViewById(R.id.info_img33);
        img34 = (ImageView) findViewById(R.id.info_img34);
        img35 = (ImageView) findViewById(R.id.info_img35);
        img36 = (ImageView) findViewById(R.id.info_img36);

        img37 = (ImageView) findViewById(R.id.info_img37);
        img38 = (ImageView) findViewById(R.id.info_img38);

        x1 = (TextView) findViewById(R.id.img1_txt);
        x2 = (TextView) findViewById(R.id.img2_txt);
        x3 = (TextView) findViewById(R.id.img3_txt);
        x4 = (TextView) findViewById(R.id.img4_txt);
        x5 = (TextView) findViewById(R.id.img5_txt);
        x6 = (TextView) findViewById(R.id.img6_txt);
        x7 = (TextView) findViewById(R.id.img7_txt);
        x8 = (TextView) findViewById(R.id.img8_txt);
        x9 = (TextView) findViewById(R.id.img9_txt);
        x10 = (TextView) findViewById(R.id.img10_txt);
        x11 = (TextView) findViewById(R.id.img11_txt);
        x12 = (TextView) findViewById(R.id.img12_txt);

        x13 = (TextView) findViewById(R.id.img13_txt);
        x14 = (TextView) findViewById(R.id.img14_txt);
        x15 = (TextView) findViewById(R.id.img15_txt);
        x16 = (TextView) findViewById(R.id.img16_txt);
        x17 = (TextView) findViewById(R.id.img17_txt);
        x18 = (TextView) findViewById(R.id.img18_txt);
        x19 = (TextView) findViewById(R.id.img19_txt);
        x20 = (TextView) findViewById(R.id.img20_txt);
        x21 = (TextView) findViewById(R.id.img21_txt);
        x22 = (TextView) findViewById(R.id.img22_txt);
        x23 = (TextView) findViewById(R.id.img23_txt);
        x24 = (TextView) findViewById(R.id.img24_txt);

        x25 = (TextView) findViewById(R.id.img25_txt);
        x26 = (TextView) findViewById(R.id.img26_txt);
        x27 = (TextView) findViewById(R.id.img27_txt);
        x28 = (TextView) findViewById(R.id.img28_txt);
        x29 = (TextView) findViewById(R.id.img29_txt);
        x30 = (TextView) findViewById(R.id.img30_txt);
        x31 = (TextView) findViewById(R.id.img31_txt);
        x32 = (TextView) findViewById(R.id.img32_txt);
        x33 = (TextView) findViewById(R.id.img33_txt);
        x34 = (TextView) findViewById(R.id.img34_txt);
        x35 = (TextView) findViewById(R.id.img35_txt);
        x36 = (TextView) findViewById(R.id.img36_txt);

        x37 = (TextView) findViewById(R.id.img37_txt);
        x38 = (TextView) findViewById(R.id.img38_txt);


        //TabHost 초기화.setup();
        TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();

        //첫 번째 Tab (탭 표시 텍스트: "봄"), (뷰: "tab1"), (탭 버튼 식별태그: "Tab Spec 1")
        TabHost.TabSpec tab1 = tabhost.newTabSpec("Tab Spec 1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("봄");
        tabhost.addTab(tab1);

        //두 번째 Tab (탭 표시 텍스트: "여름"), (뷰: "tab2"), (탭 버튼 식별태그: "Tab Spec 2")
        TabHost.TabSpec tab2 = tabhost.newTabSpec("Tab Spec 2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("여름");
        tabhost.addTab(tab2);

        //세 번째 Tab (탭 표시 텍스트: "가을"), (뷰: "tab3"), (탭 버튼 식별태그: "Tab Spec 3")
        TabHost.TabSpec tab3 = tabhost.newTabSpec("Tab Spec 3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("가을");
        tabhost.addTab(tab3);

        //네 번째 Tab (챕 표시 텍스트: "겨울"), (뷰: "tab4"), (탭 버튼 식별태그: "Tab Spec 4")
        TabHost.TabSpec tab4 = tabhost.newTabSpec("Tab Spec 4");
        tab4.setContent(R.id.tab4);
        tab4.setIndicator("겨울");
        tabhost.addTab(tab4);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://shingubotanic-d2239.appspot.com/");
        StorageReference storageRef = storage.getReference().child("plantInfo").child("spring");

        //봄 3~5월
        //Storage
        storageRef.child("spring_plant1_dol.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage2
        storageRef.child("spring_plant2_soo.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img2);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage3
        storageRef.child("spring_plant3_man.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img3);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage4
        storageRef.child("spring_plant4_white.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img4);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage5
        storageRef.child("spring_plant5_je.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img5);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage6
        storageRef.child("spring_plant6_jang.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img6);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage7
        storageRef.child("spring_plant7_soo.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img7);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage8
        storageRef.child("spring_plant8_he.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img8);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage9
        storageRef.child("spring_plant9_mok.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img9);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage10
        storageRef.child("spring_plant10_jin.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img10);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage11
        storageRef.child("spring_plant11_kkang.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img11);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage12
        storageRef.child("spring_plant12_no.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img12);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        //여름 6~8월
        StorageReference storageRef2 = storage.getReference().child("plantInfo").child("summer");

        //Storage13
        storageRef2.child("summer_plant1_dol.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img13);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage14
        storageRef2.child("summer_plant2_jung.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img14);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage15
        storageRef2.child("summer_plant3_byeong.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img15);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage16
        storageRef2.child("summer_plant4_sum.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img16);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage17
        storageRef2.child("summer_plant5_ki.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img17);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage18
        storageRef2.child("summer_plant6_sum.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img18);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage19
        storageRef2.child("summer_plant7_mool.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img19);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage20
        storageRef2.child("summer_plant8_mae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img20);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage21
        storageRef2.child("summer_plant9_hae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img21);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage22
        storageRef2.child("summer_plant10_bak.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img22);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage23
        storageRef2.child("summer_plant11_tae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img23);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage24
        storageRef2.child("summer_plant12_ddae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img24);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        //가을 9~11월
        StorageReference storageRef3 = storage.getReference().child("plantInfo").child("fall");

        //Storage25
        storageRef3.child("fall_plant1_ga.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img25);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage26
        storageRef3.child("fall_plant2_gae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img26);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage27
        storageRef3.child("fall_plant3_dan.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img27);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage28
        storageRef3.child("fall_plant4_go.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img28);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage29
        storageRef3.child("fall_plant5_goo.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img29);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage30
        storageRef3.child("fall_plant6_dong.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img30);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage31
        storageRef3.child("fall_plant7_black.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img31);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage32
        storageRef3.child("fall_plant8_hae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img32);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage33
        storageRef3.child("fall_plant9_ga.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img33);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage34
        storageRef3.child("fall_plant10_go.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img34);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage35
        storageRef3.child("fall_plant11_yong.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img35);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //Storage36
        storageRef3.child("fall_plant12_bae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img36);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        //겨울 12~2월
        StorageReference storageRef4 = storage.getReference().child("plantInfo").child("winter");

        //storage37
        storageRef4.child("winter_plant1_ae.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img37);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });

        //storage38
        storageRef4.child("winter_plant2_bok.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onSuccess(Uri uri) {
                //이미지 로드 성공
                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img38);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Log.d("TEST", "error" + exception.getLocalizedMessage());
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://shingubotanic-d2239-default-rtdb.firebaseio.com/");

        //봄
        DatabaseReference dbRef = database.getReference().child("plantInfo").child("spring");

        //Database
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val1 = dataSnapshot.child("plant1-1").getValue(String.class);
                x1.setText(val1);
                String val2 = dataSnapshot.child("plant1-2").getValue(String.class);
                x2.setText(val2);
                String val3 = dataSnapshot.child("plant1-3").getValue(String.class);
                x3.setText(val3);
                String val4 = dataSnapshot.child("plant2-1").getValue(String.class);
                x4.setText(val4);
                String val5 = dataSnapshot.child("plant2-2").getValue(String.class);
                x5.setText(val5);
                String val6 = dataSnapshot.child("plant2-3").getValue(String.class);
                x6.setText(val6);
                String val7 = dataSnapshot.child("plant3-1").getValue(String.class);
                x7.setText(val7);
                String val8 = dataSnapshot.child("plant3-2").getValue(String.class);
                x8.setText(val8);
                String val9 = dataSnapshot.child("plant3-3").getValue(String.class);
                x9.setText(val9);
                String val10 = dataSnapshot.child("plant4-1").getValue(String.class);
                x10.setText(val10);
                String val11 = dataSnapshot.child("plant4-2").getValue(String.class);
                x11.setText(val11);
                String val12 = dataSnapshot.child("plant4-3").getValue(String.class);
                x12.setText(val12);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        //여름
        DatabaseReference dbRef2 = database.getReference().child("plantInfo").child("summer");

        //Database
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val13 = dataSnapshot.child("plant1-1").getValue(String.class);
                x13.setText(val13);
                String val14 = dataSnapshot.child("plant1-2").getValue(String.class);
                x14.setText(val14);
                String val15 = dataSnapshot.child("plant1-3").getValue(String.class);
                x15.setText(val15);
                String val16 = dataSnapshot.child("plant2-1").getValue(String.class);
                x16.setText(val16);
                String val17 = dataSnapshot.child("plant2-2").getValue(String.class);
                x17.setText(val17);
                String val18 = dataSnapshot.child("plant2-3").getValue(String.class);
                x18.setText(val18);
                String val19 = dataSnapshot.child("plant3-1").getValue(String.class);
                x19.setText(val19);
                String val20 = dataSnapshot.child("plant3-2").getValue(String.class);
                x20.setText(val20);
                String val21 = dataSnapshot.child("plant3-3").getValue(String.class);
                x21.setText(val21);
                String val22 = dataSnapshot.child("plant4-1").getValue(String.class);
                x22.setText(val22);
                String val23 = dataSnapshot.child("plant4-2").getValue(String.class);
                x23.setText(val23);
                String val24 = dataSnapshot.child("plant4-3").getValue(String.class);
                x24.setText(val24);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        //가을
        DatabaseReference dbRef3 = database.getReference().child("plantInfo").child("fall");

        //Database
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val25 = dataSnapshot.child("plant1-1").getValue(String.class);
                x25.setText(val25);
                String val26 = dataSnapshot.child("plant1-2").getValue(String.class);
                x26.setText(val26);
                String val27 = dataSnapshot.child("plant1-3").getValue(String.class);
                x27.setText(val27);
                String val28 = dataSnapshot.child("plant2-1").getValue(String.class);
                x28.setText(val28);
                String val29 = dataSnapshot.child("plant2-2").getValue(String.class);
                x29.setText(val29);
                String val30 = dataSnapshot.child("plant2-3").getValue(String.class);
                x30.setText(val30);
                String val31 = dataSnapshot.child("plant3-1").getValue(String.class);
                x31.setText(val31);
                String val32 = dataSnapshot.child("plant3-2").getValue(String.class);
                x32.setText(val32);
                String val33 = dataSnapshot.child("plant3-3").getValue(String.class);
                x33.setText(val33);
                String val34 = dataSnapshot.child("plant4-1").getValue(String.class);
                x34.setText(val34);
                String val35 = dataSnapshot.child("plant4-2").getValue(String.class);
                x35.setText(val35);
                String val36 = dataSnapshot.child("plant4-3").getValue(String.class);
                x36.setText(val36);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        //겨울
        DatabaseReference dbRef4 = database.getReference().child("plantInfo").child("winter");

        //Database
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String val37 = dataSnapshot.child("plant1-1").getValue(String.class);
                x37.setText(val37);
                String val38 = dataSnapshot.child("plant1-2").getValue(String.class);
                x38.setText(val38);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.info_back:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                }
            }
        };
        back.setOnClickListener(cl);

    }

    //봄
    public void clickImg1(View v){
        info_spring_plant1_dol ispd1 = info_spring_plant1_dol.getInstance();
        ispd1.show(getSupportFragmentManager(), info_spring_plant1_dol.TAG_EVENT_DIALOG);
    }

    public void clickImg2(View v){
        info_spring_plant2_soo ispd2 = info_spring_plant2_soo.getInstance();
        ispd2.show(getSupportFragmentManager(), info_spring_plant2_soo.TAG_EVENT_DIALOG);
    }

    public void clickImg3(View v){
        info_spring_plant3_man ispd3 = info_spring_plant3_man.getInstance();
        ispd3.show(getSupportFragmentManager(), info_spring_plant3_man.TAG_EVENT_DIALOG);
    }

    public void clickImg4(View v){
        info_spring_plant4_white ispd4 = info_spring_plant4_white.getInstance();
        ispd4.show(getSupportFragmentManager(), info_spring_plant4_white.TAG_EVENT_DIALOG);
    }

    public void clickImg5(View v){
        info_spring_plant5_je ispd5 = info_spring_plant5_je.getInstance();
        ispd5.show(getSupportFragmentManager(), info_spring_plant5_je.TAG_EVENT_DIALOG);
    }

    public void clickImg6(View v){
        info_spring_plant6_jang ispd6 = info_spring_plant6_jang.getInstance();
        ispd6.show(getSupportFragmentManager(), info_spring_plant6_jang.TAG_EVENT_DIALOG);
    }

    public void clickImg7(View v){
        info_spring_plant7_soo ispd7 = info_spring_plant7_soo.getInstance();
        ispd7.show(getSupportFragmentManager(), info_spring_plant7_soo.TAG_EVENT_DIALOG);
    }

    public void clickImg8(View v){
        info_spring_plant8_he ispd8 = info_spring_plant8_he.getInstance();
        ispd8.show(getSupportFragmentManager(), info_spring_plant8_he.TAG_EVENT_DIALOG);
    }

    public void clickImg9(View v){
        info_spring_plant9_mok ispd9 = info_spring_plant9_mok.getInstance();
        ispd9.show(getSupportFragmentManager(), info_spring_plant9_mok.TAG_EVENT_DIALOG);
    }

    public void clickImg10(View v){
        info_spring_plant10_jin ispd10 = info_spring_plant10_jin.getInstance();
        ispd10.show(getSupportFragmentManager(), info_spring_plant10_jin.TAG_EVENT_DIALOG);
    }

    public void clickImg11(View v){
        info_spring_plant11_kkang ispd11 = info_spring_plant11_kkang.getInstance();
        ispd11.show(getSupportFragmentManager(), info_spring_plant11_kkang.TAG_EVENT_DIALOG);
    }

    public void clickImg12(View v){
        info_spring_plant12_no ispd12 = info_spring_plant12_no.getInstance();
        ispd12.show(getSupportFragmentManager(), info_spring_plant12_no.TAG_EVENT_DIALOG);
    }


    //여름
    public void clickImg13(View v){
        info_summer_plant1_dol isspd1 = info_summer_plant1_dol.getInstance();
        isspd1.show(getSupportFragmentManager(), info_summer_plant1_dol.TAG_EVENT_DIALOG);
    }

    public void clickImg14(View v){
        info_summer_plant2_jung isspd2 = info_summer_plant2_jung.getInstance();
        isspd2.show(getSupportFragmentManager(), info_summer_plant2_jung.TAG_EVENT_DIALOG);
    }

    public void clickImg15(View v){
        info_summer_plant3_byeong isspd3 = info_summer_plant3_byeong.getInstance();
        isspd3.show(getSupportFragmentManager(), info_summer_plant3_byeong.TAG_EVENT_DIALOG);
    }

    public void clickImg16(View v){
        info_summer_plant4_sum isspd4 = info_summer_plant4_sum.getInstance();
        isspd4.show(getSupportFragmentManager(), info_summer_plant4_sum.TAG_EVENT_DIALOG);
    }

    public void clickImg17(View v){
        info_summer_plant5_ki isspd5 = info_summer_plant5_ki.getInstance();
        isspd5.show(getSupportFragmentManager(), info_summer_plant5_ki.TAG_EVENT_DIALOG);
    }

    public void clickImg18(View v){
        info_summer_plant6_sum isspd6 = info_summer_plant6_sum.getInstance();
        isspd6.show(getSupportFragmentManager(), info_summer_plant6_sum.TAG_EVENT_DIALOG);
    }

    public void clickImg19(View v){
        info_summer_plant7_mool isspd7 = info_summer_plant7_mool.getInstance();
        isspd7.show(getSupportFragmentManager(), info_summer_plant7_mool.TAG_EVENT_DIALOG);
    }

    public void clickImg20(View v){
        info_summer_plant8_mae isspd8 = info_summer_plant8_mae.getInstance();
        isspd8.show(getSupportFragmentManager(), info_summer_plant8_mae.TAG_EVENT_DIALOG);
    }

    public void clickImg21(View v){
        info_summer_plant9_hae isspd9 = info_summer_plant9_hae.getInstance();
        isspd9.show(getSupportFragmentManager(), info_summer_plant9_hae.TAG_EVENT_DIALOG);
    }

    public void clickImg22(View v){
        info_summer_plant10_bak isspd10 = info_summer_plant10_bak.getInstance();
        isspd10.show(getSupportFragmentManager(), info_summer_plant10_bak.TAG_EVENT_DIALOG);
    }

    public void clickImg23(View v){
        info_summer_plant11_tae isspd11 = info_summer_plant11_tae.getInstance();
        isspd11.show(getSupportFragmentManager(), info_summer_plant11_tae.TAG_EVENT_DIALOG);
    }

    public void clickImg24(View v){
        info_summer_plant12_ddae isspd12 = info_summer_plant12_ddae.getInstance();
        isspd12.show(getSupportFragmentManager(), info_summer_plant12_ddae.TAG_EVENT_DIALOG);
    }

    //가을
    public void clickImg25(View v){
        info_fall_plant1_ga ifpg1 = info_fall_plant1_ga.getInstance();
        ifpg1.show(getSupportFragmentManager(), info_fall_plant1_ga.TAG_EVENT_DIALOG);
    }

    public void clickImg26(View v){
        info_fall_plant2_gae ifpg2 = info_fall_plant2_gae.getInstance();
        ifpg2.show(getSupportFragmentManager(), info_fall_plant2_gae.TAG_EVENT_DIALOG);
    }

    public void clickImg27(View v){
        info_fall_plant3_dan ifpg3 = info_fall_plant3_dan.getInstance();
        ifpg3.show(getSupportFragmentManager(), info_fall_plant3_dan.TAG_EVENT_DIALOG);
    }

    public void clickImg28(View v){
        info_fall_plant4_go ifpg4 = info_fall_plant4_go.getInstance();
        ifpg4.show(getSupportFragmentManager(), info_fall_plant4_go.TAG_EVENT_DIALOG);
    }

    public void clickImg29(View v){
        info_fall_plant5_goo ifpg5 = info_fall_plant5_goo.getInstance();
        ifpg5.show(getSupportFragmentManager(), info_fall_plant5_goo.TAG_EVENT_DIALOG);
    }

    public void clickImg30(View v){
        info_fall_plant6_dong ifpg6 = info_fall_plant6_dong.getInstance();
        ifpg6.show(getSupportFragmentManager(), info_fall_plant6_dong.TAG_EVENT_DIALOG);
    }

    public void clickImg31(View v){
        info_fall_plant7_black ifpg2 = info_fall_plant7_black.getInstance();
        ifpg2.show(getSupportFragmentManager(), info_fall_plant7_black.TAG_EVENT_DIALOG);
    }

    public void clickImg32(View v){
        info_fall_plant8_hae ifpg8 = info_fall_plant8_hae.getInstance();
        ifpg8.show(getSupportFragmentManager(), info_fall_plant8_hae.TAG_EVENT_DIALOG);
    }

    public void clickImg33(View v){
        info_fall_plant9_ga ifpg9 = info_fall_plant9_ga.getInstance();
        ifpg9.show(getSupportFragmentManager(), info_fall_plant9_ga.TAG_EVENT_DIALOG);
    }

    public void clickImg34(View v){
        info_fall_plant10_go ifpg10 = info_fall_plant10_go.getInstance();
        ifpg10.show(getSupportFragmentManager(), info_fall_plant10_go.TAG_EVENT_DIALOG);
    }

    public void clickImg35(View v){
        info_fall_plant11_yong ifpg11 = info_fall_plant11_yong.getInstance();
        ifpg11.show(getSupportFragmentManager(), info_fall_plant11_yong.TAG_EVENT_DIALOG);
    }

    public void clickImg36(View v){
        info_fall_plant12_bae ifpg12 = info_fall_plant12_bae.getInstance();
        ifpg12.show(getSupportFragmentManager(), info_fall_plant12_bae.TAG_EVENT_DIALOG);
    }

    //겨울
    public void clickImg37(View v){
        info_winter_plant1_ae iwpa1 = info_winter_plant1_ae.getInstance();
        iwpa1.show(getSupportFragmentManager(), info_winter_plant1_ae.TAG_EVENT_DIALOG);
    }

    public void clickImg38(View v){
        info_winter_plant2_bok iwpa2 = info_winter_plant2_bok.getInstance();
        iwpa2.show(getSupportFragmentManager(), info_winter_plant2_bok.TAG_EVENT_DIALOG);
    }


}
