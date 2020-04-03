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

public class editMain extends AppCompatActivity {
    public Button btnAddMeme;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public PageAdapter pagerAdapter;

    //button onClick to next page
    public void init(){
        btnAddMeme = (Button)findViewById(R.id.btnAddmeme);
        btnAddMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //new一個intent物件，並指定Activity切換的class
                Intent edit = new Intent(editMain.this,editChoosePhoto.class);
                startActivity(edit);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_main);

        tabLayout = (TabLayout)findViewById(R.id.editTablayout);
        viewPager = (ViewPager)findViewById(R.id.editViewPager);
        pagerAdapter = new PageAdapter(getSupportFragmentManager());

        //Add Fragment here
        pagerAdapter.AddFragment(new edittab1(),"熱門模板");
        pagerAdapter.AddFragment(new edittab2(),"我的模板");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        init();
    }
}
