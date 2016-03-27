package com.ls.mybrandtherapist.submit_resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.submit_resume.model.PassionIndustry;
import com.ls.mybrandtherapist.submit_resume.widget.SportPicker;

import java.util.ArrayList;

public class SubmitResumeActivity extends AppCompatActivity implements SubmitResumeView {

    private Toolbar toolbar;
    private SportPicker passionSelecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_resume);
        init();
        initToolbar();

    }

    private void init() {
        passionSelecter = (SportPicker) findViewById(R.id.passionSelecter);

        ArrayList<PassionIndustry> passionIndustries = new ArrayList<>();
        passionIndustries.add(new PassionIndustry());
        passionIndustries.add(new PassionIndustry());
        passionIndustries.add(new PassionIndustry());
        passionIndustries.add(new PassionIndustry());
        passionSelecter.setAdapter(passionIndustries);
        passionSelecter.setOnSportsChangeListener(new SportPicker.OnSportsChangeListener() {
            @Override
            public void SportsChanged(PassionIndustry sport) {

            }
        });

    }

    @Override
    public void setPassionIndustry(ArrayList<PassionIndustry> passionIndustries) {

    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("SUBMIT RESUME");
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
