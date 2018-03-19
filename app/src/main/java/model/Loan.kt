package model

import io.realm.RealmObject
import java.util.*
/**
 * Created by surya on 3/19/18.
 */

enum class LoanType {
    LOAN, DEBT
}

class Loan(
        var amount: Int,
        var remark: String,
        var type: LoanType,
        var actor: String, //name of the debtor (or) creditor
        var returnDate: Date?  //null if it's a credit

) : RealmObject() {

}