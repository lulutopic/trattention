package com.example.trattention;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class lastTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_test);
        //設定隱藏標題
        getSupportActionBar().hide();
    }
}