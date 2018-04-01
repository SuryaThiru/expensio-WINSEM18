package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_category.*
import kotlinx.android.synthetic.main.day_expense.*
import model.addCategory

class AddCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        category_add.setOnClickListener {
            val name = input_name.text.toString()
            val color = input_color.text.toString()

            val realm = Realm.getDefaultInstance()
            addCategory(realm, name, color)

            Log.i("Realm write", "added new category")
            Toast.makeText(this, "Added new category", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
