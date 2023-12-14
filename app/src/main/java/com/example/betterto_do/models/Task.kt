package com.example.betterto_do.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

// Data class representing a task with Room annotations
@Entity
data class Task(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var title: String = "",
                var description: String = "",
                var dueDate: Date = Date(),
                var priorty: Int = 0,
                var notification: Boolean = false,
                var notificationID: String = "")