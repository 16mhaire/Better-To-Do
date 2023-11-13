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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Task(val name: String)

@Composable
fun Dashboard() {
    val tasks = remember { mutableStateOf(listOf(Task("Task 1"), Task("Task 2"), Task("Task 3"))) }
    var currentScreen by remember { mutableStateOf("Dashboard") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Dashboard")

        if (currentScreen == "Dashboard") {
            // Task List
            LazyColumn {
                items(tasks.value) { task ->
                    TaskToDo()
                }
            }

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
                    content = {
                        Text(text = "Add Task", color = Color.White)
                    }
                )
                Button(
                    onClick = {
                        currentScreen = "Login" // Navigate to the Login screen
                    },
                    modifier = Modifier.weight(1f),
                    content = {
                        Text(text = "Login", color = Color.White)
                    }
                )
                Button(
                    onClick = {
                        currentScreen = "Register" // Navigate to the Register screen
                    },
                    modifier = Modifier.weight(1f),
                    content = {
                        Text(text = "Register", color = Color.White)
                    }
                )
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