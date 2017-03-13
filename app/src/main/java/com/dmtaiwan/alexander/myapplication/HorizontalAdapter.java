package com.dmtaiwan.alexander.myapplication;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexander on 3/13/2017.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> strings;
    private LayoutInflater layoutInflater;

    public HorizontalAdapter(Activity hostActivity, List<String> strings) {
        this.layoutInflater = hostActivity.getLayoutInflater();
        this.strings = strings;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HorizontalHolder) holder).horizontalText.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }


    private RecyclerView.ViewHolder createHolder(ViewGroup parent) {
        final HorizontalHolder holder = new HorizontalHolder(layoutInflater.inflate(R.layout.list_item_horizontal, parent, false));
        return holder;
    }

    public class HorizontalHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.horizontal_recycler_text)
        TextView horizontalText;

        HorizontalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
