package com.example.schedule.models

import android.icu.util.IslamicCalendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.time.LocalDate
import java.util.*

@Entity
data class Task(
    @PrimaryKey val uid: UUID,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "start_date") var startDate: Date?,
    @ColumnInfo(name = "end_date") var endDate: Date?,
    @ColumnInfo(name = "notes") val notes: String?
) {

    companion object {
        var id = 0
        fun createTasks(n: Int, startDate: Date): List<Task> {
            return (1..n).map {
                val currDate = Calendar.getInstance()
                currDate.time = startDate
                currDate.add(Calendar.HOUR, 3)
                Task(
                    UUID.randomUUID(),
                    "Task ${id++}",
                    startDate,
                    currDate.time,
                    "These are trying times right now $id"
                )
            }
        }
        fun newID() = id++
    }
}