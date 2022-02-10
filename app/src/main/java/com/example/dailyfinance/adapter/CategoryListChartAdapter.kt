package com.example.dailyfinance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R
import com.example.dailyfinance.databinding.ItemCategoryListBinding
import com.example.dailyfinance.models.AdapterItemClickListener
import kotlinx.coroutines.withContext

class CategoryListChartAdapter : RecyclerView.Adapter<CategoryListViewHolder>() {

    private lateinit var categoryBinding: ItemCategoryListBinding
    private lateinit var clickListener: AdapterItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        categoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_category_list, parent, false)

        return CategoryListViewHolder(categoryBinding.root)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {

        holder.itemView.setOnClickListener{
            clickListener.onClick()
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

    fun setItemClickListner(listener: AdapterItemClickListener) {
        clickListener = listener
    }

}

class CategoryListViewHolder(v: View) : RecyclerView.ViewHolder(v) {


}
