package com.example.dailyfinance.dialogs

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.dailyfinance.R
import com.example.dailyfinance.databinding.FragmentAddEmiBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AddEmiBottomSheet : BottomSheetDialogFragment() {


    lateinit var sheetBehavior: BottomSheetBehavior<View>
     lateinit var layout : FragmentAddEmiBottomSheetBinding


    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val sheet = super.onCreateDialog(savedInstanceState)

        val view = View.inflate(context,R.layout.fragment_add_emi_bottom_sheet,null)

//        Binding View with data binding
        layout = DataBindingUtil.bind(view)!!
//        Setting layout with bottom sheet
        sheet.setContentView(view)

        sheetBehavior = BottomSheetBehavior.from((view.parent) as View)

        sheetBehavior.peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO
//        setting bottom sheet max height
        layout.extraSpace.minimumHeight = Resources.getSystem().displayMetrics.heightPixels/2

        sheetBehavior.addBottomSheetCallback(sheetBehaviorCallback)

        return sheet
    }

    override fun onStart() {
        super.onStart()
        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }


    private val sheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback(){

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when(newState){
                    BottomSheetBehavior.STATE_SETTLING->{


                    }
                    BottomSheetBehavior.STATE_COLLAPSED ->{

                    }
                    BottomSheetBehavior.STATE_EXPANDED ->{

                    }
                    BottomSheetBehavior.STATE_HIDDEN ->{
                        dismiss()
                    }

            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }


    }




    companion object {

        @JvmStatic
        fun newInstance() = AddEmiBottomSheet()
            }



}
