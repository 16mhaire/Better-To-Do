package com.example.betterto_do.edittask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.betterto_do.TaskRepository
import com.example.betterto_do.models.Task
import java.util.*

// ViewModel for EditFragment
class EditFragmentViewModel: ViewModel() {
    // Task repository instance
    private val taskRepository = TaskRepository.get()
    private val taskIdLiveData = MutableLiveData<UUID>()

    // LiveData for the task with the specified ID
    var taskLiveData: LiveData<Task?> =
        taskIdLiveData.switchMap { taskId ->
            taskRepository.getTaskFromId(taskId)
        }

    // Load task with the specified ID
    fun loadTask(taskId: UUID) {
        taskIdLiveData.value = taskId
    }

    // Save task
    fun saveTask(task: Task) {
        taskRepository.updateTask(task)
    }

}