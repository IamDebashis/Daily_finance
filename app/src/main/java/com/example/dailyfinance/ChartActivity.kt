package com.example.dailyfinance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfinance.fragments.ChartOverviewFragment

class ChartActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

       /* supportFragmentManager.commit {
            replace(R.id.fragmentContainerView,ChartOverviewFragment())
            setReorderingAllowed(true)
        }
*/

    }























}