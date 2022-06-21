package com.example.charades.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.charades.R;

import java.util.concurrent.Delayed;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    ImageView imageView, imageView2;
    Animation animZoomout, animZoomin;
    Animation animZoomout2, animZoomin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.image);
        imageView2 = findViewById(R.id.image1);

        animZoomout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);
        animZoomout.setAnimationListener(this);
        imageView.startAnimation(animZoomout);

        animZoomout2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out_delayed);
        animZoomout2.setAnimationListener(this);
        imageView2.startAnimation(animZoomout2);

        animZoomin = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);
        animZoomin.setAnimationListener(this);
        imageView.startAnimation(animZoomin);

        animZoomin2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in_delayed);
        animZoomin2.setAnimationListener(this);
        imageView2.startAnimation(animZoomin2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 4000);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}