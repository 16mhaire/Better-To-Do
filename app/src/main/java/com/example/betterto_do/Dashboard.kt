@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.betterto_do


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.betterto_do.ui.theme.BetterToDoTheme

data class Task(val name: String)

@Composable
fun Dashboard() {
    BetterToDoTheme {
        var showAddTaskUI by remember { mutableStateOf(false) }
        var currentScreen: String by remember { mutableStateOf("Dashboard") }
        val tasks = remember { mutableStateOf(listOf<Task>()) }
        val backgroundColor = colorResource(id = R.color.white)

        if (showAddTaskUI) {
            AddTaskUI(onTaskAdded = { task ->
                tasks.value = tasks.value + task
                showAddTaskUI = false
            })
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { showAddTaskUI = true },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.mediumRedViolet)) // Change color here
                    ) {
                        Text("Add New Task") }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(
                            onClick = { currentScreen = "Today {1}" },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.limeGreen))) {
                            Text("Today {1}") }
                        Button(
                            onClick = { currentScreen = "Scheduled {2}" },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.frenchPink))) {
                            Text("Scheduled {2}") }
                        Button(
                            onClick = { currentScreen = "Urgent {3}" },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amber))) {
                            Text("Urgent {3}") }
                        Button(
                            onClick = { currentScreen = "All {6}" },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gunmetal))) {
                            Text("All {6}")
                        }}}

                // ListCreationScreen placeholder
                ListCreationScreen(onListCreated = {})
                LazyColumn {
                    items(tasks.value) { task ->
                        TaskWidget(task)
                    }}}}}}
@Composable
fun TaskWidget(task: Task) {
    Text(
        text = task.name,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
}
@ExperimentalMaterial3Api
@Composable
fun AddTaskUI(onTaskAdded: (Task) -> Unit) {
    var taskName by remember { mutableStateOf("") }
    Column {
        TextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = { Text("Task Name")},
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (taskName.isNotBlank()) {
                onTaskAdded(Task(taskName))
                taskName = ""
            }
        }) {
            Text("Add Task")
        }
    }
}