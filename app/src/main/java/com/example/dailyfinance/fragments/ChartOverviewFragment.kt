package com.example.dailyfinance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfinance.R
import com.example.dailyfinance.adapter.CategoryListChartAdapter
import com.example.dailyfinance.databinding.FragmentChartOverviewBinding
import com.example.dailyfinance.models.AdapterItemClickListener


class ChartOverviewFragment : Fragment(),AdapterItemClickListener {

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
        binding.categoryList.adapter = CategoryListChartAdapter().apply {
            setItemClickListner(this@ChartOverviewFragment)
        }
        binding.categoryList.layoutManager = LinearLayoutManager(context)


    }

    override fun onClick() {
        findNavController().navigate(R.id.action_chartOverviewFragment_to_chartItemFragment2)
//        Navigation.findNavController(binding.root).navigate(R.id.action_chartItemFragment_to_chartOverviewFragment2)
//            Toast.makeText(context,"YOU type something",Toast.LENGTH_SHORT).show()

    }


}