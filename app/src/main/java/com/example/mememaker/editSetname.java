package com.example.mememaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editSetname extends AppCompatActivity {
    //button onClick to next page
    public Button btnNext;
    public EditText setName;

    public void init(){
        btnNext = (Button)findViewById(R.id.btnNext);
        setName = (EditText)findViewById(R.id.setName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //用getText取得輸入在EditText裡的內容
                String templateName = setName.getText().toString();

                //new一個intent物件，並指定Activity切換的class
                Intent edit = new Intent(editSetname.this,editTools.class);
                //切換Activity
                startActivity(edit);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_setname);
        init();
    }
}
