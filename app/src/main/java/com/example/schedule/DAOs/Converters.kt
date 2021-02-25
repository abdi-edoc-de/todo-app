package com.example.schedule.DAOs

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?) = value?.let{ Date(it) }

    @TypeConverter
    fun dateToTimestamp(value: Date?) = value?.time

    @TypeConverter
    fun uuidToString(value: UUID?) = value?.toString()

    @TypeConverter
    fun fromString(value: String?) = value?.let { UUID.fromString(it) }
}