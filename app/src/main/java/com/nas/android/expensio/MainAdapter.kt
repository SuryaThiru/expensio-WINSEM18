package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import kotlinx.android.synthetic.main.day_expense.view.*
import model.getExpenses


/**
 * Created by Neha Bala on 20-03-2018.
 */

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){

    val reasons = ArrayList<String>()
    val amount = ArrayList<String>()
    val category = ArrayList<String>()

    init {
        getexpenses()
    }

    fun getexpenses() {
        val realm = Realm.getDefaultInstance()
        val results = getExpenses(realm)

        for (res in results) {
            reasons.add(res.remarks)
            amount.add(res.amount.toString())
            category.add(res.category!!.name)
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

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val amt = amount.get(position)
        val res = reasons.get(position)
        val cat = category.get(position)
        holder?.view?.amount?.text = amt
        holder?.view?.reason?.text = res
        holder?.view?.category?.text = cat
/*
        holder?.view?.reason?.text = wordss
*/
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view){

}