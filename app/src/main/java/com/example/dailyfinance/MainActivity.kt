package com.example.dailyfinance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dailyfinance.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton



const val Lend_Tag = "Lend_Tag"
const val Borrow_Tag = "Borrow_Tag"
const val Expense_Tag = "Expense_Tag"
const val Choose_Fragment = "choose_fragment"



class MainActivity : AppCompatActivity() {

    private val  TAG = "MainActivity"
    private var FLOATING_ACTION_BUTTON_STATE = true

    private lateinit var layout: ActivityMainBinding


    private lateinit var mainActionButton: FloatingActionButton
    private lateinit var borrowrdActionButton: FloatingActionButton
    private lateinit var expenceActionButton: FloatingActionButton
    private lateinit var landActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        val navHost = findNavController(R.id.nav_hostController)

        layout.navigationView.setupWithNavController(navHost)



        //Initial views
        initView()
        setupAddTransactionview()






        layout.extendBg.setOnClickListener{
           closeFABMenu()
        }
        /*Visible or hide the extra add button */
        mainActionButton.setOnClickListener{
            if(FLOATING_ACTION_BUTTON_STATE){
                showFABMenu()
            }else{
                closeFABMenu()
            }
        }

    }







    private fun initView(){
        mainActionButton = findViewById<FloatingActionButton>(R.id.main_action_button)
        borrowrdActionButton = findViewById(R.id.borrowed_action_button)
        landActionButton = findViewById(R.id.land_action_button)
        expenceActionButton = findViewById(R.id.expence_action_button)
    }



    /*********** show and hide Extend FB Button ******/

    fun closeFABMenu(){
        FLOATING_ACTION_BUTTON_STATE = true
        layout.mainActionButton.animate().rotation(0f)
        layout.extendBg.visibility = View.GONE
        layout.borrowedActionButton.visibility = View.GONE
        layout.landActionButton.visibility = View.GONE
        layout.expenceActionButton.visibility = View.GONE
        layout.borrowedText.visibility = View.GONE
        layout.lendText.visibility = View.GONE
        layout.expenseText.visibility = View.GONE
    }
    fun showFABMenu(){
        FLOATING_ACTION_BUTTON_STATE = false
        layout.mainActionButton.animate().rotationBy(45f)
        layout.extendBg.visibility = View.VISIBLE
        layout.borrowedActionButton.visibility = View.VISIBLE
        layout.landActionButton.visibility = View.VISIBLE
        layout.expenceActionButton.visibility = View.VISIBLE
        layout.borrowedText.visibility = View.VISIBLE
        layout.lendText.visibility = View.VISIBLE
        layout.expenseText.visibility = View.VISIBLE
    }


    private fun setupAddTransactionview(){

        borrowrdActionButton.setOnClickListener{
            addTransactionActivity(Borrow_Tag)
            closeFABMenu()
        }
        landActionButton.setOnClickListener{
            addTransactionActivity(Lend_Tag)
            closeFABMenu()
        }
        expenceActionButton.setOnClickListener {
            addTransactionActivity(Expense_Tag)
            closeFABMenu()
        }


    }

 private fun addTransactionActivity(arg : String){

     val transactionActivity = Intent(this,AddTransactionActivity::class.java).also {
         it.putExtra(Choose_Fragment, arg)
     }
     startActivity(transactionActivity)
 }




}