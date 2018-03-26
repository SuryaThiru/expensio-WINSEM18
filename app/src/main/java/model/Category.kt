package model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by surya on 3/26/18.
 */
open class Category(
        @PrimaryKey var name: String = "name",
        var color: String = "hexcode"
) : RealmObject()
