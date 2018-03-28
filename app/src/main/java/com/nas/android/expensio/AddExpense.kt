package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_add_expense.*


class AddExpense : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        pick_date_of_expense.setOnClickListener{
            // Show the date picker dialog
            val newFragment = DatePickerFragment()
            newFragment.show(fragmentManager, "Date Picker")
        }

        fab_add_expense.setOnClickListener{

            //this adds the expense to db (or whatever)
        }

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item)
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
// Apply the adapter to the spinner
        planets_spinner.adapter = adapter
    }


}
