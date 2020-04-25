package com.example.mememaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mememaker.custom.SpecialTab;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
//
//import me.majiajie.pagerbottomtabstrip.NavigationController;
//import me.majiajie.pagerbottomtabstrip.PageNavigationView;
//import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
//import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

import com.github.clans.fab.FloatingActionButton;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //死按鈕宣告
    FloatingActionButton fabMeme, fabElder, fabgif;
    //button onClick to next page
    public Button btnAddMeme;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public PageAdapter pagerAdapter;
    int tabIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // init();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        //死按鈕設定
        fabMeme = findViewById(R.id.fabMeme);
        fabElder = findViewById(R.id.fabElder);
        fabgif = findViewById(R.id.fabgif);

        fabMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You Selected FabExplore!!!!", Toast.LENGTH_LONG).show();
                /**從MAIN 跳到 SECOND 頁面*/
                Intent intent = new Intent(MainActivity.this, editMain.class);
                /** 啟動intent */
                intent.setClass(MainActivity.this,editMain.class);
                startActivity(intent);
            }
        });

        fabElder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Selected fabElder!!!!", Toast.LENGTH_LONG).show();

            }
        });

        fabgif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Selected fabgif!!!!", Toast.LENGTH_LONG).show();
            }
        });

//
        //fragment cardview
        tabLayout = (TabLayout)findViewById(R.id.mainTablayout);
        viewPager = (ViewPager)findViewById(R.id.mainViewPager);
        pagerAdapter = new PageAdapter(getSupportFragmentManager());

        //Add Fragment here
        pagerAdapter.AddFragment(new maintab1(),"梗圖模板");
        pagerAdapter.AddFragment(new maintab2(),"長輩圖模板");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        //tab導覽列
//        PageNavigationView tab = findViewById(R.id.tab);
//
//        NavigationController navigationController = tab.custom()
//                .addItem(newItem(R.drawable.ic_home_gray_24dp,R.drawable.ic_home_teal_24dp,"首頁"))
//                .addItem(newItem(R.drawable.ic_public_gray_24dp,R.drawable.ic_public_teal_24dp,"創作區"))
//                .addItem(newItem(R.drawable.ic_search_gray_24dp,R.drawable.ic_search_teal_24dp,"搜尋"))
//                .addItem(newItem(R.drawable.ic_person_gray_24dp,R.drawable.ic_person_teal_24dp,"我的"))
//                .build();
//        //監聽tab點擊
//        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
//            @Override
//            public void onSelected(int index, int old) {
//                //选中时触发
//                StringBuffer sb = new StringBuffer();
//                sb.append("old=").append(old).append(",index=").append(index);
//                Log.d("TAB", sb.toString());
//                tabIndex = index;
//
//                switch (index){
//                    case 0://跳到首頁
////
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        /**從MAIN 跳到 我的 頁面*/
//                        Intent intent = new Intent(MainActivity.this, MyPage.class);
//                        /** 啟動intent */
//                        intent.setClass(MainActivity.this,MyPage.class);
//                        startActivity(intent);
//                        break;
//                    default:
//                        break;
//                }
//            }
//
//            @Override
//            public void onRepeat(int index) {
//                //重复选中时触发
//            }
           }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_public:
                            selectedFragment = new PublicFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_person:
                            selectedFragment = new PersonFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
   }
