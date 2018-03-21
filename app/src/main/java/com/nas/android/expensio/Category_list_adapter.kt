package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.category_list_cell.view.*


/**
 * Created by Neha Bala on 20-03-2018.
 */

class Category_list_adapter: RecyclerView.Adapter<CustomCategoryViewHolder>(){

    val words = listOf<String>("someone","someone","someone","someone","someone","someone","someone","someone","someone")
    //number of items
    override fun getItemCount(): Int{
        return words.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.category_list_cell,parent,false)
        return CustomCategoryViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomCategoryViewHolder?, position: Int) {
        val wordss = words.get(position)
        holder?.view?.category_name?.text = wordss
/*
        holder?.view?.reason?.text = wordss
*/
    }
}

class CustomCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view){

}