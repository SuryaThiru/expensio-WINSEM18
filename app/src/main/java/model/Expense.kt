package model

import io.realm.RealmObject
import java.util.*

/**
 * Created by surya on 3/19/18.
 */

enum class Category {
    // TODO add categories
}

class Expense(
        var amount: Int,
        var remarks: String,
        var category: String,
        var date: Date
) : RealmObject() {

}