package com.nas.android.expensio

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.nas.android.expensio.R.layout.new_user_prompt
import io.realm.Realm
import kotlinx.android.synthetic.main.new_user_prompt.*
import kotlinx.android.synthetic.main.new_user_prompt.view.*
import model.createUser

class NewUserFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater

        val view = inflater.inflate(new_user_prompt, null)
        builder.setView(view)

        view.fab_create_new_user.setOnClickListener {
            val realm = Realm.getDefaultInstance()
            createUser(realm, view.input_new_user_name.text.toString())

            this.dismiss()
        }

        return builder.create()
    }
}
