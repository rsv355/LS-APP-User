package com.ls.mybrandtherapist.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.home.presenter.HomePresenter;
import com.ls.mybrandtherapist.home.presenter.HomePresenterImpl;
import com.ls.mybrandtherapist.home.presenter.HomeView;
import com.ls.mybrandtherapist.widget.CircleMenuLayout;

public class HomeFragment extends Fragment implements HomeView{

    private String[] mItemTexts = new String[]{"Blood Bank", "Result", "Settings",
            "Clubs", "Share App", "About Us"};
    private int[] mItemImgs = new int[]{R.drawable.ic_blood,
            R.drawable.icon_result, R.drawable.icon_setting,
            R.drawable.icon_reports, R.drawable.icon_share,
            R.drawable.icon_aboutus};
    CircleMenuLayout mCircleMenuLayout;
    private HomePresenter homePresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        mCircleMenuLayout = (CircleMenuLayout) parent.findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        homePresenter = new HomePresenterImpl(this);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                homePresenter.onCircleItemClick(pos);
            }

            @Override
            public void itemCenterClick(View view) {
            }
        });

        return parent;
    }


    @Override
    public void gotoAboutUs() {



    }

    @Override
    public void gotoSettings() {

    }

    @Override
    public void gotoBloodBank() {

    }

    @Override
    public void gotoResult() {

    }

    @Override
    public void gotoClubs() {

    }

    @Override
    public void gotoShareApp() {

    }

}
