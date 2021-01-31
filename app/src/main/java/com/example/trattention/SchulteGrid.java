package com.example.trattention;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;

import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.View;

import java.util.Arrays;
import java.util.Collections;



public class SchulteGrid extends AppCompatActivity {
    private Long startTime;
    private Chronometer timer;
    private Handler handler = new Handler();

    //圖片的id設定的變數
    ImageView one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen;




    //array for the images
    Integer[] NumArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

    int image101,image102,image103,image104,image105,image106,image107,image108,
            image201,image202,image203,image204,image205,image206,image207,image208;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schulte_grid);
        //設定隱藏標題
        getSupportActionBar().hide();
        timer = (Chronometer) findViewById(R.id.timer);
        //取得目前時間
        startTime = System.currentTimeMillis();
        //設定定時要執行的方法
        handler.removeCallbacks(updateTimer);
        //設定Delay的時間
        handler.postDelayed(updateTimer, 10);


        //game
        one=(ImageView)findViewById(R.id.one);
        two=(ImageView)findViewById(R.id.two);
        three=(ImageView)findViewById(R.id.three);
        four=(ImageView)findViewById(R.id.four);
        five=(ImageView)findViewById(R.id.five);
        six=(ImageView)findViewById(R.id.six);
        seven=(ImageView)findViewById(R.id.seven);
        eight=(ImageView)findViewById(R.id.eight);
        nine=(ImageView)findViewById(R.id.nine);
        ten=(ImageView)findViewById(R.id.ten);
        eleven=(ImageView)findViewById(R.id.eleven);
        twelve=(ImageView)findViewById(R.id.twelve);
        thirteen=(ImageView)findViewById(R.id.thirteen);
        fourteen=(ImageView)findViewById(R.id.fourteen);
        fifteen=(ImageView)findViewById(R.id.fifteen);
        sixteen=(ImageView)findViewById(R.id.sixteen);


        one.setTag("1");
        two.setTag("2");
        three.setTag("3");
        four.setTag("4");
        five.setTag("5");
        six.setTag("6");
        seven.setTag("7");
        eight.setTag("8");
        nine.setTag("9");
        ten.setTag("10");
        eleven.setTag("11");
        twelve.setTag("12");
        thirteen.setTag("13");
        fourteen.setTag("14");
        fifteen.setTag("15");
        sixteen.setTag("16");

        frontOfCardsResources();
        Collections.shuffle(Arrays.asList(NumArray));

        //Listener 等待使用者點擊此事件
        //override 覆蓋掉原本android studio 上層物件


        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(one,theCard);
                doStuff(one,theCard);

            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(two,theCard);
                doStuff(two,theCard);
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(three,theCard);
                doStuff(three,theCard);
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(four,theCard);
                doStuff(four,theCard);
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(five,theCard);
                doStuff(five,theCard);
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(six,theCard);
                doStuff(six,theCard);
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(seven,theCard);
                doStuff(seven,theCard);
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(eight,theCard);
                doStuff(eight,theCard);
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(nine,theCard);
                doStuff(nine,theCard);
            }
        });
        ten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(ten,theCard);
                doStuff(ten,theCard);
            }
        });
        eleven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(eleven,theCard);
                doStuff(eleven,theCard);
            }
        });
        twelve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(twelve,theCard);
                doStuff(twelve,theCard);
            }
        });
        thirteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(thirteen,theCard);
                doStuff(thirteen,theCard);
            }
        });
        fourteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(fourteen,theCard);
                doStuff(fourteen,theCard);
            }
        });
        fifteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(fifteen,theCard);
                doStuff(fifteen,theCard);
            }
        });
        sixteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String)view.getTag());
                change(sixteen,theCard);
                doStuff(sixteen,theCard);
            }
        });


    }

    private void doStuff(ImageView iv,int card){
        if(count == card){
            iv.setVisibility(View.INVISIBLE);
            count++;
        }
        else{
            iv.setVisibility(View.VISIBLE);
        }
        checkEnd();
    }

    private void checkEnd() {
        if (count == 17) {
            //頁面跳轉
            Intent intent = new Intent();
            intent.setClass(SchulteGrid.this, SchulteGrid1.class);
            intent.putExtra("time",startTime);
            startActivity(intent);
            finish();

        }
    }

    private void change(ImageView iv,int card) {
        if (NumArray[card] == 1) {
            iv.setImageResource(image101);
        } else if (NumArray[card] == 2) {
            iv.setImageResource(image102);
        } else if (NumArray[card] == 3) {
            iv.setImageResource(image103);
        } else if (NumArray[card] == 4) {
            iv.setImageResource(image104);
        } else if (NumArray[card] == 5) {
            iv.setImageResource(image105);
        } else if (NumArray[card] == 6) {
            iv.setImageResource(image106);
        } else if (NumArray[card] == 7) {
            iv.setImageResource(image107);
        } else if (NumArray[card] == 8) {
            iv.setImageResource(image108);
        } else if (NumArray[card] == 9) {
            iv.setImageResource(image201);
        } else if (NumArray[card] == 10) {
            iv.setImageResource(image202);
        } else if (NumArray[card] == 11) {
            iv.setImageResource(image203);
        } else if (NumArray[card] == 12) {
            iv.setImageResource(image204);
        } else if (NumArray[card] == 13) {
            iv.setImageResource(image205);
        } else if (NumArray[card] == 14) {
            iv.setImageResource(image206);
        } else if (NumArray[card] == 15) {
            iv.setImageResource(image207);
        } else if (NumArray[card] == 16) {
            iv.setImageResource(image208);
        }
    }

    private void frontOfCardsResources(){
        image101=R.drawable.one;
        image102=R.drawable.two;
        image103=R.drawable.three;
        image104=R.drawable.four;
        image105=R.drawable.five;
        image106=R.drawable.six;
        image107=R.drawable.seven;
        image108=R.drawable.eight;
        image201=R.drawable.nine;
        image202=R.drawable.ten;
        image203=R.drawable.eleven;
        image204=R.drawable.twelve;
        image205=R.drawable.thirteen;
        image206=R.drawable.fourteen;
        image207=R.drawable.fifteen;
        image208=R.drawable.sixteen;
    }


    //固定要執行的方法
    private Runnable updateTimer = new Runnable() {
        public void run() {
            final TextView time = (Chronometer) findViewById(R.id.timer);
            Long spentTime = System.currentTimeMillis() - startTime;
            //計算目前已過小時數
            Long hour = (spentTime/1000)/3600;
            //計算目前已過分鐘數
            Long minius = (spentTime/1000)/60;
            //計算目前已過秒數
            Long seconds = (spentTime/1000) % 60;
            String formattedTime = String.format("%02d:%02d:%02d",hour, minius, seconds);
            time.setText(formattedTime);
            handler.postDelayed(this, 1000);
        }
    };



    public void btnClick(View view) {
        timer.setBase(SystemClock.elapsedRealtime());//計時器清零
        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
        timer.setFormat("0"+String.valueOf(hour)+":%s");
    }

}