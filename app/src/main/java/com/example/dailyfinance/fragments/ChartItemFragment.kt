package com.example.dailyfinance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfinance.adapter.ChartTransactionAdapter
import com.example.dailyfinance.databinding.ItemFragmentChartBinding


class ChartItemFragment : Fragment() {

    private var _layoutBinding : ItemFragmentChartBinding ? = null
    private val layoutBinding get() = _layoutBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _layoutBinding = ItemFragmentChartBinding.inflate(inflater,container,false)
        return layoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

    }

    fun  setupRecyclerView(){
        layoutBinding.chartTransactionRecyclerView.adapter = ChartTransactionAdapter()
        layoutBinding.chartTransactionRecyclerView.layoutManager= LinearLayoutManager(context)
    }


}