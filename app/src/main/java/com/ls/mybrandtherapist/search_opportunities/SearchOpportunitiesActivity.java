package com.ls.mybrandtherapist.search_opportunities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ls.mybrandtherapist.R;

public class SearchOpportunitiesActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_opportunities);
        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("SEARCH OPPORTUNITIES");
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
