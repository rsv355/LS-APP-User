package com.ls.mybrandtherapist.home.presenter;

import android.widget.Toast;

/**
 * Created by dhruvil on 15-03-2016.
 */
public class HomePresenterImpl implements HomePresenter{

    private HomeView homeView;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void onCircleItemClick(int pos) {


        switch (pos){
            case 0:
                homeView.gotoBloodBank();
                break;

            case 1:
                homeView.gotoResult();
                break;

            case 2:
                homeView.gotoSettings();
                break;

            case 3:
                homeView.gotoClubs();
                break;

            case 4:
                homeView.gotoShareApp();
                break;

            case 5:
                homeView.gotoAboutUs();
                break;


        }


    }
}
