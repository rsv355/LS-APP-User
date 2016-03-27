package com.ls.mybrandtherapist.book1on1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.ls.mybrandtherapist.R;

import java.util.ArrayList;

public class Book1on1 extends AppCompatActivity{

    private Toolbar toolbar;
    private Spinner spSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_1on1);
        initToolbar();
        init();
    }

    private void init() {
        spSession = (Spinner)findViewById(R.id.spSession);

        ArrayList<String> sessionData =  new ArrayList<>();
        String[] arr = getResources().getStringArray(R.array.session_type);
        for(int i=0;i<arr.length;i++)
            sessionData.add(arr[i]);

        mySpinnerAdapter boardAdapter1 = new mySpinnerAdapter(Book1on1.this, sessionData, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spSession.setAdapter(boardAdapter1);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("BOOK 1ON1");
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
