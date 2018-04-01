package model

import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import java.util.*

/**
 * Created by surya on 3/26/18.
 */


// required data classes

data class Budget(val amount: Int, val from: Date?, val to: Date?)

// required functions

fun createUser(realm: Realm, name: String) {
    realm.executeTransaction { realm ->
        val user = realm.createObject<User>(User::class.java, name)
        Log.i("Realm create", "User object created")
    }
}

fun getUser(realm: Realm): String? {
    // function for testing purposes
    val user = realm.where<User>(User::class.java).findFirst()

    return if (user != null) {
        Log.i("Realm query", "found user: ${user.name}")
        user.name
    } else {
        Log.e("Realm query", "User not found")
        null
    }
}

fun setUserBudget(realm: Realm, budget: Int, dateFrom: Date = Date(), dateTo: Date = Date()) {
    val user = realm.where<User>(User::class.java).findFirst()!!

    realm.executeTransaction { _ ->
        user.budget = budget
        user.budgetStartDate = dateFrom
        user.budgetEndDate = dateTo
    }
}

fun getUserBudget(realm: Realm): Budget {
    val user = realm.where<User>(User::class.java).findFirst()!!
    return Budget(user.budget, user.budgetStartDate, user.budgetEndDate)
}

fun deleteUserBudget(realm: Realm) {
    val user = realm.where<User>(User::class.java).findFirst()!!

    realm.executeTransaction{
        user.budget = 0
        user.budgetStartDate = null
        user.budgetEndDate = null
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
//        val expense = realm.createObject<Expense>(Expense::class.java)
        val expense = Expense()
        expense.amount = amount
        expense.remarks = remarks
        expense.date = date
        expense.category = category

        user.expenses.add(expense)
        
        Log.i("add expense", "added new expense")
    }
}

fun deleteExpense(realm: Realm, amount: Int, remark: String, categoryname: String) {
    val expense = realm.where<Expense>(Expense::class.java)
            .equalTo("remark", remark).equalTo("amount", amount)
            .equalTo("category", categoryname).findFirst()!!

    realm.executeTransaction {
        expense.deleteFromRealm()
    }
}

fun addCategory(realm: Realm, name: String, color: String) {
    /*
    add new category will throw primary key error if same name is added
     */
    realm.executeTransaction{ _ ->
        val category = realm.createObject<Category>(Category::class.java, name)
        category.color = color
    }

}

fun deleteCategory(realm: Realm, name: String) {
    val category = realm.where<Category>(Category::class.java)
            .equalTo("name", name).findFirst()!!

    realm.executeTransaction {
        category.deleteFromRealm()
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

fun deleteLoan(realm: Realm, remark: String, type: Boolean, actor: String) {
    val loan = realm.where<Loan>(Loan::class.java)
            .equalTo("remark", remark).equalTo("type", type)
            .equalTo("actor", actor).findFirst()!!

    realm.executeTransaction {
        loan.deleteFromRealm()
    }
}

fun getExpenses(realm: Realm): RealmList<Expense> {
    val user = realm.where<User>(User::class.java).findFirst()!!

    return user.expenses
}

fun getCategories(realm: Realm): RealmResults<Category> {
    return realm.where(Category::class.java).findAll()!!
}

fun getLoans(realm: Realm): RealmList<Loan> {
    val user = realm.where<User>(User::class.java).findFirst()!!

    return user.loans
}

// stats and stuff

fun getTotalExpense(from: Date? = null, to: Date? = null) {
    val expense = getExpenses(Realm.getDefaultInstance())

    if (from == null || to == null) {
        val sum = expense.sum("amount")
        Log.d("total expenses", sum.toString())
    }
    else {
        val sum = expense.where().greaterThanOrEqualTo("date", from)
                .lessThanOrEqualTo("date", to).findAll()!!.sum("amount")
        Log.d("total expenses", sum.toString())
    }
}
