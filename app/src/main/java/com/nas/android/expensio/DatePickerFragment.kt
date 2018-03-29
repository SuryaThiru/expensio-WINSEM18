package com.nas.android.expensio


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.widget.DatePicker
import java.text.DateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class DatePickerFragment(var date: Date? = null) : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private lateinit var calendar:Calendar


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
        date?.year = year
        date?.month = month
        date?.date = dayOfMonth

        Log.i("test ondateset ", dayOfMonth.toString())
    }

    fun formatDate(year:Int, month:Int, day:Int):String{
        // Create a Date variable/object with user chosen date
        calendar.set(year, month, day, 0, 0, 0)
        val chosenDate = calendar.time

        // Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }

}// Required empty public constructor
