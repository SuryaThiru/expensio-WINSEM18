package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.debts_and_loans_list_cell.view.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class DebtsAndLoansAdapter: RecyclerView.Adapter<CustomDebtViewHolder>(){

    val words = listOf<String>("debtor or loaner","debtor or loaner","debtor or loaner","debtor or loaner","debtor or loaner")
    val amount = listOf<String>("amount","amount","amount","amount","amount")
    //number of items
    override fun getItemCount(): Int{
        return words.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomDebtViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.debts_and_loans_list_cell,parent,false)
        return CustomDebtViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomDebtViewHolder?, position: Int) {
        val wordss = words.get(position)
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