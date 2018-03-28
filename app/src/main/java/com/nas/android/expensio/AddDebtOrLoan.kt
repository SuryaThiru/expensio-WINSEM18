package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_debt_or_loan.*
import model.DEBT
import model.LOAN
import model.addLoan
import java.text.SimpleDateFormat
import java.util.*

class AddDebtOrLoan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_debt_or_loan)

        fab_add_debt_loan.setOnClickListener { view: View ->
            Snackbar.make(view, "Detail Added", Snackbar.LENGTH_LONG)
                    .setAction("Action", {
                        val amnt = inp_loan_amnt.text.toString().toInt()
                        val rem = inp_loan_rem.text.toString()
                        val actor = inp_loan_actr.text.toString()
                        val opt = if (loan_radio.checkedRadioButtonId == 0) LOAN else DEBT
                        // TODO get date

                        val realm = Realm.getDefaultInstance()
                        addLoan(realm, amnt, rem, opt, actor, Date())

                        Log.i("Realm write", "added new category")

                        inp_loan_actr.setText("")
                        inp_loan_rem.setText("")
                        inp_loan_amnt.setText("")
                        loan_radio.clearCheck()
                    }).show()
        }


    }
}
