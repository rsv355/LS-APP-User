package com.ls.mybrandtherapist.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.widget.CircleMenuLayout;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] mItemTexts = new String[] { "Blood Bank", "Result", "Settings",
            "Clubs", "Share App", "About Us" };
    private int[] mItemImgs = new int[] { R.drawable.ic_blood,
            R.drawable.icon_result, R.drawable.icon_setting,
            R.drawable.icon_reports, R.drawable.icon_share,
            R.drawable.icon_aboutus };
    CircleMenuLayout mCircleMenuLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        mCircleMenuLayout = (CircleMenuLayout)parent.findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        return parent;
    }


}
