package com.harsha.dell.placesnearby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActi extends AppCompatActivity {

    ImageView map,marker;
    Animation anim,anim1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        map= (ImageView) findViewById(R.id.iv1);
        marker= (ImageView) findViewById(R.id.iv2);
        anim= AnimationUtils.loadAnimation(this, R.anim.move);
        anim1= AnimationUtils.loadAnimation(this,R.anim.size);
        marker.startAnimation(anim);
        Thread t=new Thread() {
            public void run() {
                try {
                    Thread.sleep(2800);
                    Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();


    }
}
