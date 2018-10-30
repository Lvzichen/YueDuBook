package com.example.administrator.yuedubook;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class WelcomeActivity extends AppCompatActivity {
    private static int SPLASH_DURATION = 1500;
    private ImageView welcomeImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeactivity);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.welcomeactivity);
        welcomeImageView = (ImageView) findViewById(R.id.wecome_img);
        Glide.with(this).load(R.drawable.startbg_default).crossFade(SPLASH_DURATION).into(welcomeImageView);
        startAppDelay();

        /* This is a delay template */
        /**
         new CountDownTimer(700, 100) {
        @Override
        public void onTick(long millisUntilFinished) {
        // Animation can be here.
        }

        @Override
        public void onFinish() {
        // time-up, and jump
        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        // overridePendingTransition(R.anim.fade_in, R.anim.hold); // fade in animation
        overridePendingTransition(anim.abc_grow_fade_in_from_bottom, anim.abc_shrink_fade_out_from_bottom);
        finish(); // destroy itself
        }
        }.start();  */
    }

    private void startAppDelay() {
        welcomeImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, SPLASH_DURATION);
    }

    private void startApp() {
        startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(android.support.v7.appcompat.R.anim.abc_grow_fade_in_from_bottom,
                android.support.v7.appcompat.R.anim.abc_shrink_fade_out_from_bottom);
        finish(); // destroy itself
    }

    @Override
    public void onBackPressed() {
        //disable back button when showing splash
    }
}
