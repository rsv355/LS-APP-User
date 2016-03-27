package com.ls.mybrandtherapist.submit_resume.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.submit_resume.model.PassionIndustry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SportSelector extends LinearLayout {

    private Context context;
    private LayoutInflater inflater;
    private GridLayout gridCheckBox;
    private Set<PassionIndustry> selectedSport;
    private OnClickListener singleClickListner = new OnClickListener() {
        @Override
        public void onClick(View view) {

            int pos = gridCheckBox.indexOfChild(view);
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(pos);
            if (sportCheckBox.isChecked()) {
                selectedSport.remove(sportCheckBox.getSport());
                sportCheckBox.setChecked(false);
            } else {
                sportCheckBox.setChecked(true);
                selectedSport.add(sportCheckBox.getSport());
            }

        }
    };
    private OnLongClickListener longClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {

            int pos = gridCheckBox.indexOfChild(view);
            for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
                SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
                if (pos == i) {
                    sportCheckBox.setPrimary(true);
                } else {
                    if (sportCheckBox.isChecked() == false) {
                        sportCheckBox.setPrimary(false);
                    }

                    if (sportCheckBox.isChecked() == true) {
                        sportCheckBox.setChecked(true);
                    }

                }
            }


            return true;
        }
    };
    private SportCheckBox.OnTapListner tapListner = new SportCheckBox.OnTapListner() {
        @Override
        public void onSingleTap(View v) {

            int pos = gridCheckBox.indexOfChild(v);
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(pos);
            if (sportCheckBox.isChecked()) {
                sportCheckBox.setChecked(false);
            } else {
                sportCheckBox.setChecked(true);
            }

        }

        @Override
        public void onDoubleTap(View v) {

            int pos = gridCheckBox.indexOfChild(v);
            for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
                SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
                if (pos == i) {
                    sportCheckBox.setPrimary(true);
                } else {
                    if (sportCheckBox.isChecked() == false) {
                        sportCheckBox.setPrimary(false);
                    }

                    if (sportCheckBox.isChecked() == true) {
                        sportCheckBox.setChecked(true);
                    }

                }
            }
        }
    };

    public SportSelector(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SportSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SportSelector(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        this.context = context;
        init();

    }

    private void init() {
        selectedSport = new HashSet<>();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_sport_picker, this);
        gridCheckBox = (GridLayout) findViewById(R.id.gridCheckBox);

        // setupGrid();

    }


    public void setAdapter(ArrayList<PassionIndustry> sports, boolean isDisabled) {


        gridCheckBox.removeAllViews();

        for (PassionIndustry sport : sports) {
            SportCheckBox checkBox = new SportCheckBox(context);
            checkBox.setSport(sport);

            // Glide.with(context).load(sport.SportIcon).thumbnail(0.10f).into(checkBox.icon);
            checkBox.icon.setColorFilter(Color.parseColor("#BDBDBD"));
            gridCheckBox.addView(checkBox);
            gridCheckBox.invalidate();

        }

        setupGrid();

    }

    private void setupGrid() {

        for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
            sportCheckBox.setOnClickListener(singleClickListner);
            sportCheckBox.setOnLongClickListener(longClickListener);
        }

    }

    public ArrayList<PassionIndustry> getSelectedSports() {

        ArrayList<PassionIndustry> selectedSport = new ArrayList<>();

        for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
            if (sportCheckBox.isChecked()) {
                selectedSport.add(sportCheckBox.getSport());
            }
        }


        return selectedSport;

    }

    public ArrayList<PassionIndustry> getPrimarySport() {

        ArrayList<PassionIndustry> primarySport = new ArrayList<>();

        for (int i = 0; i < gridCheckBox.getChildCount(); i++) {
            SportCheckBox sportCheckBox = (SportCheckBox) gridCheckBox.getChildAt(i);
            if (sportCheckBox.isPrimary()) {
                primarySport.add(sportCheckBox.getSport());
            }
        }

        return primarySport;

    }

    public void setColumns(int count) {
        gridCheckBox.setColumnCount(count);
        gridCheckBox.invalidate();
    }


    public Set<PassionIndustry> getSelectedSport() {

        return selectedSport;
    }

}
