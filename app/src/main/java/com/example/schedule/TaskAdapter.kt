package com.example.schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.models.Task
import java.text.SimpleDateFormat


class TaskAdapter(private val taskLists: List<Task>, private val context: Context): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    private lateinit var card:LinearLayout;

    inner class ViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
         val subtaskConfirm : LinearLayout = itemView.findViewById(R.id.subCinfirmation);
        val titleView: TextView = itemView.findViewById<TextView>(R.id.taskTitle)
        val dateView: TextView = itemView.findViewById<TextView>(R.id.taskDate)

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
        card=holder.subtaskConfirm
        val textView = holder.titleView
        textView.text = taskItem.title
        val dateView = holder.dateView
        val timeFormat = SimpleDateFormat("hh:mm aa")
        dateView.text = "${timeFormat.format(taskItem.startDate)}-${timeFormat.format(taskItem.endDate)}"
        card.setOnClickListener{
            var popUp: DialogFragment = DialogFragment()
            popUp.show((context as Fragment).parentFragmentManager, "dont")
        }
    }

    override fun getItemCount(): Int {
        return taskLists.size
    }
    fun getCard():LinearLayout {
        return card
    }

}