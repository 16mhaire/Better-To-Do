@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.betterto_do

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

data class Task(val name: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {
    var showAddTaskUI by remember { mutableStateOf(false) }
    var currentScreen: String by remember { mutableStateOf("Dashboard") }
    val tasks = remember { mutableStateOf(listOf<Task>()) }

    if (showAddTaskUI) {
        AddTaskUI(onTaskAdded = { task ->
            tasks.value = tasks.value + task
            showAddTaskUI = false
        })
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { showAddTaskUI = true }) {
                    Text("Add New Task")
                }
                Button(onClick = { currentScreen = "Today {1}" }) {
                    Text("Today {1}")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = SpaceEvenly
            ) {
                Button(onClick = { currentScreen = "Scheduled {2}" }) {
                    Text("Scheduled {2}")
                }
                Button(onClick = { currentScreen = "Urgent {3}" }) {
                    Text("Urgent {3}")
                }
                Button(onClick = { currentScreen = "All {6}" }) {
                    Text("All {6}")
                }
            }
            //@kevin this is where I added the listscreen from your code.
            //ListCreationScreen( onListCreated = {}


            LazyColumn {
                items(tasks.value) { task ->
                    TaskWidget(task)
                }
            }

            // Rest of your Dashboard UI...
            LogOutButton {
                logOut()
            }
        }
    }
// Rest of the Dashboard logic for handling different screens...
}

@Composable
fun TaskWidget(task: Task) {
    // Custom widget to display a task
    Text(
        text = task.name,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .border(1.dp, Color.Black)
            .fillMaxWidth()
    )
    // Add more elements as needed
}
//@Matthew and @Jaiten, I was able to just use this composable for the task buttons
@ExperimentalMaterial3Api
@Composable
fun AddTaskUI(onTaskAdded: (Task) -> Unit) {
    var taskName by remember { mutableStateOf("") }

    Column {
        TextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = { Text("Task Name") }
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

//
// I added this log out button. Spruce it up however you see fit. I made it return the user to mainActivity, where the control flow will send them back to the login screen. - Mason
//
@Composable
fun LogOutButton(logout: () -> Unit){

    val context = LocalContext.current

    val loginActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }

    Button(onClick = { logOut()
        val intent = Intent(context, Login::class.java)
        loginActivityLauncher.launch(intent)

        Toast.makeText(context, "User signed out", Toast.LENGTH_SHORT).show() }
    ) {

        Text(text = "Log Out")
    }
}

fun logOut(){
    FirebaseAuth.getInstance().signOut()
}
