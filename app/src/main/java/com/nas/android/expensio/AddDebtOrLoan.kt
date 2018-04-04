package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_debt_or_loan.*
import model.DEBT
import model.LOAN
import model.addLoan
import java.util.*

class AddDebtOrLoan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_debt_or_loan)

        fab_add_debt_loan.setOnClickListener{
            try {
                val amnt = inp_loan_amnt.text.toString().toInt()
                val rem = inp_loan_rem.text.toString()
                val actor = inp_loan_actr.text.toString()
                val opt = if (loan_radio.checkedRadioButtonId == radio_loan.id) LOAN else DEBT

                val realm = Realm.getDefaultInstance()
                addLoan(realm, amnt, rem, opt, actor, Date())

                Log.i("Add loan", "added new loan / debt")
                Toast.makeText(this, "Added new loan / debt", Toast.LENGTH_SHORT).show()

                finish()
            }
            catch (err: Exception) {
                Log.e("Add loan", "Error occured " + err)
                Toast.makeText(this, "Some error occured", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
