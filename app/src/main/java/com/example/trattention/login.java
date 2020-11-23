package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //設定隱藏標題
        getSupportActionBar().hide();
        TextView textview_ForgetPassword = (TextView) findViewById(R.id.ForgetPassword);

        textview_ForgetPassword.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textview_Registration = (TextView) findViewById(R.id.registration1);

        textview_Registration.setMovementMethod(LinkMovementMethod.getInstance());

        
    }

}
