//package com.example.betterto_do
//
//import android.content.Context
//import androidx.lifecycle.LiveData
//import androidx.room.Room
//import com.example.betterto_do.database.SubTasksDAO
//import com.example.betterto_do.database.SubTaskDatabase
//import com.example.betterto_do.database.migration_1_2
//import com.example.betterto_do.models.SubTask
//import java.util.*
//import java.util.concurrent.Executors
//
//// Constants for database name
//private const val DATABASE_NAME = "subtask-database"
//
//// Repository class responsible for handling tasks in the database
//class SubTaskRepository private constructor(context: Context){
//
//    //Repository properties
//    private val database: SubTaskDatabase = Room.databaseBuilder(
//        context.applicationContext,
//        SubTaskDatabase::class.java,
//        DATABASE_NAME
//    ).addMigrations(migration_3_4)
//        .build()
//
//    private val subTaskDAO: SubTasksDAO = database.subTasksDAO()
//    private val executor = Executors.newSingleThreadExecutor()
//
//    // LiveData for retrieving all tasks
//    fun getAllTasks(): LiveData<List<SubTask>> = subTaskDAO.getAllSubTasks()
//
//    // LiveData for retrieving a task by ID
//    fun getTaskFromId(id: UUID): LiveData<SubTask?> = subTaskDAO.getSubTaskFromId(id)
//
//    // LiveData for retrieving the count of tasks
//    fun getTaskCount(): LiveData<Int> = subTaskDAO.getSubTaskCount()
//
//    // Method to update a task in the database
//    fun updateSubTask(subTask: SubTask) {
//        executor.execute {
////            subTask.updateSubTask(subTask)
//        }
//    }
//
//    // Method to add a task to the database
//    fun addSubTask(subTask: SubTask) {
//        executor.execute {
//            subTaskDAO.addSubTask(subTask)
//        }
//    }
//
//    // Method to delete a task from the database
//    fun deleteSubTask(subTask: SubTask){
//        executor.execute {
//            subTaskDAO.deleteSubTask(subTask)
//        }
//    }
//
//    companion object{
//        // Singleton instance of TaskRepository
//        private var INSTANCE: TaskRepository? = null
//
//        // Method to initialize the TaskRepository
//        fun initialize(context: Context){
//            if(INSTANCE == null){
//                INSTANCE = SubTaskRepository(context)
//            }
//        }
//
//        // Method to get the singleton instance of TaskRepository
//        fun get(): SubTaskRepository{
//            return INSTANCE ?:
//            throw IllegalStateException("Repository was not initialized")
//        }
//    }
//}