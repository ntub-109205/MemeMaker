package com.example.mememaker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//為了看tab監聽加上的
import android.util.Log;
//import  pagerbottomtabstrip  導覽列相關
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import com.example.mememaker.custom.SpecialTab;
import com.example.mememaker.custom.SpecialTabRound;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tab導覽列
        PageNavigationView tab = findViewById(R.id.tab);

        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.ic_home_gray_24dp,R.drawable.ic_home_teal_24dp,"首頁"))
                .addItem(newItem(R.drawable.ic_public_gray_24dp,R.drawable.ic_public_teal_24dp,"創作區"))
                .addItem(newRoundItem(R.drawable.ic_plus_gray_24dp,R.drawable.ic_plus_teal_24dp,"製作"))
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
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发
            }
        });
    }

    //普通樣子的tab
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text){
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);//預設灰色
        mainTab.setTextCheckedColor(0xFFFEDA84);//主題色
        return mainTab;
    }

    //圓形的tab
    private BaseTabItem newRoundItem(int drawable,int checkedDrawable,String text){
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);//預設灰色
        mainTab.setTextCheckedColor(0xFFFEDA84);//主題色
        return mainTab;
    }
}
