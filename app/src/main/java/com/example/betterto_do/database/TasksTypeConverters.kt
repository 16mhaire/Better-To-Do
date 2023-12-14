package com.example.betterto_do.database

import androidx.room.TypeConverter
import java.util.*

// Type converters for Date and UUID in Room
class TasksTypeConverters {
    // Converts Date to Long
    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }

    // Converts Long to Date
    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date?{
        return millisSinceEpoch?.let{
            Date(it)
        }
    }

    // Converts UUID to String
    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    // Converts String to UUID
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

}