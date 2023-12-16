package com.example.betterto_do.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.betterto_do.models.SubTask

@Database(entities = [SubTask::class], version = 1, exportSchema = false)
abstract class SubTaskDatabase: RoomDatabase() {
    abstract val subTaskDAO: SubTaskDAO
}