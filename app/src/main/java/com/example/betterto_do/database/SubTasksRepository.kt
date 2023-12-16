package com.example.betterto_do.database

import androidx.lifecycle.ViewModel
import com.example.betterto_do.models.SubTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SubTaskRepository @Inject constructor(private val subTaskDAO: SubTaskDAO) : ViewModel() {

    val getAllSubTask: Flow<List<SubTask>> = subTaskDAO.getAllSubTask()

    fun getSubTaskByID(subTaskID: Int): Flow<SubTask> = subTaskDAO.getSelectedSubTask(subTaskID)

    suspend fun insertSubTask(subTask: SubTask) = subTaskDAO.insertSubTask(subTask)

    suspend fun deleteSubTask(subTask: SubTask) = subTaskDAO.deleteSubTask(subTask)

    suspend fun updateSubTask(subTask : SubTask) = subTaskDAO.updateSubTask(subTask)

    suspend fun deleteAllSubTask() = subTaskDAO.deleteAllSubTask()

    fun searchDatabase(searchQuery: String): Flow<List<SubTask>> = subTaskDAO.searchSubTasks(searchQuery)

}