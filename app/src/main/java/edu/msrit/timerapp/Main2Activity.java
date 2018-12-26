package edu.msrit.timerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView timeLeft,timeUp,time;
    ImageView imageView2;
    Button button2;
    int millis;
    MediaPlayer m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        time=(TextView)findViewById(R.id.time);
        timeLeft=(TextView)findViewById(R.id.timeLeft);
        timeUp=(TextView)findViewById(R.id.timeUp);
        button2=(Button)findViewById(R.id.button2);
        m1=MediaPlayer.create(this,R.raw.bell);

        String getTime=getIntent().getStringExtra("time");
        time.setText(getTime);
        millis=1000*(Integer.parseInt(getTime));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(millis, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        time.setText(Long.toString(millisUntilFinished/1000));

                    }

                    @Override
                    public void onFinish() {
                        m1.start();
                        timeUp.setText("TIME UP!!");


                    }
                }.start();

            }
        });


    }
}
