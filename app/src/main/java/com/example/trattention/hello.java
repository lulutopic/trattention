package com.example.trattention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class hello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        //設定隱藏標題
        getSupportActionBar().hide();
        //頁面跳轉  點選進入主頁面->home
        Button button1 = findViewById(R.id.test);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(hello.this, home.class);
                startActivity(intent);
            }
        });
    }
}