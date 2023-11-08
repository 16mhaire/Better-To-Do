@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.betterto_do

import androidx.compose.foundation.background
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

data class Task(val name: String)

@Composable
fun Dashboard() {
    val tasks = remember { mutableStateOf(listOf(Task("TODAY"), Task("ALL"), Task("Scheduled"), Task("Important"))) }
    var currentScreen: String by remember { mutableStateOf("Dashboard") }

    Box {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top

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
    }
}

@Composable
fun TaskWidget(task: Task) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta) // Set the background color of the box
            .padding(8.dp) // Add padding around the box
    ) {
        Text(
            text = task.name,
            color = Color.Black, // Set text color
            modifier = Modifier.padding(8.dp) // Add padding to the text
        )
    }
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
        onTaskAdded(Task(taskName))
        // Clear the input field
        taskName = ""
    }) {
        Text("Add Task")
    }
}

