package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_set_budget.*

class BudgetList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_list)

        fab_budget.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, SetBudget::class.java)
            startActivity(intent);
        }
    }
}
