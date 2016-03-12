package com.ls.mybrandtherapist.login_signup_stage.presenter;

/**
 * Created by Krish on 12/3/2016.
 */
public class WelcomePresenterImpl implements WelcomePresenter{
    WelcomeView welcomeView;
    public WelcomePresenterImpl(WelcomeView View) {
        this.welcomeView = View;
    }

    @Override
    public void doChangePagerTab(int pos) {
        welcomeView.changeTab(pos);
    }
}
