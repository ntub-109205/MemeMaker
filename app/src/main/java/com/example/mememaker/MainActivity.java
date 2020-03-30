package com.example.mememaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //button onClick to next page
    public Button btnAddMeme;

    public void init(){
        btnAddMeme = (Button)findViewById(R.id.button1);
        btnAddMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent edit = new Intent(MainActivity.this,editMain.class);
                startActivity(edit);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
