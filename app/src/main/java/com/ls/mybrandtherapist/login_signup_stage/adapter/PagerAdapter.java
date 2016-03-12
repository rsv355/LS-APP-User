package com.ls.mybrandtherapist.login_signup_stage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ls.mybrandtherapist.login_signup_stage.fragments.CreateAccountFragment;
import com.ls.mybrandtherapist.login_signup_stage.fragments.LoginFragment;

/**
 * Created by Krish on 12/3/2016.
 */

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:  return CreateAccountFragment.newInstance("", "");

            case 1: return LoginFragment.newInstance("","");

            case 2: return LoginFragment.newInstance("","");

            default: return LoginFragment.newInstance("","");

        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}