package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FirstTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);
        //設定隱藏標題
        getSupportActionBar().hide();
    }
}