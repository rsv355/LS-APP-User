package com.ls.mybrandtherapist.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.home.presenter.HomePresenter;
import com.ls.mybrandtherapist.home.presenter.HomePresenterImpl;
import com.ls.mybrandtherapist.home.presenter.HomeView;
import com.ls.mybrandtherapist.opportunities.opportunityActivity;
import com.ls.mybrandtherapist.search_opportunities.SearchOpportunitiesActivity;
import com.ls.mybrandtherapist.submit_resume.SubmitResumeActivity;
import com.ls.mybrandtherapist.success_toolkit.SuccessToolkitActivity;
import com.ls.mybrandtherapist.sucess_workbook.SucessWorkBookActivity;
import com.ls.mybrandtherapist.widget.CircleMenuLayout;

public class HomeFragment extends Fragment implements HomeView {

    private String[] mItemTexts = new String[]{"WorkBook", "Mentor", "Therapy",
            "Toolkit", "My Story", "Workshop", "Resume", "Opportunity"};
    private int[] mItemImgs = new int[]{R.drawable.workbook, R.drawable.chat, R.drawable.thearpy,
            R.drawable.toolkit, R.drawable.mystory,
            R.drawable.workshop, R.drawable.resume, R.drawable.search};
    CircleMenuLayout mCircleMenuLayout;
    private HomePresenter homePresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        mCircleMenuLayout = (CircleMenuLayout) parent.findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        homePresenter = new HomePresenterImpl(this);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                homePresenter.onCircleItemClick(pos);
            }

            @Override
            public void itemCenterClick(View view) {
            }
        });

        return parent;
    }


    @Override
    public void gotoMyStory() {

    }

    @Override
    public void gotoVirtualMentorSesson() {

    }

    @Override
    public void gotoBookBrandTherapySesson() {

        Intent iSuccessToolkit = new Intent(getActivity(), SearchOpportunitiesActivity.class);
        startActivity(iSuccessToolkit);

    }

    @Override
    public void gotoSuccessToolkit() {
        Intent iSuccessToolkit = new Intent(getActivity(), SuccessToolkitActivity.class);
        startActivity(iSuccessToolkit);

    }

    @Override
    public void gotoMyWorkBook() {
        Intent iSuccessToolkit = new Intent(getActivity(), SucessWorkBookActivity.class);
        startActivity(iSuccessToolkit);
    }

    @Override
    public void gotoHostWorkshop() {

        Intent iSuccessToolkit = new Intent(getActivity(), SearchOpportunitiesActivity.class);
        startActivity(iSuccessToolkit);

    }


    @Override
    public void gotoSubmitResume() {

       // Toast.makeText(getActivity(), "Submit Resume", Toast.LENGTH_SHORT).show();

        Intent iSuccessToolkit = new Intent(getActivity(), SubmitResumeActivity.class);
        startActivity(iSuccessToolkit);

    }

    @Override
    public void gotoSearchOpportunities() {

        Intent iSuccessToolkit = new Intent(getActivity(), opportunityActivity.class);
        startActivity(iSuccessToolkit);


    }
}
