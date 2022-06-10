package com.example.basicbankingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomeAdapterUserlist extends RecyclerView.Adapter<com.example.basicbankingapplication.ViewHolder> {

    Userlist UserList;
    List<Model> modelList;
    Context context;

    public CustomeAdapterUserlist(Userlist userList, List<Model> modelList) {
        this.UserList = userList;
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
                UserList.nextActivity(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.basicbankingapplication.ViewHolder holder, int position) {
        holder.mName.setText("Customer Name: " + modelList.get(position).getName());
        holder.mPhonenumber.setText("Account Number: " + modelList.get(position).getPhoneno());
        holder.mBalance.setText("Balance: " + modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
