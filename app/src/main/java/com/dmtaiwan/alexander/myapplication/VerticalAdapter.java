package com.dmtaiwan.alexander.myapplication;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
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

public class VerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ODD = 0;
    private static final int VIEW_TYPE_EVEN = 1;

    private List<String> strings;
    private LayoutInflater layoutInflater;
    private Activity hostActivity;

    public VerticalAdapter(Activity hostActivity, List<String> strings) {
        this.hostActivity = hostActivity;
        layoutInflater = hostActivity.getLayoutInflater();
        this.strings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ODD) {
            return createOddHolder(parent);
        } else return createEvenHolder(parent);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ODD) {
            bindOddView((OddHolder)holder, position);
        } else bindEvenView((EvenHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return VIEW_TYPE_EVEN;
        } else return VIEW_TYPE_ODD;
    }

    private RecyclerView.ViewHolder createOddHolder(ViewGroup parent) {
        final OddHolder holder = new OddHolder(layoutInflater.inflate(R.layout.list_item_recycler_odd, parent, false));
        return holder;
    }

    private RecyclerView.ViewHolder createEvenHolder(ViewGroup parent) {
        final EvenHolder holder = new EvenHolder(layoutInflater.inflate(R.layout.list_item_recycler_even, parent, false));
        return holder;
    }

    private void bindOddView(OddHolder oddHolder, int position) {
        oddHolder.recyclerText.setText(strings.get(position));
    }

    private void bindEvenView(EvenHolder evenHolder, int position) {
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(hostActivity, strings);
        LinearLayoutManager llm = new LinearLayoutManager(hostActivity);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        evenHolder.recyclerView.setAdapter(horizontalAdapter);
        evenHolder.recyclerView.setLayoutManager(llm);
    }

    public class OddHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.vertical_recycler_text)
        TextView recyclerText;

        OddHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public class EvenHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.recycler_horizontal)
        RecyclerView recyclerView;

        EvenHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
