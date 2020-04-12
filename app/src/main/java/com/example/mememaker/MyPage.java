package com.example.mememaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mememaker.custom.SpecialTab;
import com.google.android.material.tabs.TabLayout;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

import com.github.clans.fab.FloatingActionButton;


public class MyPage extends AppCompatActivity {
    //死按鈕宣告
    FloatingActionButton fabMeme, fabElder, fabgif;
    //button onClick to next page
    public Button btnAddMeme;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public PageAdapter pagerAdapter;

    //普通樣子的tab
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text){
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);//預設灰色
        mainTab.setTextCheckedColor(0xFFFEDA84);//主題色
        return mainTab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        // init();

        //死按鈕設定
        fabMeme = findViewById(R.id.fabMeme);
        fabElder = findViewById(R.id.fabElder);
        fabgif = findViewById(R.id.fabgif);

        fabMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You Selected FabExplore!!!!", Toast.LENGTH_LONG).show();
                /**從MAIN 跳到 SECOND 頁面*/
                Intent intent = new Intent(MyPage.this, editMain.class);
                /** 啟動intent */
                intent.setClass(MyPage.this,editMain.class);
                startActivity(intent);
            }
        });

        fabElder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPage.this, "You Selected fabElder!!!!", Toast.LENGTH_LONG).show();

            }
        });

        fabgif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPage.this, "You Selected fabgif!!!!", Toast.LENGTH_LONG).show();
            }
        });

        //tab導覽列
        PageNavigationView tab = findViewById(R.id.tab);

        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.ic_home_gray_24dp,R.drawable.ic_home_teal_24dp,"首頁"))
                .addItem(newItem(R.drawable.ic_public_gray_24dp,R.drawable.ic_public_teal_24dp,"創作區"))
                .addItem(newItem(R.drawable.ic_search_gray_24dp,R.drawable.ic_search_teal_24dp,"搜尋"))
                .addItem(newItem(R.drawable.ic_person_gray_24dp,R.drawable.ic_person_teal_24dp,"我的"))
                .build();
        //監聽tab點擊
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发
                StringBuffer sb = new StringBuffer();
                sb.append("old=").append(old).append(",index=").append(index);
                Log.d("TAB", sb.toString());

                switch (index){
                    case 0://跳到首頁
                        /**從MAIN 跳到 Main 頁面*/
                        Intent intent = new Intent(MyPage.this, MainActivity.class);
                        /** 啟動intent */
                        intent.setClass(MyPage.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发
            }
        });
    }
}
