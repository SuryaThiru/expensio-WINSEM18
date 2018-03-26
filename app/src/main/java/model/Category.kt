package model

import io.realm.RealmObject

/**
 * Created by surya on 3/26/18.
 */
open class Category(
        var name: String = "name",
        var color: String = "hexcode"
) : RealmObject()
