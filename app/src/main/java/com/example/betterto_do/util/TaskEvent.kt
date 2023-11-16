package com.example.betterto_do.util

import com.example.betterto_do.tasks.Task

sealed class TaskEvent{
    //This will handle the event to delete a selected task
    data class OnDeleteTaskClick(val task: Task): TaskEvent()
    //This will be the event to toggle if the task is completed or not
    data class OnDoneChange(val task: Task, val taskCompleted: Boolean): TaskEvent()
    //This will be an event to undo task delete if undo is clicked
    object OnUndoDeleteTaskClick: TaskEvent()
    //This will handle the event to open task information when clicked
    data class OnTaskClick(val task: Task): TaskEvent()
    //This will handle task creation event
    object OnAddTaskClick: TaskEvent()
}
