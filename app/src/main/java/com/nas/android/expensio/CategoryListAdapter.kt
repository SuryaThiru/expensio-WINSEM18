package com.nas.android.expensio

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import kotlinx.android.synthetic.main.category_list_cell.view.*
import model.deleteCategory
import model.getCategories


/**
 * Created by Neha Bala on 20-03-2018.
 */

class CategoryListAdapter: RecyclerView.Adapter<CustomCategoryViewHolder>(){

    private val categories = ArrayList<String>()

    init {
        getcategories()
    }

    fun getcategories() {
        val realm = Realm.getDefaultInstance()
        var results = getCategories(realm)
        Log.i("Categories realm query", "$results")

        for (res in results) categories.add(res.name)
    }

    //number of items
    override fun getItemCount(): Int{
        return categories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.category_list_cell,parent,false)
        return CustomCategoryViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomCategoryViewHolder?, position: Int) {
        val category = categories[position]
        holder?.view?.category_name?.text = category

        holder?.view?.fab_delete_category?.setOnClickListener{
            val pos = holder.adapterPosition
            removeAt(pos)

            val realm = Realm.getDefaultInstance()
            deleteCategory(realm, category)
        }
    }

    fun removeAt(pos: Int?) {
        if (pos == null)
            return

        categories.removeAt(pos)

        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, categories.size)
    }
}

class CustomCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view)
