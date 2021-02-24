package com.example.schedule


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.schedule.databinding.FragmentMainPageBinding
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.util.*

class MainPage :Fragment() {
     var man =Register();
    // TODO: Rename and change types of parameters


    override fun onDestroyView() {
        super.onDestroyView()
        val db = Room.databaseBuilder(
            requireActivity(), AppDatabase::class.java, "schedule-db"
        ).allowMainThreadQueries().build()
        val userDAO = db.userDao()
        val user = userDAO.getAll().firstOrNull()
        if (user != null) {
            user.hasLoggedIn = false
            userDAO.updateUser(user)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentMainPageBinding =DataBindingUtil.inflate(
                inflater, R.layout.fragment_main_page, container, false
        )





//        this is block for the horizontal date picker  library you can check the documentation here is the link https://github.com/Mulham-Raee/Horizontal-Calendar
        // another ooptin for horizontal date picker link is https://github.com/jhonnyx2012/HorizontalPicker
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
                        Toast.makeText(activity, date.toString(), Toast.LENGTH_LONG).show()
                        //do something
                    }
                }


//      this block is for navigation to registration and login if the user dose not already
//        var arg=RegisterArgs
        val db = Room.databaseBuilder(
                requireActivity(), AppDatabase::class.java, "schedule-db"
        ).allowMainThreadQueries().build()
        val user = db.userDao().getAll()
        if(user.isNotEmpty() && user.first().askOnStart == true && user.first().hasLoggedIn == false){
            findNavController().navigate(R.id.login2)
            Log.w("MainPage", "Got to this bit")
        }else if (user.isEmpty()){
            findNavController().navigate(R.id.register2)
        } else {
            Log.w("MainPage", "So we got to the else")
        }




        // this block is for navigation to schedule and profile

//        binding.profile.setOnClickListener{
////            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_profile2)
//            it.findNavController().navigate(MainPageDirections.actionMainPageToProfile("abdi"))
//            Toast.makeText(activity, "New profile: ", Toast.LENGTH_LONG).show();
//        }
//        binding.schedul.setOnClickListener{
//            Toast.makeText(activity, "profile ", Toast.LENGTH_LONG).show();
//            it.findNavController().navigate(R.id.action_mainPage_to_schedule)
////            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_schedule)
//        }



        // this return the main page view object
        return binding.root

    }

    private fun setActionBarTitle(yourTitle: Any) {

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
