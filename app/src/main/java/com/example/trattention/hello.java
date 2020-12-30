package com.example.trattention;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class hello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        //設定隱藏標題
        getSupportActionBar().hide();
    }
}