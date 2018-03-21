package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category_list.*
import kotlinx.android.synthetic.main.activity_debts_and_loans_list.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*

class CategoryList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        category_list_recyclerview.layoutManager = LinearLayoutManager(this)
        category_list_recyclerview.adapter = Category_list_adapter()

        fab_category_list.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, AddCategory::class.java)
            startActivity(intent);
        }
    }
}
