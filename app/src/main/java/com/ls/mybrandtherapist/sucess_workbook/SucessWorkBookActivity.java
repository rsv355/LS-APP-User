package com.ls.mybrandtherapist.sucess_workbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ls.mybrandtherapist.BlankFragment;
import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.sucess_workbook.widget.AddGoalDialog;

import java.util.ArrayList;


public class SucessWorkBookActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    SegmentTabLayout tabLayout;
    private String[] mTitles = {"ADD GOAL", "UPDATE GOAL", "ACHIEVEMENTS"};

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
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0)
                    //Toast.makeText(SucessWorkBookActivity.this, "Select", Toast.LENGTH_SHORT).show();
                    openDialogForAddGoal();
            }


            @Override
            public void onTabReselect(int position) {
                openDialogForAddGoal();
            }
        });

    }

    private void openDialogForAddGoal() {

        AddGoalDialog dialog = new AddGoalDialog(SucessWorkBookActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setCancelable(true);
        dialog.show();



    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("SUCCESS WORKBOOK");
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
