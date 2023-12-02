package com.example.betterto_do.tasks

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TaskRepository @Inject constructor(private val taskDAO: TaskDAO) : ViewModel() {

    val getAllTask: Flow<List<Task>> = taskDAO.getAllTask()
    val getTaskSortedLowPriority: Flow<List<Task>> = taskDAO.sortByLowPriority()
    val getTaskSortedHighPriority: Flow<List<Task>> = taskDAO.sortByHighPriority()

    // Task Functions
    fun getTaskByID(taskID: Int): Flow<Task> = taskDAO.getSelectedTask(taskID)

    suspend fun insertTask(task: Task) = taskDAO.insertTask(task)

    suspend fun deleteTask(task: Task) = taskDAO.deleteTask(task)

    suspend fun updateTask(task : Task) = taskDAO.updateTask(task)

    suspend fun deleteAllTask() = taskDAO.deleteAllTask()

    fun searchDatabase(searchQuery: String): Flow<List<Task>> = taskDAO.searchTasks(searchQuery)

    // SubTask Functions
//    fun getSubTaskByID(taskID: Int): Flow<Task> = taskDAO.getSelectedSubTask(taskID)

    suspend fun insertSubTask(subTask: Task) = taskDAO.insertSubTask(subTask)

    suspend fun deleteSubTask(subTask: Task) = taskDAO.deleteSubTask(subTask)

    suspend fun updateSubTask(subTask : Task) = taskDAO.updateSubTask(subTask)

//    suspend fun deleteAllSubTask() = taskDAO.deleteAllSubTask()

//    fun searchDatabase(searchQuery: String): Flow<List<Task>> = taskDAO.searchSubTasks(searchQuery)

}