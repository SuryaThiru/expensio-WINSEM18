package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_expense.*
import kotlinx.android.synthetic.main.activity_set_budget.*
import model.addExpense
import model.getCategories
import java.util.*
import kotlin.collections.ArrayList


class AddExpense : AppCompatActivity() {
    var date = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val realm = Realm.getDefaultInstance()

        pick_date_of_expense.setOnClickListener{
            // Show the date picker dialog
            val newFragment = DatePickerFragment(date)
            newFragment.show(fragmentManager, "Date Picker")
        }

        fab_add_expense.setOnClickListener{
            var amnt = 0
            var reason = ""
            var category = ""

            try {
                amnt = input_expense_amnt.text.toString().toInt()
                reason = input_expense_reason.text.toString()
                category = input_expense_category.selectedItem.toString()

                addExpense(realm, amnt, reason, date, category)
            } catch (err: Exception) {
                Log.e("Set expense", "probably your input form is empty")
            }

        }

        var categories = ArrayList<String>()
        categories.add("Choose category")

        getCategories(realm).forEach { any ->
            categories.add(any.name)
        }

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
// Apply the adapter to the spinner
        input_expense_category.adapter = adapter
    }


}
