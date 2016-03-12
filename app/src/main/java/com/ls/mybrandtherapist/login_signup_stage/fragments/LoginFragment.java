package com.ls.mybrandtherapist.login_signup_stage.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ls.mybrandtherapist.MainActivity;
import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.login_signup_stage.Log_Sign_ParentActivity;
import com.ls.mybrandtherapist.login_signup_stage.presenter.loginPresenter.loginPresenter;
import com.ls.mybrandtherapist.login_signup_stage.presenter.loginPresenter.loginPresenterImpl;
import com.ls.mybrandtherapist.login_signup_stage.presenter.loginPresenter.loginView;


public class LoginFragment extends Fragment implements loginView,View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private loginPresenter loginPresenter;
    private TextView txtLogin;
    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_login, container, false);

        loginPresenter = new loginPresenterImpl(this);

        init(rootView);

        return rootView;
    }

    private void init(View rootView) {
        txtLogin = (TextView)rootView.findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(this);
    }


    @Override
    public void doLogin() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtLogin:
                loginPresenter.Login();
                break;
        }
    }
}
