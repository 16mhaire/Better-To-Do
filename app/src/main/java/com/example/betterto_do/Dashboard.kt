package com.example.betterto_do

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Task(val name: String)

@Composable
fun TaskItem(task: Task) {
    // Create a composable that displays a single task
    Column {
        Text(text = task.name)
        // Add more UI elements related to a single task here
    }
}

@Composable
fun Dashboard() {
    // Task list data
    val tasks = remember {
        mutableStateOf(listOf<Task>())
    }

    Column {
        Text(text = "Welcome to the Dashboard")

        // Task List
        LazyColumn {
            items(tasks.value) { task ->
                TaskItem(task = task)
            }
        }
        // Button for adding new tasks
        Button(
            onClick = { /* Handle button click to add a new task */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Add Task")
        }
        Button(
            onClick = { /* Handle button click to create a new To-Do List */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "To-Do List")
        }
    }
}
