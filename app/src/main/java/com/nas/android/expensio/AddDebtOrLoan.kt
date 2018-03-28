package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_debt_or_loan.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import model.DEBT
import model.LOAN
import model.addLoan
import java.util.*

class AddDebtOrLoan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_debt_or_loan)

        fab.setOnClickListener { view: View ->
            Snackbar.make(view, "Detail Added", Snackbar.LENGTH_LONG)
                    .setAction("Action", {
                        val amnt = inp_loan_amnt.text.toString().toInt()
                        val rem = inp_loan_rem.text.toString()
                        val actor = inp_loan_actr.text.toString()
                        val opt = if (loan_radio.checkedRadioButtonId == 0) LOAN else DEBT
                        val date = null

                        val realm = Realm.getDefaultInstance()
                        addLoan(realm, amnt, rem, opt, actor, Date())

                        Log.i("Realm write", "added new category")
                    }).show()
        }


    }
}
