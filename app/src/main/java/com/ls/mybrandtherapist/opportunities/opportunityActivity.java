package com.ls.mybrandtherapist.opportunities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SegmentTabLayout;
import com.ls.mybrandtherapist.BlankFragment;
import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.home.HomeFragment;

import java.util.ArrayList;


public class opportunityActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    SegmentTabLayout tabLayout;
    private String[] mTitles = {"INTERNSHIP", "VOLUNTEER"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portunity);
        initToolbar();
        init();

    }

    private void init() {

        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(new BlankFragment());
        }

        tabLayout = (SegmentTabLayout) findViewById(R.id.tablayout_opportunities);
        tabLayout.setTabData(mTitles, this, R.id.frameOpportunities, mFragments);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("OPPORTUNITIES");
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_action_navigation_arrow_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
