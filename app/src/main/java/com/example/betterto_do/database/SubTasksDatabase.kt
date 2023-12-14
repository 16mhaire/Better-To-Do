package com.example.betterto_do.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.betterto_do.models.SubTask

// Database class for that stores all subtasks
@Database(entities = [ SubTask::class ], version = 2)
@TypeConverters(TasksTypeConverters::class)
abstract class SubTaskDatabase: RoomDatabase(){
    // DAO instance
    abstract fun subTasksDAO(): SubTasksDAO

}

// Updates old version of Database prior to any changed from user,
// into the new version post-changes from user
//val migration_3_4 = object: Migration(3, 4){
//    override fun migrate(db: SupportSQLiteDatabase) {
//        db.execSQL(
//            "ALTER TABLE Task ADD COLUMN notification INTEGER NOT NULL DEFAULT 'false'"
//        )
//        db.execSQL(
//            "ALTER TABLE Task ADD COLUMN notificationID TEXT NOT NULL DEFAULT ''"
//        )
//    }
//}