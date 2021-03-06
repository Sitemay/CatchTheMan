package com.example.sitem.catchthekenny;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textTime;
    TextView textScore;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    int score;
    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1=(ImageView)findViewById(R.id.imageView);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        imageView4=(ImageView)findViewById(R.id.imageView4);
        imageView5=(ImageView)findViewById(R.id.imageView5);
        imageView6=(ImageView)findViewById(R.id.imageView6);
        imageView7=(ImageView)findViewById(R.id.imageView7);
        imageView8=(ImageView)findViewById(R.id.imageView8);
        imageView9=(ImageView)findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        hideImage();

        score=0;

        new CountDownTimer(30000,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                textTime=(TextView)findViewById(R.id.textTime);
                textTime.setText("Time : "+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textTime=(TextView)findViewById(R.id.textTime);
                textTime.setText("Time is off ");
                handler.removeCallbacks(runnable);
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

            }
        }.start();
    }

    public void increaseScore(View view){

        score++;
        textScore=(TextView)findViewById(R.id.textScore);
        textScore.setText("Score: "+score);

    }

    public void hideImage(){
        handler = new Handler();

        runnable= new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                int i=random.nextInt(8-0);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);

            }

        };

        handler.post(runnable);
    }
}
