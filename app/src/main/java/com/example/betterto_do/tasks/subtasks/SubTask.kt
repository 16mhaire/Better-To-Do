package com.example.betterto_do.tasks.subtasks

import com.example.betterto_do.tasks.Priority
import com.example.betterto_do.tasks.CONSTANTS
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = CONSTANTS.DATABASE_TABLE)
data class SubTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subTaskName: String,
    val subTaskDescription: String?,
    val subTaskPriority: Priority,
    val subTaskDueDate: LocalTime? = null,
    val subTaskCompleted: Boolean = false,
)