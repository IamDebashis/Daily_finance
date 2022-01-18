package com.example.dailyfinance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R

class UpcomingBorrowAdapter : RecyclerView.Adapter<UpcomingBorrowViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingBorrowViewHolder {
      val view =   LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_borrow_card,parent,false)

        return UpcomingBorrowViewHolder(view)

    }



    override fun onBindViewHolder(holder: UpcomingBorrowViewHolder, position: Int) {

    }


    override fun getItemCount(): Int {
        return 5
    }




}





class UpcomingBorrowViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}
