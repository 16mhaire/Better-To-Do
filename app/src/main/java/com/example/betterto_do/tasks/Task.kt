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
    const val DATABASE_NAME = "task_database"

    const val LIST_SCREEN_ROUTE = "list/{action}"
    const val TASK_SCREEN_ROUTE = "task/{taskID}"
    const val SPLASH_SCREEN_ROUTE = "splash/"
    const val LOGIN_SCREEN_ROUTE = "login/"


    const val LIST_SCREEN_ARG_KEY = "action"
    const val TASK_SCREEN_ARG_KEY = "taskID"
    const val MAX_TITLE_LENGTH = 40

    const val PREFERENCE_NAME = "todo_preference"
    const val PREFERENCE_KEY = "sort_order"
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