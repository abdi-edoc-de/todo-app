package com.example.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.models.Task
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskAdapter(private val taskLists: List<Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
        val titleView = itemView.findViewById<TextView>(R.id.taskTitle)
        val dateView = itemView.findViewById<TextView>(R.id.taskDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val taskView = inflater.inflate(R.layout.task_item, parent, false)
        return ViewHolder(taskView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskItem: Task = taskLists[position]
        // Set item views based on your views and data model
        val textView = holder.titleView
        textView.text = taskItem.title
        val dateView = holder.dateView
        val timeFormat = SimpleDateFormat("hh:mm aa")
        dateView.text = "${timeFormat.format(taskItem.startDate)}-${timeFormat.format(taskItem.endDate)}"
    }

    override fun getItemCount(): Int {
        return taskLists.size
    }

}