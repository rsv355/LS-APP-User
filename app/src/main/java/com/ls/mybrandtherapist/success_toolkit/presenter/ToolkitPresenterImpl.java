package com.ls.mybrandtherapist.success_toolkit.presenter;

import com.ls.mybrandtherapist.success_toolkit.model.TipModel;

import java.util.ArrayList;

/**
 * Created by xitij on 3/20/2016.
 */
public class ToolkitPresenterImpl implements ToolkitPresenter {

    private SuccessToolkitView successToolkitView;

    public ToolkitPresenterImpl(SuccessToolkitView successToolkitView) {
        this.successToolkitView = successToolkitView;
    }


    @Override
    public void fetchTips() {

        ArrayList<TipModel> tips = new ArrayList<>();
        for(int i=0;i<10;i++){
            tips.add(new TipModel());
        }
        successToolkitView.onTipsRecieved(tips);


    }
}
