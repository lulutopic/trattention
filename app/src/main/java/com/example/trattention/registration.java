package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class registration extends AppCompatActivity {

    private Spinner Spingender;
    private Spinner Spinage;

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mSignup,forgotTextLink;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //設定隱藏標題
        getSupportActionBar().hide();

        //抓使用者輸入的值
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.login);
        mSignup = findViewById(R.id.registration);
        forgotTextLink = findViewById(R.id.ForgetPassword);
        fAuth = FirebaseAuth.getInstance();

        mSignup.setOnClickListener(view -> {
            fAuth.createUserWithEmailAndPassword(mEmail.getText().toString(),
                    mPassword.getText().toString())
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(registration.this, "註冊成功", Toast.LENGTH_LONG).show();
                            mEmail.setText("");
                            mPassword.setText("");
                        }
                        else{
                            Toast.makeText(registration.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        });



        //設定註冊按鈕切換到登入頁面
        Button btn_to_B = (Button) findViewById(R.id.registration);
        btn_to_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(registration.this, login.class);
                startActivity(intent);
            }
        });


        Spingender = (Spinner) findViewById(R.id.gender);

        ArrayAdapter<CharSequence> arrAdapSpn
                = ArrayAdapter.createFromResource(registration.this, //對應的Context
                R.array.gender, //選項資料內容
                android.R.layout.simple_spinner_item); //自訂getView()介面格式(Spinner介面未展開時的View)

        arrAdapSpn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //自訂getDropDownView()介面格式(Spinner介面展開時，View所使用的每個item格式)
        Spingender.setAdapter(arrAdapSpn); //將宣告好的 Adapter 設定給 Spinner
        Spingender.setOnItemSelectedListener(spnRegionOnItemSelected);

        Spinage = (Spinner) findViewById(R.id.age);

        ArrayAdapter<CharSequence> arrAdapSpn1
                = ArrayAdapter.createFromResource(registration.this, //對應的Context
                R.array.age, //選項資料內容
                android.R.layout.simple_spinner_item); //自訂getView()介面格式(Spinner介面未展開時的View)

        arrAdapSpn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //自訂getDropDownView()介面格式(Spinner介面展開時，View所使用的每個item格式)
        Spinage.setAdapter(arrAdapSpn1); //將宣告好的 Adapter 設定給 Spinner
        Spinage.setOnItemSelectedListener(spnRegionOnItemSelected);
    }

    private AdapterView.OnItemSelectedListener spnRegionOnItemSelected
            = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
        {
            // TODO Auto-generated method stub
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {
            // TODO Auto-generated method stub
        }
    };
}

