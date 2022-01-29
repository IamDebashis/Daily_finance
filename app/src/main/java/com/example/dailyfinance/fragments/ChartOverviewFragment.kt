package com.example.dailyfinance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfinance.R
import com.example.dailyfinance.adapter.CategoryListChartAdapter
import com.example.dailyfinance.databinding.FragmentChartOverviewBinding


class ChartOverviewFragment : Fragment() {

    private var _binding: FragmentChartOverviewBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChartOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onNavigateUp()
        }

        setupAddapters()

    }

    /******Set up all Adapters*************/
    fun setupAddapters(){
        binding.categoryList.adapter = CategoryListChartAdapter()
        binding.categoryList.layoutManager = LinearLayoutManager(context)


    }



}