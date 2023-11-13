@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.betterto_do

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.betterto_do.tasks.Priority
import com.example.betterto_do.tasks.Task
import com.example.betterto_do.tasks.createNewTask

@Composable
fun Dashboard() {
    val tasks = remember { mutableStateOf(listOf(createNewTask("Task", "words",Priority.NONE ))) }
    var currentScreen: String by remember { mutableStateOf("Dashboard") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Landing page (Dashboard)")

        Button(
            onClick = {
                // Handle button click here
                currentScreen = "Tasks"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Go to Tasks")
        }

        LazyColumn {
            items(tasks.value) { task ->
                TaskWidget(task)
            }
        }

        if (currentScreen == "Dashboard") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Handle button click to add a new task
                        val newTask = createNewTask("Task", "words",Priority.NONE )
                        listOf(tasks) + newTask
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = "Add Task", color = Color.White)
                }

                Button(
                    onClick = {
                        currentScreen = "Login" // Navigate to the Login screen
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = "Login", color = Color.White)
                }

                Button(
                    onClick = {
                        currentScreen = "Register" // Navigate to the Register screen
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(text = "Register", color = Color.White)
                }
            }
        } else if (currentScreen == "Login") {
            // Show the Login screen
            Login()
        } else if (currentScreen == "Register") {
            // Show the Register screen
            Register()
        }
    }
}

@Composable
fun TaskWidget(task: Task) {
    // Custom widget to display a task
    Text(text = task.taskName)
    // Add more elements as needed
}

@ExperimentalMaterial3Api
@Composable
fun AddTaskUI(onTaskAdded: (Task) -> Unit) {
    var taskName by remember { mutableStateOf("") }

    Column {
        TextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = {
                Text("Task Name")
            })
       Spacer(modifier = Modifier.height(16.dp))
    }
    Button(onClick = {
        // Create a new Task and pass it to the callback function
        onTaskAdded(createNewTask(taskName,taskDescription = null, taskPriority = Priority.NONE))
        // Clear the input field
        taskName = ""
    }) {
        Text("Add Task")
    }
}