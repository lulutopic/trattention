package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //設定隱藏標題
        getSupportActionBar().hide();

        //頁面跳轉  點選導覽列的小燈泡->指南
        ImageView button1 = findViewById(R.id.imagesafari);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(home.this, instruction.class);
                startActivity(intent);
            }
        });
        //頁面跳轉->選擇遊戲
        ImageView button2 = findViewById(R.id.start);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(home.this, gameselect.class);
                startActivity(intent);
            }
        });
        //頁面跳轉->個人化設置
        ImageView button = findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(home.this, personal.class);
                startActivity(intent);

            }



        });
    }
}