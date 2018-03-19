package model

import io.realm.RealmList
import io.realm.RealmObject

/**
 * Created by surya on 3/19/18.
 */
class User(
        var name: String,
        var budget: Int
) : RealmObject() {
    // fancy one-to-many definitions
    var expenses: RealmList<Expense> = RealmList()
    var loans: RealmList<Loan> = RealmList()
}