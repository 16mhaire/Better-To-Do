package com.example.betterto_do.viewmodels.add_edit_task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betterto_do.tasks.Task
import com.example.betterto_do.tasks.TaskRepository
import com.example.betterto_do.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val repository: TaskRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var task by mutableStateOf<Task?>(null)
        private set

    var taskTitle by mutableStateOf("")
        private set

    var taskDescript by mutableStateOf("")
        private set

    //These will help handle events that can be called in the UI
    private val _uiEvent = Channel<UiEvent> {  }
    val uiEvent = _uiEvent.receiveAsFlow()

    //This will check if the add edit is supposed to edit an existing task
    // or if it is just adding a brand new task
    init {
        val taskId = savedStateHandle.get<Int>("taskId") ?: -1
        if(taskId != -1)
        {
            viewModelScope.launch {
                //task = repository.getTaskByID(taskId).firstOrNull()
                (repository.getTaskByID(taskId) as? Task)?.let {task ->
                    taskTitle = task.taskName
                    taskDescript = task.taskDescription ?: ""
                    this@AddEditTaskViewModel.task = task
                }
            }
        }
    }

    fun onEvent(event: AddEditTaskEvent){
        when(event) {
            is AddEditTaskEvent.OnTitleChange -> {
                taskTitle = event.title
            }
            is AddEditTaskEvent.OnDescriptionChange -> {
                taskDescript = event.description
            }
            is AddEditTaskEvent.OnSaveTaskClick -> {
                //check if the task title is blank
                if (taskTitle.isBlank()) {
                    sendUiEvent(UiEvent.ShowSnackbar(
                        message = "The title can not be blank"
                    ))
                    return
                }
                viewModelScope.launch {
                    //insert task with all the necessary info
                    repository.insertTask(
                        Task(
                            taskName = taskTitle,
                            taskDescription = taskDescript,
                            taskCompleted = task?.taskCompleted ?: false,
                            id = task?.id,
                            taskDueDate = task?.taskDueDate,
                            taskPriority = task?.taskPriority
                        )
                    )
                    //To go back to previous screen
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch{
            _uiEvent.send(event)
        }
    }
}