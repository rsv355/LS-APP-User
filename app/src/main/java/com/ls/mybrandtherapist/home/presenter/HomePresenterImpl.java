package com.ls.mybrandtherapist.home.presenter;

import android.widget.Toast;

/**
 * Created by dhruvil on 15-03-2016.
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void onCircleItemClick(int pos) {


        switch (pos) {
            case 0:
                homeView.gotoMyStory();
                break;

            case 1:
                homeView.gotoVirtualMentorSesson();
                break;

            case 2:
                homeView.gotoBookBrandTherapySesson();
                break;

            case 3:
                homeView.gotoSuccessToolkit();
                break;

            case 4:
                homeView.gotoMyWorkBook();
                break;

            case 5:
                homeView.gotoHostWorkshop();
                break;

            case 6:
                homeView.gotoSubmitResume();

                break;

            case 7:

                homeView.gotoSearchOpportunities();

                break;


        }


    }
}
