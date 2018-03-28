package com.nas.android.expensio

import android.app.Application
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by surya on 3/19/18.
 */
class GlobalState : Application() {
    override fun onCreate() {
        super.onCreate()

        // initialise database and config
        Realm.init(this)

        val config = RealmConfiguration.Builder().name("expenses.realm").build()
        Realm.setDefaultConfiguration(config)

        if(BuildConfig.DEBUG)
            this.getExternalFilesDir(null)

        Log.i("Realm init", "db stored in " + this.filesDir)
    }
}
