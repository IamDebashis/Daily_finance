package com.example.dailyfinance.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R
import com.example.dailyfinance.adapter.*
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.formatter.PercentFormatter

import com.github.mikephil.charting.data.PieData

import com.github.mikephil.charting.data.PieDataSet

import com.github.mikephil.charting.utils.ColorTemplate

import com.github.mikephil.charting.data.PieEntry

import com.github.mikephil.charting.components.Legend


class DashboardFragment : Fragment() {




    private lateinit var pieChart: PieChart
    private lateinit var upComingBorrowRecyclerView: RecyclerView
    private lateinit var upComingLendRecyclerView: RecyclerView
    private lateinit var lastTransactionRecyclerView: RecyclerView
    private lateinit var upComingEmisRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initAllViews(view)
        setUpAllAdpater()

        setupPieChart()
        loadPieChartData()

    }



    /*------------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------
    Set up dashboard pie chat
    ---------------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------*/

    private fun setupPieChart() {
        pieChart.isDrawHoleEnabled = true
        pieChart.setUsePercentValues(true)
        pieChart.setEntryLabelTextSize(12F)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.centerText = "Total Expense"
        pieChart.setCenterTextSize(16F)
        pieChart.description.isEnabled = false
        val l: Legend = pieChart.legend
       /* l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)*/
        l.isEnabled = false
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
        data.setValueFormatter(PercentFormatter(pieChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)
        pieChart.data = data
        pieChart.invalidate()
        pieChart.animateY(1400, Easing.EaseInOutQuad)
    }

    /************************************************************************************
     * Upcoming Borrow Adapter setup
     * ************************************************************************************/

    private fun setUpAllAdpater(){

        upComingBorrowRecyclerView.adapter = UpcomingBorrowAdapter()
        upComingBorrowRecyclerView.layoutManager = LinearLayoutManager(context)

        upComingLendRecyclerView.adapter = UpcomingBorrowAdapter()
        upComingLendRecyclerView.layoutManager = LinearLayoutManager(context)

        lastTransactionRecyclerView.adapter = LastTransactionAdapter()
        lastTransactionRecyclerView.layoutManager = LinearLayoutManager(context)

        upComingEmisRecyclerView.adapter = UpComingEmisAdapter()
        upComingEmisRecyclerView.layoutManager = LinearLayoutManager(context).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
    }

    /*======================================================================================
    * Initialize all the views*/
    private fun initAllViews(v : View){

        pieChart = v.findViewById(R.id.piechart)
        upComingBorrowRecyclerView = v.findViewById(R.id.upcoming_borrow_recyclerView)
        upComingLendRecyclerView = v.findViewById(R.id.upcoming_lend_recyclerView)
        lastTransactionRecyclerView = v.findViewById(R.id.last_transaction_recyclerView)
        upComingEmisRecyclerView = v.findViewById(R.id.upcoming_emis_recyclerView)
    }





}