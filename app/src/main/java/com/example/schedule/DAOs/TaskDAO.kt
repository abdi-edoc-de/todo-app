package com.example.schedule.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.schedule.models.Task
import java.util.*

@Dao
interface TaskDAO {

    @Insert
    fun insertTask(task: Task)

    @Insert
    fun insertTasks(tasks: List<Task>)

    @Update
    fun updateTask(task: Task)

    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE start_date BETWEEN :startDate AND :endDate")
    fun getAllBetweenDates(startDate: Date, endDate: Date): List<Task>

}