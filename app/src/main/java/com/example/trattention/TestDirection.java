package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TestDirection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_direction);
        //設定隱藏標題
        getSupportActionBar().hide();
    }
}