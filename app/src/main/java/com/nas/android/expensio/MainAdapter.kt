package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.day_expense.view.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){

    val reasons = listOf<String>("reason","reason","reason","reason")
    val amount = listOf<String>("amount","amount","amount","amount")
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
        holder?.view?.amount?.text = amt
        holder?.view?.reason?.text = res
/*
        holder?.view?.reason?.text = wordss
*/
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view){

}