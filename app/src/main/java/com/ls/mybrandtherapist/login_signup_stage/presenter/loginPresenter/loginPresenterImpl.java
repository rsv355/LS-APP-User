package com.ls.mybrandtherapist.login_signup_stage.presenter.loginPresenter;

/**
 * Created by Krish on 12/3/2016.
 */
public class loginPresenterImpl implements loginPresenter {
    private loginView loginView;

    public loginPresenterImpl(loginView view) {
        this.loginView = view;
    }

    @Override
    public void Login() {
        loginView.doLogin();
    }
}
