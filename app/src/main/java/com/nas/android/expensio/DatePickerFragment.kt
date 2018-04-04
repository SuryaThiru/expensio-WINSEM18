package com.nas.android.expensio


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class DatePickerFragment(var date: Date? = null, var tview: TextView?) : DialogFragment(), DatePickerDialog.OnDateSetListener {

     override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity, this, year, month, day)

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
         //To change body of created functions use File | Settings | File Templates.
        
        date?.year = year - 1900
        date?.month = month
        date?.date = dayOfMonth

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        tview?.text = dateFormat.format(date)

        Log.i("test ondateset ", dayOfMonth.toString() + " " + year.toString())
    }

}// Required empty public constructor
