package com.example.schedule.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User(
        @PrimaryKey val uid: Int?,
        @ColumnInfo(name = "username") val username: String?,
        @ColumnInfo(name = "pin") val pin: Int?,
        @ColumnInfo(name="ask_on_start") val askOnStart: Boolean?,
        @ColumnInfo(name="has_logged_in") var hasLoggedIn: Boolean?
)