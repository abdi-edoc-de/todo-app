package com.example.schedule

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentSearchBinding
import com.example.schedule.models.Task
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class search : Fragment() {

    private lateinit var adapter: TaskAdapter
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View?{
        val binding: FragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        val taskList = binding.searchRecycler
        val tasks: MutableList<Task> = mutableListOf()
        GlobalScope.launch {
            val db = AppDatabase.getDatabase(requireContext())
            tasks.addAll(db.taskDao().getAllStartingWith("%"))
            adapter = TaskAdapter(tasks, requireContext())
            requireActivity().runOnUiThread {
                taskList.adapter = adapter
                taskList.layoutManager = LinearLayoutManager(requireContext())
            }
        }

        binding.inputEmail.doAfterTextChanged {
            GlobalScope.launch {
                val db = AppDatabase.getDatabase(requireContext())
                tasks.removeIf { true }
                tasks.addAll(db.taskDao().getAllStartingWith(it.toString() + "%"))
                adapter = TaskAdapter(tasks, requireContext())
                requireActivity().runOnUiThread {
                    taskList.adapter = adapter
                    taskList.layoutManager = LinearLayoutManager(requireContext())
                }
            }
        }

        return binding.root
    }
}