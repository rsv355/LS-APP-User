package com.ls.mybrandtherapist;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ls.mybrandtherapist.helper.Functions;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(Functions.isInternetConnected(SplashActivity.this)){
            Toast.makeText(SplashActivity.this,getResources().getString(R.string.internet_error),Toast.LENGTH_SHORT).show();
        }else {

            new CountDownTimer(1500, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                }
            };
        }

    }

}
