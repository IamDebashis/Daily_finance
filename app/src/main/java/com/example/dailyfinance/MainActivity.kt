package com.example.dailyfinance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton



const val Lend_Tag = "Lend_Tag"
const val Borrow_Tag = "Borrow_Tag"
const val Expense_Tag = "Expense_Tag"
const val Choose_Fragment = "choose_fragment"



class MainActivity : AppCompatActivity() {

    private val  TAG = "MainActivity"
    private var FLOATING_ACTION_BUTTON_STATE = false
    private lateinit var mainActionButton: FloatingActionButton
    private lateinit var borrowrdActionButton: FloatingActionButton
    private lateinit var expenceActionButton: FloatingActionButton
    private lateinit var landActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav = findViewById<BottomNavigationView>(R.id.navigation_view)

        Log.i(TAG, "onCreate: ${R.id.nav_hostController}")

        val navHost = findNavController(R.id.nav_hostController)

        nav.setupWithNavController(navHost)

        FLOATING_ACTION_BUTTON_STATE = false

        //Initial views
        initView()
        setupAddTransactionview()







        /*Visible or hide the extra add button */
        mainActionButton.setOnClickListener{
          showOrHideAddButton()
        }

    }







    private fun initView(){
        mainActionButton = findViewById<FloatingActionButton>(R.id.main_action_button)
        borrowrdActionButton = findViewById(R.id.borrowed_action_button)
        landActionButton = findViewById(R.id.land_action_button)
        expenceActionButton = findViewById(R.id.expence_action_button)
    }



    private fun showOrHideAddButton(){

        if(FLOATING_ACTION_BUTTON_STATE){
            FLOATING_ACTION_BUTTON_STATE = false
            borrowrdActionButton.visibility = View.GONE
            landActionButton.visibility = View.GONE
            expenceActionButton.visibility = View.GONE

        }else{
            FLOATING_ACTION_BUTTON_STATE = true
            borrowrdActionButton.visibility = View.VISIBLE
            landActionButton.visibility = View.VISIBLE
            expenceActionButton.visibility = View.VISIBLE
        }
    }


    private fun setupAddTransactionview(){

        borrowrdActionButton.setOnClickListener{
            addTransactionActivity(Borrow_Tag)
            showOrHideAddButton()
        }
        landActionButton.setOnClickListener{
            addTransactionActivity(Lend_Tag)
            showOrHideAddButton()
        }
        expenceActionButton.setOnClickListener {
            addTransactionActivity(Expense_Tag)
            showOrHideAddButton()
        }


    }

 private fun addTransactionActivity(arg : String){

     val transactionActivity = Intent(this,AddTransactionActivity::class.java).also {
         it.putExtra(Choose_Fragment, arg)
     }
     startActivity(transactionActivity)
 }




}