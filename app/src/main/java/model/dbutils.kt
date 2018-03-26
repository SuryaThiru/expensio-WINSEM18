package model

import android.util.Log
import com.nas.android.expensio.SetBudget
import io.realm.Realm
import io.realm.RealmList
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

fun getUser(realm: Realm, name: String) {
    // function for testing purposes
    val user = realm.where<User>(User::class.java).equalTo("name", name).findFirst()!!

    if (user != null)
        Log.i("Realm query", "found user: ${user.name}")
    else
        Log.e("Realm query", "User not found")
}

fun setUserBudget(realm: Realm, budget: Int, date: Date = Date()) {
    val user = realm.where<User>(User::class.java).findFirst()!!

    realm.executeTransaction { _ ->
        user.budget = budget
        user.budgetStartDate = date
    }
}

fun addExpense(realm: Realm, amount: Int, remarks: String, date: Date, categoryname: String) {
    val category = realm.where<Category>(Category::class.java).equalTo("name", categoryname).findFirst()

    if (category == null) {
        Log.e("Realm Query", "Category not found")
        return
    }

    val user = realm.where<User>(User::class.java).findFirst()!!

    realm.executeTransaction { _ ->
        val expense = realm.createObject<Expense>(Expense::class.java)
        expense.amount = amount
        expense.remarks = remarks
        expense.date = date
        expense.category = category

        user.expenses.add(expense)
    }
}

fun addCategory(realm: Realm, name: String, color: String) {
    realm.executeTransaction{ _ ->
        val category = realm.createObject<Category>(Category::class.java, name)
        category.color = color
    }

}

fun addLoan(realm: Realm, amount: Int, remark: String, type: Boolean, actor: String, date: Date) {
    realm.executeTransaction { _ ->
        val loan = realm.createObject<Loan>(Loan::class.java)
        loan.amount = amount
        loan.remark = remark
        loan.type = type
        loan.actor = actor
        loan.returnDate = date

        val user = realm.where<User>(User::class.java).findFirst()!!
        user.loans.add(loan)
    }
}

fun getExpenses(realm: Realm): RealmList<Expense> {
    val user = realm.where<User>(User::class.java).findFirst()!!

    return user.expenses
}