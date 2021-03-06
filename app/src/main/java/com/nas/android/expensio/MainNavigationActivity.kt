package com.nas.android.expensio

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main_navigation.*
import kotlinx.android.synthetic.main.content_main_navigation.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import model.*
import java.util.*


class MainNavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)
        setSupportActionBar(toolbar)

        // create the recycler view
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        main_recyclerview.adapter = MainAdapter()

        fab_main.setOnClickListener {
            val intent = Intent(applicationContext, AddExpense::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // test new user
        val realm = Realm.getDefaultInstance()
        if (getUser(realm) == null) {
            val newUserFragment = NewUserFragment()
            newUserFragment.show(supportFragmentManager, "Enter user name")
        }

        // test more db
//        val realm = Realm.getDefaultInstance()
//        createUser(realm, "developer")
//        getUser(realm, "test")
//        addCategory(realm, "test category", "#fff")
//        addExpense(realm, 500, "spend em all", Date(), "name")
//        var exp = getExpenses(realm)
//        Log.i("Realm query result", "exp - ${exp[0]?.amount} , ${exp[0]?.remarks} , ${exp[0]?.category}, ${exp[0]?.date}")
//        var cat = getCategories(realm)
//        Log.i("Realm query result", "category - $cat")
    }

    override fun onResume() {
        super.onResume()

        Log.d("Main activity", "on resume triggered")
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        main_recyclerview.adapter = MainAdapter()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.add_category -> {
                // Handles the action
                val intent = Intent(applicationContext, CategoryList::class.java)
                startActivity(intent)

            }
            R.id.set_budget -> {
                val intent = Intent(applicationContext, BudgetList::class.java)
                startActivity(intent)

            }
            R.id.view_spend_trends -> {
                val intent = Intent(applicationContext, ViewSpendTrends::class.java)
                startActivity(intent)

            }
            R.id.debts_and_loans -> {
                val intent = Intent(applicationContext, DebtsAndLoansList::class.java)
                startActivity(intent)
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
