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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.schedule.DAOs.TaskDAO
import com.example.schedule.databinding.FragmentMainPageBinding
import com.example.schedule.models.Task
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.util.*

class MainPage :Fragment() {
     var man =Register();
    private lateinit var db: AppDatabase
    private lateinit var tasks: MutableList<Task>
    private lateinit var adapter: TaskAdapter
    // TODO: Rename and change types of parameters


    override fun onDestroyView() {
        super.onDestroyView()
        db = Room.databaseBuilder(
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
                        //remove all the tasks and add new ones
                        tasks.removeIf { true }
                        val calInst = Calendar.getInstance()
                        calInst.time = horizontalCalendar.selectedDate.time
                        calInst.add(Calendar.DATE, 1)
                        tasks.addAll(db.taskDao().getAllBetweenDates(horizontalCalendar.selectedDate.time, calInst.time))
                        adapter.notifyDataSetChanged()
                    }
                }


//      this block is for navigation to registration and login if the user dose not already
//        i added false to the if conditions for now but when we integrate database the conditions will be replaced
//        var arg=RegisterArgs

        db = Room.databaseBuilder(
                requireActivity(), AppDatabase::class.java, "schedule-db"
        ).allowMainThreadQueries().build()
        val user = db.userDao().getAll()
        if(user.isNotEmpty() && user.first().askOnStart == true && user.first().hasLoggedIn == false){
            Log.w("MainPage", "Got to this bit")
            findNavController().navigate(R.id.login2)
        }else if (user.isEmpty()){
            findNavController().navigate(R.id.register2)
        } else {
            Log.w("MainPage", "So we got to the else")
        }


        val taskListView = binding.TaskList
        val taskDao = db.taskDao()
        populateDB(taskDao)
        val calInst = Calendar.getInstance()
        calInst.time = horizontalCalendar.selectedDate.time
        calInst.add(Calendar.DATE, 1)
        tasks = taskDao.getAllBetweenDates(horizontalCalendar.selectedDate.time, calInst.time).toMutableList()
        adapter = TaskAdapter(tasks)
        taskListView.adapter = adapter
        taskListView.layoutManager = LinearLayoutManager(requireContext())

        // this block is for navigation to schedule and profile

        binding.profile.setOnClickListener{
//            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_profile2)
            it.findNavController().navigate(R.id.action_mainPage_to_profile)
            Toast.makeText(activity, "New profile: ", Toast.LENGTH_LONG).show();
        }
        binding.fab.setOnClickListener{
            Toast.makeText(activity, "shedule ", Toast.LENGTH_LONG).show();
            it.findNavController().navigate(R.id.action_mainPage_to_schedule)
//            Navigation.createNavigateOnClickListener(R.id.action_mainPage_to_schedule)
        }



        // this return the main page view object
        return binding.root

    }

    override fun onStart() {
        super.onStart()

    }

    private fun populateDB(taskDao: TaskDAO) {
        val tasks = taskDao.getAll()
        if (tasks.isEmpty()){
            val tasksList = mutableListOf<Task>()
            val currDate = Calendar.getInstance()
            currDate.add(Calendar.DATE, -3)
            (1..5).forEach { _ ->
                currDate.add(Calendar.DATE, 1)
                tasksList.addAll(Task.createTasks(10, currDate.time))
            }
            taskDao.insertTasks(tasksList)
        }
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
