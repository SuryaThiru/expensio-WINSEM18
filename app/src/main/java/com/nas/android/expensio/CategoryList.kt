package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.app_bar_main_navigation.*

class CategoryList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        fab.setOnClickListener {
            // Handler code here.
            val intent = Intent(applicationContext, AddCategory::class.java)
            startActivity(intent);
        }
    }
}
