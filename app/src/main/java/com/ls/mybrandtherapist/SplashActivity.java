package com.ls.mybrandtherapist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.ls.mybrandtherapist.helper.Functions;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imgLogo = (ImageView)findViewById(R.id.imgAppLogo);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(imgLogo, "alpha",  1f, .3f);
        fadeOut.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(imgLogo, "alpha", .3f, 1f);
        fadeIn.setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();

       /* if(Functions.isInternetConnected(SplashActivity.this)){
            new CountDownTimer(1500, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            };

        }else {
            Toast.makeText(SplashActivity.this,getResources().getString(R.string.internet_error),Toast.LENGTH_SHORT).show();
        }*/

    }

}
