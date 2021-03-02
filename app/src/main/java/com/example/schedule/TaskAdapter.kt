package com.example.schedule

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
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
        dateView.text = "${timeFormat.format(taskItem.startDate!!)}-${timeFormat.format(taskItem.endDate!!)}"
        card.setOnClickListener{
            val v: View =LayoutInflater.from(context).inflate(R.layout.row_for_confirmation, null, false)
            var lay=LayoutInflater.from(context).inflate(R.layout.fragment_subtask_confirmation,null,false)
            var layoutList:LinearLayout=lay.findViewById(R.id.layoutList);
            layoutList.addView(v)
            var myDialog: Dialog = Dialog(context);

            myDialog.setContentView(lay);
            myDialog.getWindow()?.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

        }
    }

    override fun getItemCount(): Int {
        return taskLists.size
    }
//    fun getCard():LinearLayout {
//        return card
//    }

}