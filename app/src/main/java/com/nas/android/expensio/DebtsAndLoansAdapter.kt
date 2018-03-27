package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import kotlinx.android.synthetic.main.debts_and_loans_list_cell.view.*
import model.getExpenses
import model.getLoans
import java.util.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class DebtsAndLoansAdapter: RecyclerView.Adapter<CustomDebtViewHolder>(){

    val actor = ArrayList<String>()
    val amount = ArrayList<String>()
    val remark = ArrayList<String>()
    val date = ArrayList<String>()

    init {
        try {
            getloans()
        } catch (e: NullPointerException) {
            Log.w("Realm query loans", "No loans or debts are found")
        }
    }

    fun getloans() {
        val realm = Realm.getDefaultInstance()
        val results = getLoans(realm)

        for (res in results) {
            actor.add(res.actor)
            amount.add(res.amount.toString())
            remark.add(res.remark)
            date.add(res.returnDate.toString())
        }
    }

    //number of items
    override fun getItemCount(): Int{
        return amount.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomDebtViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.debts_and_loans_list_cell,parent,false)
        return CustomDebtViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomDebtViewHolder?, position: Int) {
        // TODO bind with loans view
        val amount = amount.get(position)
        val amt = amount.get(position)
        holder?.view?.debtor_or_loaner?.text = wordss
        holder?.view?.amount_Debt_or_loan?.text = amt

/*
        holder?.view?.reason?.text = wordss
*/
    }
}

class CustomDebtViewHolder(val view: View) : RecyclerView.ViewHolder(view){

}