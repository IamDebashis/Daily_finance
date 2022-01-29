package com.example.dailyfinance.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.example.dailyfinance.R
import com.example.dailyfinance.databinding.FragmentAddEmiBottomSheetBinding
import com.example.dailyfinance.databinding.FragmentEmiBinding
import com.example.dailyfinance.dialogs.AddEmiBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class EmiFragment : Fragment() {

    private val TAG: String = "EMI FRAGMENT"
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBottomSheet()
    }

    /************Setup BottomSheet***************/
    fun setUpBottomSheet(){
        val sheet = AddEmiBottomSheet()
        val bsBh = sheet.dialog
        if(bsBh == null) {
            Log.i(TAG, "setUpBottomSheet: bsBH is Null")
        }else{
            Log.i(TAG, "setUpBottomSheet: bsBH is not Null")
        }
        binding.addEmiFB.setOnClickListener{
            sheet.show(parentFragmentManager,"AddBottomsheet")
        }


//        sheetBehavior.addBottomSheetCallback(sheetBehaviorCallback)



    }

    private val sheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback(){

        override fun onStateChanged(bottomSheet: View, newState: Int) {

            val Sheetbinding = FragmentAddEmiBottomSheetBinding.bind(bottomSheet)
            Toast.makeText(context,"Sate : $newState",Toast.LENGTH_SHORT).show()

        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {



        }


    }



    companion object {

        @JvmStatic
        fun newInstance() = EmiFragment()
    }



    override fun onDestroy() {
        super.onDestroy()

    }


}