package com.example.dailyfinance.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R

class LastTransactionAdapter : RecyclerView.Adapter<LastTransactionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastTransactionViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_last_transaction_card,parent,false)

        return LastTransactionViewHolder(view)

    }


    override fun onBindViewHolder(holder: LastTransactionViewHolder, position: Int) {
    }


    override fun getItemCount(): Int {
        return 4
    }


}





class LastTransactionViewHolder(v: View): RecyclerView.ViewHolder(v) {

}
