package com.example.betterto_do.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.betterto_do.models.SubTask
import java.util.*

// Data Access Object that allows interacting with SubTasks in the SubTaskDatabase
@Dao
interface SubTasksDAO {
    // Query to get all subtasks
    @Query("SELECT * FROM subTask")
    fun getAllSubTasks(): LiveData<List<SubTask>>

    // Query to get a subtask by its ID
    @Query("SELECT * FROM subTask WHERE id=(:id)")
    fun getSubTaskFromId(id: UUID): LiveData<SubTask?>

    // Query to get the number of subtasks
    @Query("SELECT COUNT(*) FROM subTask")
    fun getSubTaskCount(): LiveData<Int>

    // Update subtask with new info
    @Update
    fun updateSubTask(subTask: SubTask)

    // Insert subtask into Database
    @Insert
    fun addSubTask(subTask: SubTask)

    // Delete subtask from Database
    @Delete
    fun deleteSubTask(subTask: SubTask)

}