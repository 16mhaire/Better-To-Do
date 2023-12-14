package com.example.betterto_do.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.betterto_do.models.Task
import java.util.*

// Data Access Object that allows interacting with Tasks in the TaskDatabase
@Dao
interface TasksDAO {
    // Query to get all tasks
    @Query("SELECT * FROM task")
    fun getAllTasks(): LiveData<List<Task>>

    // Query to get a task by its ID
    @Query("SELECT * FROM task WHERE id=(:id)")
    fun getTaskFromId(id: UUID): LiveData<Task?>

    // Query to get the number of tasks
    @Query("SELECT COUNT(*) FROM task")
    fun getTaskCount(): LiveData<Int>

    // Update task with new info
    @Update
    fun updateTask(task: Task)

    // Insert task into Database
    @Insert
    fun addTask(task: Task)

    // Delete task from Database
    @Delete
    fun deleteTask(task: Task)

}