package com.example.schedule

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.schedule.databinding.FragmentProfileBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.philjay.circledisplay.CircleDisplay

//import com.example.shedule.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class Profile : Fragment() {
    // TODO: Rename and change types of parameters

private lateinit var binding:FragmentProfileBinding;
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =DataBindingUtil.inflate(
            inflater, R.layout.fragment_profile, container, false
        )
//        val arg=MainPageArgs.fromBundle(arguments!!)
//        Toast.makeText(context, arg.name, Toast.LENGTH_LONG).show()



//        var chart: PieChart =binding.pi;
//        var arr=ArrayList<PieEntry>()
//        arr.add(PieEntry(200.0F, "asd"))
//        arr.add(PieEntry(20.0F, "asd"))
//        arr.add(PieEntry(240.0F, "asd"))
//
//        var pieDataSet: PieDataSet = PieDataSet(arr, "dont now shite about this")
//        pieDataSet.valueTextColor= Color.BLACK
//       pieDataSet.colors= listOf(
//           Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0),
//           Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)
//       )
//        pieDataSet.valueTextSize=16f
//        var pieData= PieData(pieDataSet)
//        chart.data=pieData
//        chart.centerText="man"
//        chart.animate()
//


//        the left chart

        var chart1: PieChart =binding.pi2;
        var arr2=ArrayList<PieEntry>()
        arr2.add(PieEntry(200.0F))
        arr2.add(PieEntry(110.0F))

        var pieDataSet2: PieDataSet = PieDataSet(arr2,"")
        pieDataSet2.valueTextColor= Color.BLACK
        pieDataSet2.colors= listOf(
            Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0),
            Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)
        )
        pieDataSet2.valueTextSize=16f
        var pieData2= PieData(pieDataSet2)
        chart1.setBackgroundColor(Color.TRANSPARENT)
        chart1.data=pieData2
        chart1.centerText="20%"
        chart1.setDrawHoleEnabled(true);
        chart1.setHoleColor(Color.TRANSPARENT);
        chart1.description.isEnabled = false

        chart1.legend.isEnabled=false;
        chart1.setDrawEntryLabels(false)
        chart1.setDrawMarkers(false)
        chart1.setDrawSliceText(false)
        chart1.animate()




//the green ring chart
        val cd:CircleDisplay = binding.circleDisplay
        cd.setAnimDuration(2000)
        cd.setValueWidthPercent(55f)
        cd.setTextSize(18f)
        cd.setColor(Color.GREEN)
        cd.setDrawText(true)
        cd.setDrawInnerCircle(true)
        cd.setFormatDigits(1)
        cd.setTouchEnabled(false)
//        cd.setSelectionListener(requireActivity())
        cd.setUnit("%")
        cd.setStepSize(0.5f)
        // cd.setCustomText(...); // sets a custom array of text
        // cd.setCustomText(...); // sets a custom array of text
        cd.showValue(75f, 100f, true)





        return binding.root

    }



}


