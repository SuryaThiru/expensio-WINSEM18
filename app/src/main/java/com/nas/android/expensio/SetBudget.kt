package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_set_budget.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import java.util.*

class SetBudget : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_budget)

        fab_budget.setOnClickListener { view ->
            Snackbar.make(view, "Budget set", Snackbar.LENGTH_SHORT)
                    .setAction("Action", {
                        val amnt = input_budget_amount.text.toString().toInt()

                    }).show()
        }

        pick_date_from.setOnClickListener {
            val newFragment = DatePickerFragment()
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")
        }

        pick_date_to.setOnClickListener {
            val newFragment = DatePickerFragment()
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")

        }

    }
}
