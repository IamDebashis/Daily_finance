package com.example.dailyfinance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.dailyfinance.fragments.AddBorrowFragment
import com.example.dailyfinance.fragments.AddExpensFragment
import com.example.dailyfinance.fragments.AddLendFragment

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

      val  fragment =  when(intent.getStringExtra(Choose_Fragment)){

          Lend_Tag -> AddLendFragment()
          Borrow_Tag -> AddBorrowFragment()
          Expense_Tag -> AddExpensFragment()
          else -> AddExpensFragment()
      }


        supportFragmentManager.commit {
            replace(R.id.fag_container,fragment)
            setReorderingAllowed(true)

        }

    }
}