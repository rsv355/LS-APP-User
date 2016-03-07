package com.ls.mybrandtherapist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ls.mybrandtherapist.widget.CircleMenuLayout;

public class MainActivity extends AppCompatActivity {
    private String[] mItemTexts = new String[] { "Blood Bank", "Result", "Settings",
            "Clubs", "Share App", "About Us" };
    private int[] mItemImgs = new int[] { R.drawable.ic_blood,
            R.drawable.icon_result, R.drawable.icon_setting,
            R.drawable.icon_reports, R.drawable.icon_share,
            R.drawable.icon_aboutus };
    CircleMenuLayout mCircleMenuLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
    }
}
