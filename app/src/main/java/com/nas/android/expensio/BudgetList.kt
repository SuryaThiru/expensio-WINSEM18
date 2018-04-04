package com.nas.android.expensio

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_budget_list.*
import kotlinx.android.synthetic.main.activity_set_budget.*
import model.getTotalExpense
import model.getUserBudget
import java.text.SimpleDateFormat

class BudgetList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_list)

        fab_budget_list.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, SetBudget::class.java)
            startActivity(intent)
        }

        val realm = Realm.getDefaultInstance()
        val budget = getUserBudget(realm)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        from_date.text = dateFormat.format(budget.from)
        to_date.text = dateFormat.format(budget.to)
        week_budget.text = budget.amount.toString()

        val total = getTotalExpense(budget.from, budget.to)
        var diff = budget.amount - total.toInt()

        if (diff > 0) {
            budget_outstanding.text = diff.toString()
            budget_outstanding.setTextColor(Color.RED)
        }
        else {
            budget_outstanding.text = diff.toString()
            budget_outstanding.setTextColor(Color.GREEN)
        }

    }

    override fun onResume() {
        super.onResume()

        val realm = Realm.getDefaultInstance()
        val budget = getUserBudget(realm)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        from_date.text = dateFormat.format(budget.from)
        to_date.text = dateFormat.format(budget.to)
        week_budget.text = budget.amount.toString()

        val total = getTotalExpense(budget.from, budget.to)
        var diff = budget.amount - total.toInt()

        if (diff > 0) {
            budget_outstanding.text = diff.toString()
            budget_outstanding.setTextColor(Color.GREEN)
        }
        else {
            budget_outstanding.text = diff.toString()
            budget_outstanding.setTextColor(Color.RED)
        }
    }
}
