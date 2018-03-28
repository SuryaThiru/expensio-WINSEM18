package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_debts_and_loans_list.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*

class DebtsAndLoansList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debts_and_loans_list)

        debts_and_loans_recyclerview.layoutManager = LinearLayoutManager(this)
        debts_and_loans_recyclerview.adapter = DebtsAndLoansAdapter()

        fab1.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, AddDebtOrLoan::class.java)
            startActivity(intent)
        }
    }
}
