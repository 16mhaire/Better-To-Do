package com.example.betterto_do.tasks.subtasks

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SubTaskRepository @Inject constructor(private val subTaskDAO: SubTaskDAO) : ViewModel() {

    val getAllSubTask: Flow<List<SubTask>> = subTaskDAO.getAllSubTask()
    val getSubTaskSortedLowPriority: Flow<List<SubTask>> = subTaskDAO.sortByLowPriority()
    val getSubTaskSortedHighPriority: Flow<List<SubTask>> = subTaskDAO.sortByHighPriority()

    fun getSubTaskByID(subTaskID: Int): Flow<SubTask> = subTaskDAO.getSelectedSubTask(subTaskID)

    suspend fun insertSubTask(subTask: SubTask) = subTaskDAO.insertSubTask(subTask)

    suspend fun deleteSubTask(subTask: SubTask) = subTaskDAO.deleteSubTask(subTask)

    suspend fun updateSubTask(subTask : SubTask) = subTaskDAO.updateSubTask(subTask)

    suspend fun deleteAllSubTask() = subTaskDAO.deleteAllSubTask()

    fun searchDatabase(searchQuery: String): Flow<List<SubTask>> = subTaskDAO.searchSubTasks(searchQuery)
    
}