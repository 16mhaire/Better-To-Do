package com.example.betterto_do

//This is imported to use the LocalTime for duedate
import java.time.LocalTime

//Class to handle tasks
class TaskToDo {
    var taskName: String = ""
    //variable for description (may or may not keep this)
    var taskInfo: String = ""
    //This should be able to set due date to the time on the user device
    var dueDate: LocalTime? = null
    //To track task completion and will start as "not completed"
    var taskCompleted: Boolean = false
}