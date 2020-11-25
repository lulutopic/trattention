package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //設定隱藏標題
        getSupportActionBar().hide();

        //註冊的文字跳轉
        TextView re = (TextView) findViewById(R.id.registration1);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View fp) {
                Intent intent = new Intent();
                intent.setClass(login.this, registration.class);
                startActivity(intent);
            }
        });

        //忘記密碼的文字跳轉
        TextView fp = (TextView) findViewById(R.id.ForgetPassword);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(login.this, registration.class);
                startActivity(intent);
            }
        });


    }


}
