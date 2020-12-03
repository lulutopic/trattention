package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class gameresult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameresult);
        //設定隱藏標題
        getSupportActionBar().hide();
    }
}