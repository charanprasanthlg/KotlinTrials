package com.example.kotlintrials.charts

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.ToggleButton
import com.example.kotlintrials.R
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class ChartsActivity : AppCompatActivity() {

    lateinit var candleStickChart: CandleStickChart
    lateinit var lineChart: LineChart
    lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts)
        candleStickChart = findViewById(R.id.candleStickChart)
        lineChart = findViewById(R.id.lineChart)
        radioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if (checkedId == R.id.radioButton_line) {
                    candleStickChart.visibility = View.GONE
                    lineChart.visibility = View.VISIBLE
                    lineChart.animateXY(2000,2000)
                } else if (checkedId == R.id.radioButton_candleStick) {
                    lineChart.visibility = View.GONE
                    candleStickChart.visibility = View.VISIBLE
                    candleStickChart.animateXY(2000,2000)
                }
            }
        })

        addCandleStickChart()
        addLineChart()
    }

    private fun addCandleStickChart() {

        val xValue = ArrayList<String>()
        xValue.add("01:00")
        xValue.add("02:00")
        xValue.add("03:00")
        xValue.add("04:00")
        xValue.add("05:00")
        xValue.add("06:00")
        xValue.add("07:00")
        xValue.add("08:00")
        xValue.add("09:00")
        xValue.add("10:00")
        xValue.add("11:00")
        xValue.add("12:00")
        xValue.add("13:00")
        xValue.add("14:00")
        xValue.add("15:00")
        xValue.add("16:00")
        xValue.add("17:00")
        xValue.add("18:00")
        xValue.add("19:00")
        xValue.add("20:00")
        xValue.add("21:00")
        xValue.add("22:00")
        xValue.add("23:00")
        xValue.add("24:00")

        val candleStickEntry = ArrayList<CandleEntry>()

        val marketSizeVal = 24

        for (i in 0 until marketSizeVal) {
            val mul: Int = marketSizeVal + 10
            val value = (Math.random() * 100).toFloat() + mul
            val high = (Math.random() * 15).toFloat() + 9f
            val low = (Math.random() * 15).toFloat() + 8f
            val open = (Math.random() * 6).toFloat() + 1f
            val close = (Math.random() * 6).toFloat() + 1f

            val odd = 1 % 2 != 0

            candleStickEntry.add(
                CandleEntry(
                    (i + 1).toFloat(),
                    value + high,
                    value - low,
                    if (!odd) value + open else value - open,
                    if (!odd) value + close else value - close
                )
            )
        }

//        candleStickEntry.add(CandleEntry(0, 225.0f, 219.84f, 224.94f, 226.41f))
//        candleStickEntry.add(CandleEntry(1, 228.0f, 222.14f, 223.80f, 212.41f))
//        candleStickEntry.add(CandleEntry(2, 226.84f, 217.84f, 222.9f, 229.41f))
//        candleStickEntry.add(CandleEntry(3, 222.0f, 216.12f, 214.14f, 216.41f))
//        candleStickEntry.add(CandleEntry(4, 226.56f, 212.84f, 224.33f, 229.41f))
//        candleStickEntry.add(CandleEntry(5, 221.12f, 269.84f, 228.14f, 214.41f))
//        candleStickEntry.add(CandleEntry(6, 229.96f, 237.84f, 224.94f, 246.41f))

        val candleDataSet = CandleDataSet(candleStickEntry, "first")
        candleDataSet.color = Color.rgb(80, 80, 80)
        candleDataSet.shadowColor = Color.rgb(0, 255, 0)
        candleDataSet.shadowWidth = 1f

        candleDataSet.decreasingColor = Color.rgb(255, 0, 0)
        candleDataSet.decreasingPaintStyle = Paint.Style.FILL

        candleDataSet.increasingColor = Color.rgb(0, 255, 0)
        candleDataSet.increasingPaintStyle = Paint.Style.FILL

        val candleData = CandleData(candleDataSet)
        candleStickChart.data = candleData
        candleStickChart.setBackgroundColor(resources.getColor(R.color.white))
        candleStickChart.animateXY(3000, 3000)

        val xval = candleStickChart.xAxis
        xval.position = XAxis.XAxisPosition.BOTTOM
        xval.setDrawGridLines(true)
    }

    private fun addLineChart() {
        val lineList = ArrayList<Entry>()

        for(i in (10..100 step 5)){
            lineList.add(Entry(i.toFloat(),((100..1000).random()).toFloat()))
        }

        val lineDataSet = LineDataSet(lineList, "Count")
        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor = Color.BLUE
        lineDataSet.valueTextSize = 13f
        lineDataSet.setDrawFilled(true)
        lineChart.animateXY(3000, 3000)
        lineChart.setBackgroundColor(Color.WHITE)
    }
}