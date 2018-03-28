package com.nas.android.expensio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_user_detail.*

class NewUserDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user_detail)

        fab_create_new_user.setOnClickListener{
            val intent = Intent(applicationContext, MainNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}
