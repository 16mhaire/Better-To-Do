package com.example.betterto_do.tasks

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDAO: TaskDAO
    abstract val subTaskDAO: TaskDAO
}