package com.example.betterto_do

//This is imported to use the LocalTime for due date
import java.time.LocalTime
//Imported for task id's
import java.util.UUID

//Class to handle tasks
class TaskToDo {
    var taskName: String = ""
    //variable for description (may or may not keep this)
    var taskInfo: String = ""
    //This should be able to set due date to the time on the user device
    var dueDate: LocalTime? = null
    //To track task completion and will start as "not completed" or false
    var taskCompleted: Boolean = false
    //Adding an id to track the task when it is in a list
    var taskID: UUID = UUID.randomUUID()
}