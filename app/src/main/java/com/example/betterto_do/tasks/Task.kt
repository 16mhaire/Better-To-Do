package com.example.betterto_do.tasks

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = CONSTANTS.DATABASE_TABLE)
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val taskName: String,
    val taskDescription: String?,
    val taskPriority: Priority,
    val taskDueDate: LocalTime? = null,
    val taskCompleted: Boolean = false,
)

object CONSTANTS {
    const val DATABASE_TABLE = "task_table"
}

//Feel free to edit/delete/change everything below this line. I was just testing
fun createNewTask(
    taskName: String,
    taskDescription: String?,
    taskPriority: Priority,
    taskDueDate: LocalTime? = null,
    taskCompleted: Boolean = false
): Task {
    return Task(
        taskName = taskName,
        taskDescription = taskDescription,
        taskPriority = taskPriority,
        taskDueDate = taskDueDate,
        taskCompleted = taskCompleted
    )
}

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction(): Action{
    return when(this){
        "ADD" -> Action.ADD
        "UPDATE" -> Action.UPDATE
        "DELETE" -> Action.DELETE
        "DELETE_ALL" -> Action.DELETE_ALL
        "UNDO" -> Action.UNDO
        "NO_ACTION" -> Action.NO_ACTION
        else -> Action.NO_ACTION
    }
}