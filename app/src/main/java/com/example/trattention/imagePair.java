package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class imagePair extends AppCompatActivity {

    private Long startTime; //初始時間
    private Chronometer timer; //已經過時間
    private Handler handler = new Handler();

    ImageView img01,img02,img03,question;
    LinearLayout optionA,optionB,optionC;

    int[] quesArray = {R.drawable.red_green,R.drawable.blue_red,R.drawable.green_blue};
    int[] ansArray = {R.drawable.red,R.drawable.green,R.drawable.blue};
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pair);
        //設定隱藏標題
        getSupportActionBar().hide();
        timer = (Chronometer) findViewById(R.id.timer);
        //取得目前時間
        startTime = System.currentTimeMillis();
        //設定定時要執行的方法
        handler.removeCallbacks(updateTimer);
        //設定Delay的時間
        handler.postDelayed(updateTimer, 10);

        optionA = (LinearLayout)findViewById(R.id.optionA);
        optionB = (LinearLayout)findViewById(R.id.optionB);
        optionC = (LinearLayout)findViewById(R.id.optionC);
        img01 = (ImageView)findViewById(R.id.img01);
        img02 = (ImageView)findViewById(R.id.img02);
        img03 = (ImageView)findViewById(R.id.img03);
        question = (ImageView) findViewById(R.id.question);

        ImageView[] imgArray = {img01,img02,img03};

        Collections.shuffle(Arrays.asList(imgArray));

        for (int i = 0 ; i < ansArray.length ; i++){
            imgArray[i].setImageResource(ansArray[i]);
        }

    }

    //固定要執行的方法
    private Runnable updateTimer = new Runnable() {
        public void run() {
            final TextView time = (Chronometer) findViewById(R.id.timer);
            Long spentTime = System.currentTimeMillis() - startTime;
            //計算目前已過小時數
            Long hour = (spentTime/1000)/3600;
            //計算目前已過分鐘數
            Long minius = ((spentTime/1000)/60) % 60;
            //計算目前已過秒數
            Long seconds = (spentTime/1000) % 60;
            String formattedTime = String.format("%02d:%02d:%02d",hour, minius, seconds);
            time.setText(formattedTime);
            handler.postDelayed(this, 1000);
        }
    };
}