package com.example.betterto_do.listtasks

import androidx.lifecycle.ViewModel
import com.example.betterto_do.TaskRepository
import com.example.betterto_do.models.Task

// ViewModel for ListFragment
class ListFragmentViewModel: ViewModel() {
    // Task repository instance
    private val taskRepository = TaskRepository.get()

    // LiveData for the list of tasks
    val taskList = taskRepository.getAllTasks()

    // LiveData for the count of tasks
    var taskListSize = taskRepository.getTaskCount()

    // Method to delete a task
    fun deleteItem(task: Task){
        taskRepository.deleteTask(task)
    }
}