package com.nas.android.expensio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import io.realm.Realm
import io.realm.RealmConfiguration


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // test database
        Realm.init(this)
        var realmconfig = RealmConfiguration.Builder()
                .name("test.realm")
                .build()
        Realm.setDefaultConfiguration(realmconfig)
    }
}
