package com.example.trattention;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    TextView userEmail;
    Button userLogout;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//一定要回傳 super
        setContentView(R.layout.activity_personal);

        userEmail = findViewById(R.id.email);
        userLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
//                startActivity(());

            }

        });
    }
    //登出帳號，並且移除 session
    public void logout(User user){
        SessionManagement sessionManagement = new SessionManagement(ProfileActivity.this);
        sessionManagement.removeSession();
        //登出後，回到 login 頁面
        moverToLogin();
    }

    private void moverToLogin() {
        Intent intent = new Intent(ProfileActivity.this, login.class);//還要改導向位置，mainactivity 用於測試登出畫面
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



}

