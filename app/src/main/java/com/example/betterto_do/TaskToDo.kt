package com.example.betterto_do

import java.time.LocalTime

//Class to handle tasks
class TaskToDo {
    //variable for task title/name
    var taskName: String = ""
    //variable for description that can be removed if we decide it's not needed
    var taskInfo: String = ""
    //This should be able to set due date to the time on the user device
    var dueDate: LocalTime? = null
}