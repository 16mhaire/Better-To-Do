package com.example.betterto_do.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.example.betterto_do.tasks.TaskDatabase
import com.example.betterto_do.tasks.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application): TaskDatabase {
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            "task_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(database: TaskDatabase): TaskRepository{
        return TaskRepository(database.taskDAO)
    }
}