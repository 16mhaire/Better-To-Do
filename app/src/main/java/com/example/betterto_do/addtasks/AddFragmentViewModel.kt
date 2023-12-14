package com.example.betterto_do.addtasks

import androidx.lifecycle.ViewModel
import com.example.betterto_do.TaskRepository
import com.example.betterto_do.models.Task

// ViewModel for AddFragment
class AddFragmentViewModel: ViewModel() {
    // Current task being edited
    var currentTask: Task = Task()

    // Task repository instance
    private val taskRepository = TaskRepository.get()

    // Method to add a task
    fun addTask(task: Task){
        taskRepository.addTask(task)
    }

}