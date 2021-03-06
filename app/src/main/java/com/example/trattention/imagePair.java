package com.example.trattention;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class imagePair extends AppCompatActivity {

    private Long startTime; //初始時間
    private Chronometer timer; //已經過時間
    private Handler handler = new Handler();


    private ArrayList<String> colorNames = new ArrayList<>();
    private ArrayList<Integer> colorValues = new ArrayList<>();
    private ArrayList<TextView> button = new ArrayList<>();

    private Random random;

    private TextView colorTextView;

    private TextView redImageButton;
    private TextView blueImageButton;
    private TextView greenImageButton;

    int count = 0;


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
        random = new Random();
        populateBothArraylists();
        getRandomColor();
        setupViewsAndListeners();

    }

    private void setupViewsAndListeners(){

        redImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Convert background to drawable.
                //ColorDrawable col = (ColorDrawable) v.getBackground();

                //Get color of drawable.
                int color = redImageButton.getCurrentTextColor();

                if(color == colorTextView.getCurrentTextColor()){
                    count++;
                    getRandomColor();
                    checkEnd();
                }
            }
        });
        greenImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Convert background to drawable.
                //ColorDrawable col = (ColorDrawable) v.getC();

                //Get color of drawable.
                int color = greenImageButton.getCurrentTextColor();

                if(color == colorTextView.getCurrentTextColor()){
                    count++;
                    getRandomColor();
                    checkEnd();
                }
            }
        });
        blueImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Convert background to drawable.
                //ColorDrawable col = (ColorDrawable) v.getBackground();

                //Get color of drawable.
                int color = blueImageButton.getCurrentTextColor();

                if(color == colorTextView.getCurrentTextColor()){
                    count++;
                    checkEnd();
                    getRandomColor();
                }
            }
        });
    }

    private void checkEnd(){
        if(count == 3){
            //頁面跳轉
            Intent intent = new Intent();
            intent.setClass(imagePair.this, home.class);
            intent.putExtra("time",startTime);
            startActivity(intent);
            finish();
        }
    }



    private void populateBothArraylists(){
        colorTextView = (TextView) findViewById(R.id.question);

        redImageButton = (TextView) findViewById(R.id.optionA);
        blueImageButton = (TextView)findViewById(R.id.optionB);
        greenImageButton = (TextView) findViewById(R.id.optionC);

        //add color names to the ArrayList
        colorNames.add("紅色");
        colorNames.add("藍色");
        colorNames.add("綠色");

        //Add color values to the arraylist
        colorValues.add(ContextCompat.getColor(this,R.color.colorRed));
        colorValues.add(ContextCompat.getColor(this,R.color.colorGreen));
        colorValues.add(ContextCompat.getColor(this,R.color.colorBlue));

        button.add(redImageButton);
        button.add(blueImageButton);
        button.add(greenImageButton);
    }

    private void getRandomColor(){

        //Add a bit more randomness
        Collections.shuffle(colorNames);
        Collections.shuffle(colorValues);
        Collections.shuffle(button);

        //using a random number to get a random color from the arrayList

        String colorChosen1 = colorNames.get(0);
        String colorChosen2 = colorNames.get(1);
        String colorChosen3 = colorNames.get(2);


        //set this random color to be the text that is shown at the bottom
        colorTextView.setText(colorChosen1);
        button.get(0).setText(colorChosen1);
        button.get(1).setText(colorChosen2);
        button.get(2).setText(colorChosen3);


        //chose an actual color to be randomly generated for the text

        colorTextView.setTextColor(colorValues.get(0));
        button.get(0).setTextColor(colorValues.get(0));
        button.get(1).setTextColor(colorValues.get(1));
        button.get(2).setTextColor(colorValues.get(2));

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