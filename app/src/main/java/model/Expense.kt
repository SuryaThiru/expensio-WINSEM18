package model

import io.realm.RealmObject
import java.util.*

/**
 * Created by surya on 3/19/18.
 */

// available categories
val GROCERY = "grocery"
val BILLS = "bills"

class Expense(
        var amount: Int = 0,
        var remarks: String = "some remarks",
        var category: String = GROCERY,
        var date: Date = Date()
) : RealmObject() {

}