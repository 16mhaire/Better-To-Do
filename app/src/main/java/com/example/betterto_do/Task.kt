package com.example.betterto_do

//This is imported to use the LocalTime for due date
import java.time.LocalTime
//Imported for task id's
import java.util.UUID

//Class to handle tasks
class TaskToDo {
    //Class Properties
    var taskName: String = ""
    //variable for description (may or may not keep this)
    var taskDescription: String = ""
    //This should be able to set due date to the time on the user device
    var taskDueDate: LocalTime? = null
    //To track task completion and will start as "not completed" or false
    var taskCompleted: Boolean = false
    //Adding an id to track the task when it is in a list
    var taskID: UUID = UUID.randomUUID()

    //Class Functions
    fun createNewTask(newTaskName: String): String {
        taskName = newTaskName
        return taskName
    }
    fun changeTaskDescription(newTaskDescription: String): String {
        taskDescription = newTaskDescription
        return taskDescription
    }
    fun changeTaskDueDate(newTaskDueDate: LocalTime?): LocalTime? {
        taskDueDate = newTaskDueDate
        return taskDueDate
    }
    fun changeTaskCompleted(newTaskCompleted: Boolean): Boolean {
        taskCompleted = newTaskCompleted
        return taskCompleted
    }

    //Inner Class to handle SubTasks
    inner class SubTask {
        var subTaskName: String = ""
        //variable for description (may or may not keep this)
        var subTaskDescription: String = ""
        //This should be able to set due date to the time on the user device
        var subTaskDueDate: LocalTime? = null
        //To track task completion and will start as "not completed" or false
        var subTaskCompleted: Boolean = false
        //Adding an id to track the task when it is in a list
        var subTaskID: UUID = UUID.randomUUID()

        //SubTask Class Functions
        fun createNewSubTask(newSubTaskName: String): String {
            subTaskName = newSubTaskName
            return subTaskName
        }
        fun changeSubTaskDescription(newSubTaskDescription: String): String {
            subTaskDescription = newSubTaskDescription
            return subTaskDescription
        }
        fun changeSubTaskDueDate(newSubTaskDueDate: LocalTime?): LocalTime? {
            subTaskDueDate = newSubTaskDueDate
            return subTaskDueDate
        }
        fun changeSubTaskCompleted(newSubTaskCompleted: Boolean): Boolean {
            subTaskCompleted = newSubTaskCompleted
            return subTaskCompleted
        }
    }
}