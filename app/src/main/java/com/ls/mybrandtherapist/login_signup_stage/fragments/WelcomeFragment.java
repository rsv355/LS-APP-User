package com.ls.mybrandtherapist.login_signup_stage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.login_signup_stage.presenter.WelcomePresenter;
import com.ls.mybrandtherapist.login_signup_stage.presenter.WelcomePresenterImpl;
import com.ls.mybrandtherapist.login_signup_stage.presenter.WelcomeView;

import org.w3c.dom.Text;


public class WelcomeFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView txtLogin,txtCreateAccount;

    private WelcomePresenter welcomePresenter;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_welcometab, container, false);
        
        welcomePresenter = new WelcomePresenterImpl((WelcomeView)getActivity());
        init(rootView);
        
        return rootView;
    }

    private void init(View rootView) {
        txtLogin = (TextView)rootView.findViewById(R.id.txtLogin);
        txtCreateAccount = (TextView)rootView.findViewById(R.id.txtCreateAccount);

        txtLogin.setOnClickListener(this);
        txtCreateAccount.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtLogin:
                welcomePresenter.doChangePagerTab(1);
                break;
            case R.id.txtCreateAccount:
                welcomePresenter.doChangePagerTab(2);
                break;
        }
    }

  /*  @Override
    public void changeTab(int pos) {
        Toast.makeText(getActivity(),""+pos,Toast.LENGTH_SHORT).show();
    }*/
}
