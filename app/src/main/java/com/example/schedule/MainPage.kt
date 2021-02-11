package com.example.schedule


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.schedule.databinding.FragmentMainPageBinding
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.util.*


//import com.example.shedule.databinding.FragmentMainPageBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [MainPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainPage :Fragment() {
    // TODO: Rename and change types of parameters

//    private var man:Boolean=false;
//    var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentMainPageBinding =DataBindingUtil.inflate(
            inflater, R.layout.fragment_main_page, container, false
        )


                val startDate = Calendar.getInstance()
                startDate.add(Calendar.MONTH, -3)

                val endDate = Calendar.getInstance()
                endDate.add(Calendar.MONTH, 3)

                val horizontalCalendar: HorizontalCalendar = HorizontalCalendar.Builder(
                    binding.root,
                    R.id.calendarView
                )
                .range(startDate, endDate)
                        .datesNumberOnScreen(7)
                        .build()
                horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onDateSelected(date: Calendar?, position: Int) {
                        Toast.makeText(activity,date.toString(),Toast.LENGTH_LONG).show()
                        //do something
                    }
                }

/* ends after 1 month from now */

/* ends after 1 month from now */


        // initialize it and attach a listener
//        picker.setListener(this)
//            .setDays(20)
//            .setOffset(10)
//            .setDateSelectedColor(Color.DKGRAY)
//            .setDateSelectedTextColor(Color.WHITE)
//            .setMonthAndYearTextColor(Color.DKGRAY)
//            .setTodayButtonTextColor(Color.parseColor("#FF0000"))
//            .setTodayDateTextColor(Color.parseColor("#FF0000"))
//            .setTodayDateBackgroundColor(Color.GRAY)
//            .setUnselectedDayTextColor(Color.DKGRAY)
//            .setDayOfWeekTextColor(Color.DKGRAY)
//            .setUnselectedDayTextColor(Color.parseColor("#FF0000"))
//            .showTodayButton(false)
//            picker.init();
//        picker.backgroundColor = Color.LTGRAY
//        picker.setDate(DateTime().plusDays(4))
        // Inflate the layout for this fragment


        val man=false;
        if (man){
            return inflater.inflate(R.layout.fragment_login, container, false)
        }else if(man){
            return inflater.inflate(R.layout.fragment_register, container, false)
        }
        binding.profile.setOnClickListener{
//            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_profile2)
            it.findNavController().navigate(R.id.action_mainPage_to_profile)
            Toast.makeText(activity, "New profile: ", Toast.LENGTH_LONG).show();
        }
        binding.schedul.setOnClickListener{
            Toast.makeText(activity, "profile ", Toast.LENGTH_LONG).show();
            it.findNavController().navigate(R.id.action_mainPage_to_schedule)
//            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_schedule)
        }




        return binding.root

    }


}


