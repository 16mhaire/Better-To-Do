package com.example.betterto_do.models

import androidx.room.Entity
import androidx.room.PrimaryKey

const val DATABASE_TABLE = "task_table"
@Entity(tableName = DATABASE_TABLE)
data class SubTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String?,
    val subTaskCompleted: Boolean = false,
)