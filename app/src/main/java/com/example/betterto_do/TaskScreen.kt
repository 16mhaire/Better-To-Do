package com.example.betterto_do

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.betterto_do.util.TaskEvent
import com.example.betterto_do.util.UiEvent
import com.example.betterto_do.viewmodels.SharedViewModel

//This is suppressed because it is causing an error that will need to be revisited
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun TaskScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: SharedViewModel = hiltViewModel()
) {
    //grabbing the tasks with the initial start being an empty list
    val tasks = viewModel.tasks.collectAsState(initial = emptyList())
    //scaffold state for the snack bar
    var scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        //Grabbing the ui events
        viewModel.uiEvent.collect { event ->
            when(event) {
                //ui event to show the undo delete message in the snackbar
                is UiEvent.ShowSnackbar -> {
                    //this will return a result if the action was clicked (like the undo button)
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        //these are set to the values already set in the given event
                        message = event.message,
                        actionLabel = event.action
                    )
                    //check the result to see if the undo was clicked
                    if(result == SnackbarResult.ActionPerformed){
                        //if it was clicked then we call the existing undo delete function in TaskEvent
                        viewModel.onEvent(TaskEvent.OnUndoDeleteTaskClick)
                    }
                }
                //navigate uses the onNavigate function to change screens
                is UiEvent.Navigate -> onNavigate(event)
                //Don't need to pop back stack so will just put an else statement here
                else -> Unit
            }
        }
    }

    Scaffold (
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(TaskEvent.OnAddTaskClick)
            }) {
                //This will be a default add or + sign for an add icon to add task
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
    //This is having an error with the padding so it is suppressed
    //TODO: check the padding error that is suppressed above
    {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(tasks.value) {task->
                TaskItem(
                    task = task,
                    onEvent = viewModel::onEvent,
                    //didn't realize you could do this but
                    //you can do multiple lines of code like this instead of repeating Modifier over and over
                    modifier = Modifier
                        .fillMaxWidth()
                        //makes the task clickable
                        .clickable {
                            //use the task click function to show task details
                            viewModel.onEvent(TaskEvent.OnTaskClick(task))
                        }
                        .padding(16.dp)
                    )
            }
        }
    }
}