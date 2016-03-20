package com.ls.mybrandtherapist.success_toolkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.success_toolkit.adapter.TipsAdapter;
import com.ls.mybrandtherapist.success_toolkit.model.TipModel;
import com.ls.mybrandtherapist.success_toolkit.presenter.SuccessToolkitView;
import com.ls.mybrandtherapist.success_toolkit.presenter.ToolkitPresenter;
import com.ls.mybrandtherapist.success_toolkit.presenter.ToolkitPresenterImpl;

import java.util.ArrayList;

import cn.iwgang.familiarrecyclerview.FamiliarRecyclerView;

public class SuccessToolkitActivity extends AppCompatActivity implements SuccessToolkitView {

    private Toolbar toolbar;
    private ToolkitPresenter toolkitPresenter;
    private FamiliarRecyclerView recyclerTips;
    private TipsAdapter tipsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_toolkit);

        initToolbar();
        init();
        toolkitPresenter = new ToolkitPresenterImpl(this);
        toolkitPresenter.fetchTips();

    }

    private void init() {
        recyclerTips = (FamiliarRecyclerView) findViewById(R.id.recyclerTips);
        recyclerTips.addHeaderView(getHeaderView());

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            title.setText("SUCCESS TOOLKIT");
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

    public View getHeaderView() {
        View layoutHeader = getLayoutInflater().inflate(R.layout.item_header_tips, null);
        layoutHeader.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return layoutHeader;
    }

    @Override
    public void onError() {

    }

    @Override
    public void onTipsRecieved(ArrayList<TipModel> tips) {

        tipsAdapter = new TipsAdapter(SuccessToolkitActivity.this, tips);
        recyclerTips.setAdapter(tipsAdapter);


    }

}