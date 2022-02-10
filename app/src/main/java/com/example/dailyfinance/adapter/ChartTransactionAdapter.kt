package com.example.dailyfinance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R
import com.example.dailyfinance.databinding.ItemChartTransactionBinding

class ChartTransactionAdapter : RecyclerView.Adapter<ItemChartTransactionViewHolder>() {

    private lateinit var layout: ItemChartTransactionBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemChartTransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        layout = DataBindingUtil.inflate(inflater, R.layout.item_chart_transaction,parent,false)
        return  ItemChartTransactionViewHolder(layout.root)
    }

    override fun onBindViewHolder(holder: ItemChartTransactionViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }


}


class ItemChartTransactionViewHolder(val layout: View) : RecyclerView.ViewHolder(layout) {


}