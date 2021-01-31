package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class instruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        //設定隱藏標題
        getSupportActionBar().hide();
        //頁面跳轉  點選導覽列的home->home
        ImageView button = findViewById(R.id.imagehome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(instruction.this, home.class);
                startActivity(intent);
            }
        });
    }
}