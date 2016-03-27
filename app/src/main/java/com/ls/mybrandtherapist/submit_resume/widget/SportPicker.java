package com.ls.mybrandtherapist.submit_resume.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.submit_resume.model.PassionIndustry;

import java.util.ArrayList;

public class SportPicker extends LinearLayout {

    OnSportsChangeListener onSportsChangeListener;
    PassionIndustry currentSelected;
    private Context context;
    private LayoutInflater inflater;
    private GridLayout gridCheckBox;
    private OnClickListener singleClickListner = new OnClickListener() {
        @Override
        public void onClick(View view) {

            int pos = gridCheckBox.indexOfChild(view);
            for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
                SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
                if (pos == i) {
                    onSportsChangeListener.SportsChanged(sportCheckBox.getSport());
                    sportCheckBox.setChecked(true);

                } else {
                    sportCheckBox.setChecked(false);
                }
            }

        }
    };
    private SportCheckBox.OnTapListner tapListner = new SportCheckBox.OnTapListner() {
        @Override
        public void onSingleTap(View v) {


            int pos = gridCheckBox.indexOfChild(v);
            for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
                SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
                if (pos == i) {

                    sportCheckBox.setChecked(true);
                } else {
                    sportCheckBox.setChecked(false);
                }
            }

        }

        @Override
        public void onDoubleTap(View v) {

        }
    };


    public SportPicker(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SportPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SportPicker(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        this.context = context;
        init();

    }

    private void init() {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_sport_picker, this);
        gridCheckBox = (GridLayout) findViewById(R.id.gridCheckBox);

        //  setupGrid();

    }

//    public void setSelectedSports() {
//
//        currentSelected = PrefUtils.getCurrentSelectedSport(context);
//        if (currentSelected == null) {
//            DatabaseHandler databaseHandler = new DatabaseHandler(context);
//            currentSelected = databaseHandler.getUserPrimarySports();
//
//        }
//    }

    public void setAdapter(ArrayList<PassionIndustry> sports) {

        gridCheckBox.removeAllViews();

        for (PassionIndustry sport : sports) {
            SportCheckBox checkBox = new SportCheckBox(context);
            checkBox.setSport(sport);
            //Glide.with(context).load(sport.SportIcon).thumbnail(0.10f).into(checkBox.icon);
            gridCheckBox.addView(checkBox);
            gridCheckBox.invalidate();
        }

        setupGrid();

    }

    private void setupGrid() {

        for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
            //sportCheckBox.setOnTapListner(tapListner);
            sportCheckBox.setOnClickListener(singleClickListner);
        }


    }


    public void setColumns(int count) {
        gridCheckBox.setColumnCount(count);
        gridCheckBox.invalidate();
    }


    public PassionIndustry getSelectedSport() {

        PassionIndustry selectedSport = new PassionIndustry();

        for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
            if (sportCheckBox.isChecked()) {
                selectedSport = sportCheckBox.getSport();
            }
        }


        return selectedSport;

    }

    public void setOnSportsChangeListener(OnSportsChangeListener onSportsChangeListener) {
        if (onSportsChangeListener != null) {
            this.onSportsChangeListener = onSportsChangeListener;
        }
    }

    public interface OnSportsChangeListener {

        void SportsChanged(PassionIndustry sport);

    }
}
