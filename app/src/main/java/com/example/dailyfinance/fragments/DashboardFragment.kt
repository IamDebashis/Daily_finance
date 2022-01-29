package com.example.dailyfinance.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.ChartActivity
import com.example.dailyfinance.R
import com.example.dailyfinance.adapter.*
import com.example.dailyfinance.databinding.FragmentDashboardBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.formatter.PercentFormatter

import com.github.mikephil.charting.data.PieData

import com.github.mikephil.charting.data.PieDataSet

import com.github.mikephil.charting.utils.ColorTemplate

import com.github.mikephil.charting.data.PieEntry

import com.github.mikephil.charting.components.Legend


class DashboardFragment : Fragment() {

    private var _binding : FragmentDashboardBinding? = null

    private val binding  get() = _binding!!


    /*private lateinit var pieChart: PieChart
    private lateinit var upComingBorrowRecyclerView: RecyclerView
    private lateinit var upComingLendRecyclerView: RecyclerView
    private lateinit var lastTransactionRecyclerView: RecyclerView
    private lateinit var upComingEmisRecyclerView: RecyclerView
    private lateinit var layout: FragmentDashboardBinding*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentDashboardBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        setUpAllAdapter()
        setupPieChart()
        loadPieChartData()
        setUpClickListener()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    /*------------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------
    Set up dashboard pie chat
    ---------------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------*/

    private fun setupPieChart() {
        binding.piechart.apply {


            isDrawHoleEnabled = true
            setUsePercentValues(true)
            setEntryLabelTextSize(12F)
            setEntryLabelColor(Color.BLACK)
            centerText = "Total Expense"
            setCenterTextSize(16F)
            description.isEnabled = false
            val l: Legend = binding.piechart.legend
            /* l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)*/
            l.isEnabled = false
        }
    }

    private fun loadPieChartData() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(0.2f, "Food & Dining"))
        entries.add(PieEntry(0.15f, "Medical"))
        entries.add(PieEntry(0.10f, "Entertainment"))
        entries.add(PieEntry(0.25f, "Electricity and Gas"))
        entries.add(PieEntry(0.3f, "Housing"))

        val colors: ArrayList<Int> = ArrayList()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }
        val dataSet = PieDataSet(entries, "Total Expense")
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.piechart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)
        binding.piechart.data = data
        binding.piechart.invalidate()
        binding.piechart.animateY(1400, Easing.EaseInOutQuad)
    }

    /************************************************************************************
     * Upcoming Borrow Adapter setup
     * ************************************************************************************/

    private fun setUpAllAdapter(){
        binding.upcomingBorrowRecyclerView.adapter = UpcomingBorrowAdapter()
       binding.upcomingBorrowRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.upcomingLendRecyclerView.adapter = UpcomingBorrowAdapter()
        binding.upcomingLendRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.lastTransactionRecyclerView.adapter = LastTransactionAdapter()
        binding.lastTransactionRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.upcomingEmisRecyclerView.adapter = UpComingEmisAdapter()
        binding.upcomingEmisRecyclerView.layoutManager =  LinearLayoutManager(context).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

    }

    /*******Set UP ClickListener ****************/

    fun setUpClickListener(){

        binding.chartCard.setOnClickListener{
            startActivity(Intent(context,ChartActivity::class.java))
        }


    }





}