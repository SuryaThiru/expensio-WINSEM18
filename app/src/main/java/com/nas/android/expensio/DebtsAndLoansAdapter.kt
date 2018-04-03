package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import kotlinx.android.synthetic.main.debts_and_loans_list_cell.view.*
import model.deleteLoan
import model.getLoans
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class DebtsAndLoansAdapter: RecyclerView.Adapter<CustomDebtViewHolder>(){

    val actor = ArrayList<String>()
    val amount = ArrayList<String>()
    val remark = ArrayList<String>()
    val date = ArrayList<Date?>()

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
            date.add(res.returnDate)
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
        val actor = actor[position]
        val amount = amount[position]
        val rem = remark[position]
        val date = date[position]
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        holder?.view?.loans_actor?.text = actor
        holder?.view?.loans_amount?.text = amount
        holder?.view?.loans_remarks?.text = rem
        holder?.view?.loans_date?.text = dateFormat.format(date)

        holder?.view?.fab_delete_loan_debt?.setOnClickListener{
            val pos = holder.adapterPosition
            removeAt(pos)

            val realm = Realm.getDefaultInstance()
            deleteLoan(realm, rem, actor)
        }
    }

    fun removeAt(pos: Int?) {
        if (pos == null)
            return

        actor.removeAt(pos)
        amount.removeAt(pos)
        remark.removeAt(pos)
        date.removeAt(pos)

        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, actor.size)
    }
}

class CustomDebtViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}
