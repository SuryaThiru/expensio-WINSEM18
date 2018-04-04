package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nas.android.expensio.R.id.fab_delete_expense
import com.nas.android.expensio.R.id.reason
import io.realm.Realm
import kotlinx.android.synthetic.main.day_expense.view.*
import model.deleteExpense
import model.getExpenses
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){

    val reasons = ArrayList<String>()
    val amount = ArrayList<String>()
    val category = ArrayList<String>()
    val date = ArrayList<Date>()

    init {
        try{
            getexpenses()
        } catch (e: NullPointerException) {
            Log.w("Exception main adapter", "No expenses found")
        }
    }

    private fun getexpenses() {
        val realm = Realm.getDefaultInstance()
        val results = getExpenses(realm)

        for (res in results) {
            reasons.add(res.remarks)
            amount.add(res.amount.toString())
            category.add(res.category!!.name)
            date.add(res.date)
        }
    }

    //number of items
    override fun getItemCount(): Int{
        return reasons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.day_expense,parent,false)

        return CustomViewHolder(cellForRow)
    }

    fun removeAt(pos: Int?) {
        if (pos == null)
            return

        reasons.removeAt(pos)
        amount.removeAt(pos)
        category.removeAt(pos)
        date.removeAt(pos)

        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, reasons.size)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val amt = amount.get(position)
        val res = reasons.get(position)
        val cat = category.get(position)
        val date = date.get(position)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        holder?.view?.amount?.text = amt
        holder?.view?.reason?.text = res
        holder?.view?.category?.text = cat
        holder?.view?.expense_date?.text = dateFormat.format(date)

        holder?.view?.fab_delete_expense?.setOnClickListener {
            val pos = holder?.adapterPosition
            removeAt(pos)

            val realm = Realm.getDefaultInstance()
            deleteExpense(realm, amt.toInt(), res, cat)
        }
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view)
