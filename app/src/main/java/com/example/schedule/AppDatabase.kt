package com.example.schedule

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.schedule.DAOs.UserDAO
import com.example.schedule.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun userDao(): UserDAO
}