package com.example.dailyfinance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dailyfinance.R
import com.example.dailyfinance.databinding.FragmentEmiBinding


class EmiFragment : Fragment() {

    private lateinit var binding: FragmentEmiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmiBinding.inflate(inflater,container,false)
        return binding.root
    }




    companion object {

        @JvmStatic
        fun newInstance() = EmiFragment()
    }



    override fun onDestroy() {
        super.onDestroy()

    }


}