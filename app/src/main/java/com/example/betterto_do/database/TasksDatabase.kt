package com.example.betterto_do.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.betterto_do.models.Task

// Database class for that stores all tasks
@Database(entities = [ Task::class ], version = 2)
@TypeConverters(TasksTypeConverters::class)
abstract class TaskDatabase: RoomDatabase(){
    // DAO instance
    abstract fun tasksDAO(): TasksDAO

}

// Migration from version 1 to version 2 of the database.
// Updates old version of Database prior to any changed from user,
// into the new version post-changes from user
val migration_1_2 = object: Migration(1, 2){
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            "ALTER TABLE Task ADD COLUMN notification INTEGER NOT NULL DEFAULT 'false'"
        )
        db.execSQL(
            "ALTER TABLE Task ADD COLUMN notificationID TEXT NOT NULL DEFAULT ''"
        )
    }
}