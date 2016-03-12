package com.ls.mybrandtherapist.login_signup_stage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.login_signup_stage.adapter.PagerAdapter;
import com.ls.mybrandtherapist.login_signup_stage.widget.CircleIndicator;

public class Log_Sign_ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign_parent);

        init();
    }

    private void init() {

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
    }
}
