package com.ls.mybrandtherapist.sucess_workbook.widget;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ls.mybrandtherapist.R;

/**
 * Created by xitij on 3/27/2016.
 */
public class AddGoalDialog extends AppCompatDialog {
    public AddGoalDialog(Context context) {
        super(context);
        init();
    }

    public AddGoalDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
        setContentView(R.layout.item_add_goal);
        setupoutsidetouch();
    }

    private void setupoutsidetouch() {
        ((RelativeLayout)this.findViewById(R.id.parentAddGoalDialog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
