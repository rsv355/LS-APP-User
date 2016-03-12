package com.ls.mybrandtherapist.login_signup_stage.presenter.loginPresenter;

/**
 * Created by Krish on 12/3/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView LoginView;

    public LoginPresenterImpl(LoginView view) {
        this.LoginView = view;
    }

    @Override
    public void Login() {
        LoginView.doLogin();
    }
}
