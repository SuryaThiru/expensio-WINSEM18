package com.nas.android.expensio

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.*
import kotlinx.android.synthetic.main.activity_view_spend_trends.*
import model.getTotalByCategory
import model.getTotalByDate
import java.util.*
import kotlin.collections.ArrayList

class ViewSpendTrends : AppCompatActivity() {
    var categoryTrends: MutableMap<String, Int> = mutableMapOf()
    var dateTrends: MutableMap<String, Int> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_spend_trends)

        categoryTrends = getTotalByCategory()
        dateTrends = getTotalByDate()

        setUpPieChartData()
        setUpBarChartData()
    }

    private fun setUpPieChartData() {
        val yVals = ArrayList<PieEntry>()

        for ((key, value) in categoryTrends) {
            yVals.add(PieEntry(value.toFloat(), key))
        }

        val dataSet = PieDataSet(yVals, "Category wise trend")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.RED)
        colors.add(Color.BLUE)
        colors.add(Color.GRAY)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)


        dataSet.setColors(colors)
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.centerTextRadiusPercent = 0f
        pieChart.isDrawHoleEnabled = true
        pieChart.legend.isEnabled = false
        pieChart.description.isEnabled = false
    }

    private fun setUpBarChartData() {
        val yVals = ArrayList<BarEntry>()
        val labels = ArrayList<String>()
        var i = 0f

        for ((key, value) in dateTrends) {
            yVals.add(BarEntry(++i, value.toFloat(), key))
            labels.add(key)
        }

        val colors = java.util.ArrayList<Int>()
        colors.add(Color.RED)
        colors.add(Color.BLUE)
        colors.add(Color.GRAY)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)

        var dataSet = BarDataSet(yVals, "Date wise bar graph")
        dataSet.colors = colors
        var data = BarData(dataSet)
        barChart.data = data
        barChart.legend.isEnabled = false
        barChart.setDrawGridBackground(false)
        barChart.description = null
        barChart.invalidate()
    }
}
