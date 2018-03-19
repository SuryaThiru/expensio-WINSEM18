package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.app_bar_main_navigation.*

class DebtsAndLoansList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debts_and_loans_list)

        fab.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, AddDebtOrLoan::class.java)
            startActivity(intent);
        }
    }
}
