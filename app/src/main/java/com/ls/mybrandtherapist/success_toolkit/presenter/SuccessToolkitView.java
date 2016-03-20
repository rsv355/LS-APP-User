package com.ls.mybrandtherapist.success_toolkit.presenter;

import com.ls.mybrandtherapist.success_toolkit.model.TipModel;

import java.util.ArrayList;

/**
 * Created by xitij on 3/20/2016.
 */
public interface SuccessToolkitView {

    void onError();

    void onTipsRecieved(ArrayList<TipModel> tips);



}
