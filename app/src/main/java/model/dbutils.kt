package model

import android.util.Log
import com.nas.android.expensio.SetBudget
import io.realm.Realm
import java.util.*

/**
 * Created by surya on 3/26/18.
 */

fun createUser(realm: Realm, name: String) {
    realm.executeTransaction { realm ->
        val user = realm.createObject<User>(User::class.java, name)
        Log.i("Realm create", "User object created")
    }
}

fun setUserBudget(realm: Realm, budget: Int) {
    val user = realm.where<User>(User::class.java).findFirst()!!

    realm.executeTransaction {_ ->
        user.budget = budget
    }
}

fun addExpense(realm: Realm, amount: Int, remarks: String, date: Date, categoryname: String) {
    val category = realm.where<Category>(Category::class.java).equalTo("name", categoryname)!!
    val user = realm.where<User>(User::class.java).findFirst()!!
    val expense = realm.createObject<Expense>(Expense::class.java)

    realm.executeTransaction {_ ->
        expense.amount = amount
        expense.remarks = remarks
        expense.date = date
        expense.category = category
        // TODO finish db

    }
}