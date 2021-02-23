package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class gameselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameselect);
        //設定隱藏標題
        getSupportActionBar().hide();

        //頁面跳轉  點選 導覽列home->home
        ImageView button4 = findViewById(R.id.imagehome);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(gameselect.this, home.class);
                startActivity(intent);
            }
        });
        //頁面跳轉  點選 圖形配對遊戲->進入遊戲
        ImageView button = findViewById(R.id.imageView1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(gameselect.this, imagePair.class);
                startActivity(intent);
            }
        });
        //頁面跳轉  點選 舒方遊戲->進入遊戲
        ImageView button1 = findViewById(R.id.imageView2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(gameselect.this, SchulteGrid.class);
                startActivity(intent);
            }
        });
        //頁面跳轉  點選 記憶力遊戲->進入遊戲
        ImageView button2 = findViewById(R.id.imageView3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(gameselect.this, MemoryGame.class);
                startActivity(intent);
            }
        });
    }
}