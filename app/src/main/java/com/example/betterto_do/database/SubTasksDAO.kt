package com.example.betterto_do.database

import androidx.room.*
import com.example.betterto_do.models.SubTask
import kotlinx.coroutines.flow.Flow

// Data Access Object that allows interacting with SubTasks in the SubTaskDatabase

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

    @Query("select * from task_table where title like :searchQuery or description like :searchQuery")
    fun searchSubTasks(searchQuery: String): Flow<List<SubTask>>

}