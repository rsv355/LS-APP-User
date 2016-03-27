package com.ls.mybrandtherapist.submit_resume.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.submit_resume.model.PassionIndustry;

/**
 * Created by dhruvil on 08-10-2015.
 */
public class SportCheckBox extends LinearLayout {

    public ImageView icon;
    View parentView;
    GestureDetector gestureDetector;
    private Context context;
    private LayoutInflater inflater;
    private OnTapListner onTapListner;
    private boolean isChecked;
    private LinearLayout checkBoxParent;
    private boolean isPrimary;
    private TextView text;
    private PassionIndustry ownedSport;


    public SportCheckBox(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SportCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SportCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void setOnTapListner(OnTapListner onTapListner) {
        this.onTapListner = onTapListner;
    }

    private void init() {

        isChecked = false;
        isPrimary = false;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parentView = inflater.inflate(R.layout.item_sportcheckbox, this);
        checkBoxParent = (LinearLayout) parentView.findViewById(R.id.parentSportCheckBox);
        //  gestureDetector = new GestureDetector(context, new GestureListener());
        setChecked(isChecked);

        icon = (ImageView) parentView.findViewById(R.id.icon);
        text = (TextView) parentView.findViewById(R.id.text);

        reDrawParent();



    }

    private void reDrawParent() {

        int width = context.getResources().getDisplayMetrics().widthPixels;
        int factor = (width/3);
        checkBoxParent.getLayoutParams().width = width/3;
        checkBoxParent.getLayoutParams().height = width/3;
        checkBoxParent.requestLayout();

    }

    public void setColor(int color) {
        checkBoxParent.setBackgroundColor(color);
    }


    public PassionIndustry getSport() {
        return ownedSport;
    }

    public void setSport(PassionIndustry sport) {
        ownedSport = sport;
        //todo set name
         text.setText(ownedSport.getName());
    }

    public String geCheckedText() {
        return text.getText().toString();
    }

//    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
//
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return true;
//        }
//
//        @Override
//        public boolean onSingleTapConfirmed(MotionEvent e) {
//            if (onTapListner != null)
//                onTapListner.onSingleTap(SportCheckBox.this);
//
//        /*    if(isChecked == true){
//
//                setChecked(false);
//
//            }else{
//                setChecked(true);
//            }*/
//
//            return super.onSingleTapConfirmed(e);
//
//        }
//
//        // event when double tap occurs
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//            onTapListner.onDoubleTap(SportCheckBox.this);
//            return true;
//        }
//
//        @Override
//        public void onLongPress(MotionEvent e) {
//
//            super.onLongPress(e);
//        }
//    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean value) {
        isChecked = value;
        processDisplay(isChecked);

    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean value) {

        isPrimary = value;
        isChecked = false;
       // processPrimaryDisplay(isPrimary);

    }


    private void processDisplay(boolean isChecked) {

        if (isChecked == true) {
            isPrimary = false;
            setColor(getResources().getColor(R.color.green_ls_transperent));
        } else {
            setColor(getResources().getColor(R.color.dark_transperent));
        }

    }

    public void hideIcon() {
        icon.setVisibility(View.GONE);
    }

    public void setCheckBoxText(String str) {
        text.setText(str);
    }

    public void setDimen(int width, int height) {
        LayoutParams layoutParams = new LayoutParams(width, height);
        checkBoxParent.setLayoutParams(layoutParams);
    }

    public interface OnTapListner {
        void onSingleTap(View v);

        void onDoubleTap(View v);

    }

}
