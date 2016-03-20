package com.ls.mybrandtherapist.success_toolkit.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.mybrandtherapist.R;
import com.ls.mybrandtherapist.success_toolkit.model.TipModel;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    Context context;
    SimpleDateFormat format;
    ArrayList<TipModel> tips;
    boolean IsLike = false;
    View parentView;

    public TipsAdapter(Context context, ArrayList<TipModel> newsLists) {
        this.context = context;
        this.tips = newsLists;
    }

    public TipsAdapter(Context context) {
        this.context = context;
    }

    public void setTips(ArrayList<TipModel> tips) {
        this.tips = new ArrayList<>();
        this.tips = tips;
        notifyDataSetChanged();
    }

    @Override
    public TipsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tip, parent, false);

        return new ViewHolder(parentView);
    }

    @Override
    public void onBindViewHolder(final TipsAdapter.ViewHolder holder, final int position) {

        final TipModel newsList = tips.get(position);

    }


    @Override
    public int getItemCount() {
        return tips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       // LinearLayout newsHolder;

        public ViewHolder(View itemView) {
            super(itemView);
          //  txtNewsFeeder = (TextView) itemView.findViewById(R.id.txtNewsFeeder);

        }
    }
}