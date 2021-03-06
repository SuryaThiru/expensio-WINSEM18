package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_set_budget.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import model.setUserBudget
import java.util.*

class SetBudget : AppCompatActivity() {
    var from = Date()
    var to = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_budget)

        fab_budget.setOnClickListener{
            var amnt = 0
            try {
                amnt = input_budget_amount.text.toString().toInt()
            } catch (e: Exception) {
                Log.e("Set budget", "probably your input form is empty")
                Toast.makeText(this, "Your input form is empty", Toast.LENGTH_SHORT).show()
            }

            if (amnt != 0) {
                val realm = Realm.getDefaultInstance()
                setUserBudget(realm, amnt, from, to)

                Log.i("Set budget", "added new budget")
                Toast.makeText(this, "Added new budget", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        pick_date_from.setOnClickListener {
            val newFragment = DatePickerFragment(from, budget_from)
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")
        }

        pick_date_to.setOnClickListener {
            val newFragment = DatePickerFragment(to, budget_to)
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")
        }

    }
}
