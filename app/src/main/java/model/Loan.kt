package model

import io.realm.RealmObject
import java.util.*
/**
 * Created by surya on 3/19/18.
 */


// types of loaning involved
val LOAN = true
val DEBT = false

open class Loan(
        var amount: Int = 0,
        var remark: String = "some remark",
        var type: Boolean = DEBT,
        var actor: String = "some name", //name of the debtor (or) creditor
        var returnDate: Date? = null  //null if it's a credit

) : RealmObject()