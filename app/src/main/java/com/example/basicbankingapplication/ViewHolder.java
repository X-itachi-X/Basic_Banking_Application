package com.example.basicbankingapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mName, mPhonenumber, mBalance, mRupee, mRupeeslash, mName1, mName2, mDate, mTransc_status;
    ImageView mArrow;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        mName = itemView.findViewById(R.id.CustName);
        mPhonenumber = itemView.findViewById(R.id.AccNum);
        mBalance = itemView.findViewById(R.id.AccBal);
        mRupee = itemView.findViewById(R.id.rupee);
        mRupeeslash = itemView.findViewById(R.id.rupeeslash);

        mName1 = itemView.findViewById(R.id.name1);
        mName2 = itemView.findViewById(R.id.name2);
        mDate = itemView.findViewById(R.id.date);

        mTransc_status = itemView.findViewById(R.id.transaction_status);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

    }
    private ClickListener mClickListener;



    public interface  ClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ClickListener clickListener){
       mClickListener = clickListener;
    }
}
