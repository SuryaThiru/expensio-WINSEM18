package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_add_debt_or_loan.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*

class AddDebtOrLoan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_debt_or_loan)

        fab_add_debt_loan.setOnClickListener { view ->
            Snackbar.make(view, "Detail Added", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }
}
