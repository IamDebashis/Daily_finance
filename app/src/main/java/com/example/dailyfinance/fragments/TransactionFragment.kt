package com.example.dailyfinance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.R
import com.example.dailyfinance.adapter.TransactionAdapter
import com.example.dailyfinance.dialogs.ExpanseDetailsBottonSheet


class TransactionFragment : Fragment() {

    lateinit var transactionRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)


    }


    /******************* Initialize Views ***************************************************/

    fun initViews(parent: View){
        transactionRecyclerView  = parent.findViewById<RecyclerView>(R.id.transactions)
        transactionRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TransactionAdapter(recyclerViewOnitemClick)



        }


    }


    private var recyclerViewOnitemClick = View.OnClickListener {
        val modelbottomsheet = ExpanseDetailsBottonSheet()
        modelbottomsheet.show(parentFragmentManager,"MYTAG")
    }



    companion object {


        fun newInstance(param1: String, param2: String) =
            TransactionFragment()
    }
}