package com.example.betterto_do

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.betterto_do.database.TasksDAO
import com.example.betterto_do.database.TaskDatabase
import com.example.betterto_do.database.migration_1_2
import com.example.betterto_do.models.Task
import java.util.*
import java.util.concurrent.Executors

// Constants for database name
private const val DATABASE_NAME = "task-database"

// Repository class responsible for handling tasks in the database
class TaskRepository private constructor(context: Context){

    //Repository properties
    private val database: TaskDatabase = Room.databaseBuilder(
        context.applicationContext,
        TaskDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(migration_1_2)
        .build()

    private val taskDAO: TasksDAO = database.tasksDAO()
    private val executor = Executors.newSingleThreadExecutor()

    // LiveData for retrieving all tasks
    fun getAllTasks(): LiveData<List<Task>> = taskDAO.getAllTasks()

    // LiveData for retrieving a task by ID
    fun getTaskFromId(id: UUID): LiveData<Task?> = taskDAO.getTaskFromId(id)

    // LiveData for retrieving the count of tasks
    fun getTaskCount(): LiveData<Int> = taskDAO.getTaskCount()

    // Method to update a task in the database
    fun updateTask(task: Task) {
        executor.execute {
            taskDAO.updateTask(task)
        }
    }

    // Method to add a task to the database
    fun addTask(task: Task) {
        executor.execute {
            taskDAO.addTask(task)
        }
    }

    // Method to delete a task from the database
    fun deleteTask(task: Task){
        executor.execute {
            taskDAO.deleteTask(task)
        }
    }

    companion object{
        // Singleton instance of TaskRepository
        private var INSTANCE: TaskRepository? = null

        // Method to initialize the TaskRepository
        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = TaskRepository(context)
            }
        }

        // Method to get the singleton instance of TaskRepository
        fun get(): TaskRepository{
            return INSTANCE ?:
            throw IllegalStateException("Repository was not initialized")
        }
    }
}