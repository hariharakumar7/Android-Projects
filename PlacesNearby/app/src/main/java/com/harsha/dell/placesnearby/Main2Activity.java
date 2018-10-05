package com.harsha.dell.placesnearby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv= (TextView) findViewById(R.id.tv);
        tv1= (TextView) findViewById(R.id.tv1);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.size);
        tv.startAnimation(animation);
        tv1.startAnimation(animation);
        Thread t=new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000);
                    Intent i=new Intent(getApplicationContext(),FirstActi.class);
                    startActivity(i);

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

            }
}
