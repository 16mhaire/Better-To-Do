package com.example.betterto_do

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Dashboard() {
    // Task list data
    val tasks by remember { mutableStateOf(listOf(TaskToDo("Task 1"), TaskToDo("Task 2"), TaskToDo("Task 3"))) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Dashboard")

        // Task List
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task = task)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Space the buttons evenly
        ) {
            // Button for adding new tasks
            Button(
                onClick = { /* Handle button click to add a new task */ },
                modifier = Modifier.weight(1f), // Expand to fill available space
                content = {
                    Text(text = "Add Task", color = Color.White)
                }
            )

            Button(
                onClick = { /* Handle button click to create a new To-Do List */ },
                modifier = Modifier.weight(1f), // Expand to fill available space
                content = {
                    Text(text = "To-Do List", color = Color.White)
                }
            )
        }
    }
}
@Composable
fun TaskItem(task: TaskToDo) {
    // Your code here
}
