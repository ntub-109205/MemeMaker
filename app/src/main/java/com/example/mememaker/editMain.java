package com.example.mememaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.net.Uri;
public class editMain extends AppCompatActivity {
    public Button btnAddMeme;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2;
    public PageAdapter pagerAdapter;
    Uri uri;
    //button onClick to next page
    public void init(){
        btnAddMeme = (Button)findViewById(R.id.btnAddmeme);
        btnAddMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                //開啟Pictures畫面Type設定為image
                intent.setType("image/*");
                //使用Intent.ACTION_GET_CONTENT這個Action                                            //會開啟選取圖檔視窗讓您選取手機內圖檔
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片後返回本畫面

                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_main);

        tabLayout = (TabLayout)findViewById(R.id.editTablayout);
        tab1 = (TabItem)findViewById(R.id.editTab1);
        tab2 = (TabItem)findViewById(R.id.editTab2);
        viewPager = (ViewPager)findViewById(R.id.editViewPager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        init();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當使用者按下確定後
        if (resultCode == RESULT_OK) {
            //取得圖檔的路徑位置
            uri = data.getData();
            //寫log
            Intent edit = new Intent();

            edit.putExtra("Uri", uri.toString());
            edit.setData(uri);
            edit.setClass(editMain.this,editSetname.class);
            startActivity(edit);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
