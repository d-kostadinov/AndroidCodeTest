package com.rockspin.androiddevtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EVActivityAdapter extends RecyclerView.Adapter<EVActivityAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<CosmonautData> mCosmonautDataList;

    public EVActivityAdapter(Context context) {
        this(context, new ArrayList<CosmonautData>());
    }

    public EVActivityAdapter(Context context, List<CosmonautData> ideaList) {
        mInflater = LayoutInflater.from(context);
        mCosmonautDataList = ideaList;
    }

    public void setCosmonautActivityList(List<CosmonautData> cosmonautDataList) {
        mCosmonautDataList = cosmonautDataList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View rootView = mInflater.inflate(R.layout.list_item_ev, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CosmonautData cosmonautData = mCosmonautDataList.get(position);

        holder.tvName.setText(cosmonautData.getPurpose());
        holder.tvDate.setText(cosmonautData.getDate());
    }

    @Override
    public int getItemCount() {
        return mCosmonautDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_patent_name);
            tvDate = (TextView)itemView.findViewById(R.id.tv_date);
        }
    }
}
