package com.ls.mybrandtherapist.login_signup_stage.presenter.welcomePresenter;

/**
 * Created by Krish on 12/3/2016.
 */
public class WelcomePresenterImpl implements WelcomePresenter {
    private WelcomeView welcomeView;
    public WelcomePresenterImpl(WelcomeView View) {
        this.welcomeView = View;
    }

    @Override
    public void doChangePagerTab(int pos) {
        welcomeView.changeTab(pos);
    }
}
