package com.example.yochen.justfortest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yochen on 2017/6/15.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<Transaction> transaction;
    Context context;

    public MyAdapter(List<Transaction> transaction, Context context) {
        this.transaction = transaction;
        this.context = context;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;

        public ViewHolder(View itemView) {

            super(itemView);
            textViewHead=(TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc=(TextView) itemView.findViewById(R.id.textViewDesc);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Transaction a=transaction.get(position);
        holder.textViewHead.setText(a.getAccount());
        holder.textViewDesc.setText(a.getDate());
    }

    @Override
    public int getItemCount() {
        return transaction.size();
    }
}
