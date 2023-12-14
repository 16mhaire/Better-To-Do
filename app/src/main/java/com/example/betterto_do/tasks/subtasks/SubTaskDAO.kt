package com.example.betterto_do.tasks.subtasks

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SubTaskDAO {
    @Query("select * from task_table order by id")
    fun getAllSubTask(): Flow<List<SubTask>>

    @Query("select * from task_table where id = :id")
    fun getSelectedSubTask(id: Int): Flow<SubTask>

    @Update
    suspend fun updateSubTask(newSubTask: SubTask)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTask(subTask: SubTask)

    @Delete
    suspend fun deleteSubTask(subTask: SubTask)

    @Query("delete from task_table")
    suspend fun deleteAllSubTask()

    @Query("select * from task_table where subTaskName like :searchQuery or subTaskDescription like :searchQuery")
    fun searchSubTasks(searchQuery: String): Flow<List<SubTask>>

    @Query("select * from task_table order by case when taskPriority like 'L%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'H%' then 3 end")
    fun sortByLowPriority(): Flow<List<SubTask>>

    @Query("select * from task_table order by case when taskPriority like 'H%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'L%' then 3 end")
    fun sortByHighPriority(): Flow<List<SubTask>>

}