package com.example.dailyfinance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R
import com.example.dailyfinance.viewholder.TransactionItemViewHolder

class TransactionAdapter(val listener: View.OnClickListener): RecyclerView.Adapter<TransactionItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionItemViewHolder {


        return TransactionItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_transaction,parent,false))

    }

    override fun onBindViewHolder(holder: TransactionItemViewHolder, position: Int) {

            holder.itemView.setOnClickListener(listener)

    }

    override fun getItemCount(): Int {
       return 10
    }


}