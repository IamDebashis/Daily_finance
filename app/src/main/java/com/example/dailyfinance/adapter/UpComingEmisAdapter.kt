package com.example.dailyfinance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R

class UpComingEmisAdapter : RecyclerView.Adapter<UpComingEmisViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingEmisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_emei_card_view,parent, false)

        return  UpComingEmisViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpComingEmisViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 3
    }


}

class UpComingEmisViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}



