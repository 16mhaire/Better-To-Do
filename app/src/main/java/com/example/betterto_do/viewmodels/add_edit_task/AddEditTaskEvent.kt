package com.example.betterto_do.viewmodels.add_edit_task

sealed class AddEditTaskEvent {
    data class OnTitleChange(val title: String): AddEditTaskEvent()
    data class OnDescriptionChange(val description: String): AddEditTaskEvent()
    object OnSaveTaskClick: AddEditTaskEvent()
}
