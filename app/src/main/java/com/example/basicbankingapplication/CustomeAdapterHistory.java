package com.example.basicbankingapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomeAdapterHistory extends RecyclerView.Adapter<com.example.basicbankingapplication.ViewHolder> {

    com.example.basicbankingapplication.HistoryList HistoryList;
    List<com.example.basicbankingapplication.Model> modelList;
    Context context;

    TextView mTransc_status;

    public CustomeAdapterHistory(com.example.basicbankingapplication.HistoryList historyList, List<com.example.basicbankingapplication.Model> modelList) {
        this.HistoryList = historyList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public com.example.basicbankingapplication.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_history_list, parent, false);

        mTransc_status = itemView.findViewById(R.id.transaction_status);

        com.example.basicbankingapplication.ViewHolder viewHolder = new com.example.basicbankingapplication.ViewHolder(itemView);
        viewHolder.setOnClickListener(new com.example.basicbankingapplication.ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.basicbankingapplication.ViewHolder holder, int position) {
        holder.mName1.setText(modelList.get(position).getName1());
        holder.mName2.setText(modelList.get(position).getName2());
        holder.mBalance.setText(modelList.get(position).getBalance());
        holder.mDate.setText(modelList.get(position).getDate());
        holder.mTransc_status.setText(modelList.get(position).getTransaction_status());

        if(modelList.get(position).getTransaction_status().equals("Failed")){
            holder.mTransc_status.setTextColor(Color.parseColor("#f40404"));
        }else{
            holder.mTransc_status.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
