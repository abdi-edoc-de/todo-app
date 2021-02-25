package com.example.schedule

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.schedule.DAOs.Converters
import com.example.schedule.DAOs.TaskDAO
import com.example.schedule.DAOs.UserDAO
import com.example.schedule.models.Task
import com.example.schedule.models.User

@Database(entities = [User::class, Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun taskDao(): TaskDAO
}