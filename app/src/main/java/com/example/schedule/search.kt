package com.example.schedule

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.schedule.databinding.FragmentSearchBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class search : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View?{val binding: FragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)



        var chart=binding.pi2
        addData(chart)
        return binding.root
    }
    private fun addData(chart1: PieChart) {

        var arr2=ArrayList<PieEntry>()
        arr2.add(PieEntry(200.0F))//addin values for charts
        arr2.add(PieEntry(110.0F))//addin values for charts

        var pieDataSet2: PieDataSet = PieDataSet(arr2,"")
        pieDataSet2.valueTextColor= Color.WHITE
        pieDataSet2.colors= ColorTemplate.COLORFUL_COLORS.toList()

        pieDataSet2.valueTextSize=16f
        var pieData2= PieData(pieDataSet2)
        chart1.setBackgroundColor(Color.TRANSPARENT)
        chart1.data=pieData2
        chart1.centerText="20%"
        chart1.setCenterTextColor(Color.BLACK)
        chart1.setDrawHoleEnabled(true);
        chart1.setHoleColor(Color.TRANSPARENT);
        chart1.description.isEnabled = false
        chart1.setDrawSlicesUnderHole(false)
        chart1.data.setDrawValues(false)


        chart1.legend.isEnabled=false;
        chart1.setDrawEntryLabels(false)
        chart1.setDrawMarkers(false)
        chart1.animate()

    }
}