package com.example.betterto_do

import android.app.Application

class BetterToDoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TaskRepository.initialize(this)
//        SubTaskRepository.initialize(this)
    }
}