package com.example.betterto_do.tasks

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    // Task Functions
    @Query("select * from task_table order by id")
    fun getAllTask(): Flow<List<Task>>

    @Query("select * from task_table where id = :id")
    fun getSelectedTask(id: Int): Flow<Task>

    @Update
    suspend fun updateTask(newTask: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("delete from task_table")
    suspend fun deleteAllTask()

    @Query("select * from task_table where taskName like :searchQuery or taskDescription like :searchQuery")
    fun searchTasks(searchQuery: String): Flow<List<Task>>

    @Query("select * from task_table order by case when taskPriority like 'L%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'H%' then 3 end")
    fun sortByLowPriority(): Flow<List<Task>>

    @Query("select * from task_table order by case when taskPriority like 'H%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'L%' then 3 end")
    fun sortByHighPriority(): Flow<List<Task>>

    // SubTask Functions
//    @Query("select * from task_table order by id")
//    fun getAllSubTasks(): Flow<List<subTask>>

//    @Query("select * from task_table where id = :id")
//    fun getSelectedTask(id: Int): Flow<Task>

    @Update
    suspend fun updateSubTask(newSubTask: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTask(subTask: Task)

    @Delete
    suspend fun deleteSubTask(subTask: Task)

//    @Query("delete from task_table")
//    suspend fun deleteAllTask()

//    @Query("select * from task_table where taskName like :searchQuery or taskDescription like :searchQuery")
//    fun searchTasks(searchQuery: String): Flow<List<Task>>

//    @Query("select * from task_table order by case when taskPriority like 'L%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'H%' then 3 end")
//    fun sortByLowPriority(): Flow<List<Task>>

//    @Query("select * from task_table order by case when taskPriority like 'H%' then 1 when taskPriority like 'M%' then 2 when taskPriority like 'L%' then 3 end")
//    fun sortByHighPriority(): Flow<List<Task>>
}