package model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by surya on 3/19/18.
 */
open class User(
        @PrimaryKey var name: String = "John Doe",
        var budget: Int = 0,
        var budgetStartDate: Date? = null,
        var budgetEndDate: Date? = null,
        var expenses: RealmList<Expense> = RealmList(), // fancy one-to-many definitions
        var loans: RealmList<Loan> = RealmList()
) : RealmObject()
