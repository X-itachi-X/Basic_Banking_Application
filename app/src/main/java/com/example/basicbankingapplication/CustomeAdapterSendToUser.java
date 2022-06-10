package com.example.basicbankingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapterSendToUser extends RecyclerView.Adapter<com.example.basicbankingapplication.ViewHolder> {

    SendToUser SendtoUser;
    List<com.example.basicbankingapplication.Model> modelList;
    Context context;

    public CustomeAdapterSendToUser(SendToUser sentoUser, List<com.example.basicbankingapplication.Model> modelList) {
        this.SendtoUser = sentoUser;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public com.example.basicbankingapplication.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userslist, parent, false);

        com.example.basicbankingapplication.ViewHolder viewHolder = new com.example.basicbankingapplication.ViewHolder(itemView);
        viewHolder.setOnClickListener(new com.example.basicbankingapplication.ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SendtoUser.selectuser(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.basicbankingapplication.ViewHolder holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhoneno());
        holder.mBalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setFilter(ArrayList<com.example.basicbankingapplication.Model> newList){
        modelList = new ArrayList<>();
        modelList.addAll(newList);
        notifyDataSetChanged();
    }
}
