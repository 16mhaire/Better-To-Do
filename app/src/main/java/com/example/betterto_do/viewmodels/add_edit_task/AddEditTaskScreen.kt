package com.example.betterto_do.viewmodels.add_edit_task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.betterto_do.util.UiEvent

//Same suppress issue because of scaffold padding issue
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddEditTaskScreen(
    onPopBackStack: () -> Unit,
    viewModel: AddEditTaskViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{event ->
            when(event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowSnackbar -> scaffoldState.snackbarHostState.showSnackbar(
                    message = event.message,
                    actionLabel = event.action
                )
                else -> Unit
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditTaskEvent.OnSaveTaskClick)
            }) {
                Icon(imageVector = Icons.Default.Check,
                    contentDescription = "Save"
                )
            }
        }
//This is suppressed since the padding isn't taken into account yet
        //TODO Check padding here
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            TextField(value = viewModel.taskTitle,
                onValueChange = {
                    viewModel.onEvent(AddEditTaskEvent.OnTitleChange(it))
                },
                placeholder = {
                    BasicText(text = "Title")
                },
                modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            TextField(value = viewModel.taskDescript,
                onValueChange = {
                    viewModel.onEvent(AddEditTaskEvent.OnDescriptionChange(it))
                },
                placeholder = {
                    BasicText(text = "Description")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                maxLines = 5
            )
        }
    }
}