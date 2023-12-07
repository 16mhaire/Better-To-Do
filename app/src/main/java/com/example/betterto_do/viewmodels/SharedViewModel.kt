package com.example.betterto_do.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betterto_do.tasks.Action
import com.example.betterto_do.tasks.CONSTANTS
import com.example.betterto_do.tasks.Priority
import com.example.betterto_do.tasks.Task
import com.example.betterto_do.tasks.TaskRepository
import com.example.betterto_do.tasks.subtasks.SubTask
import com.example.betterto_do.tasks.subtasks.SubTaskRepository
import com.example.betterto_do.util.DataStoreRepository
import com.example.betterto_do.util.ListAppBarState
import com.example.betterto_do.util.RequestState
import com.example.betterto_do.util.Routes
import com.example.betterto_do.util.TaskEvent
import com.example.betterto_do.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: TaskRepository,
    private val subTaskRepository: SubTaskRepository,
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {

    val listAppBarState: MutableState<ListAppBarState> = mutableStateOf(ListAppBarState.CLOSED)
    val listAppBarSearchQuery = mutableStateOf("")

    val action = mutableStateOf(Action.NO_ACTION)
    private val _allTask: MutableStateFlow<RequestState<List<Task>>>
            = MutableStateFlow(RequestState.Idle)

    private val _allSubTask: MutableStateFlow<RequestState<List<SubTask>>>
            = MutableStateFlow(RequestState.Idle)
    val allTask: StateFlow<RequestState<List<Task>>>
        get() = _allTask

    private val _searchedTasks: MutableStateFlow<RequestState<List<Task>>> = MutableStateFlow(RequestState.Idle)
    private val _searchedSubTasks: MutableStateFlow<RequestState<List<SubTask>>> = MutableStateFlow(RequestState.Idle)
    val searchedTasks: StateFlow<RequestState<List<Task>>>
        get() = _searchedTasks

    fun getAllTask(){
        _allTask.value = RequestState.Loading
        try {
            viewModelScope.launch {
//                delay(1000)
                repository.getAllTask.collect{
                    _allTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allTask.value = RequestState.Error(e)
        }
    }

    fun getAllSubTask(){
        _allSubTask.value = RequestState.Loading
        try {
            viewModelScope.launch {
//                delay(1000)
                subTaskRepository.getAllSubTask.collect{
                    _allSubTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allSubTask.value = RequestState.Error(e)
        }
    }

    private fun getTaskSortedLow(){
        _allTask.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                repository.getTaskSortedLowPriority.collect{
                    _allTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allTask.value = RequestState.Error(e)
        }
    }

    private fun getSubTaskSortedLow(){
        _allSubTask.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                subTaskRepository.getSubTaskSortedLowPriority.collect{
                    _allSubTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allSubTask.value = RequestState.Error(e)
        }
    }

    private fun getTaskSortedHigh(){
        _allTask.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                repository.getTaskSortedHighPriority.collect{
                    _allTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allTask.value = RequestState.Error(e)
        }
    }

    private fun getSubTaskSortedHigh(){
        _allSubTask.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                subTaskRepository.getSubTaskSortedHighPriority.collect{
                    _allSubTask.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allSubTask.value = RequestState.Error(e)
        }
    }

    private val _selectedTask: MutableStateFlow<Task?> = MutableStateFlow(null)
    private val _selectedSubTask: MutableStateFlow<SubTask?> = MutableStateFlow(null)

    val selectedTask: StateFlow<Task?>
    get() = _selectedTask

    fun getTask(taskId: Int){

        viewModelScope.launch {
            repository.getTaskByID(taskId).collect{task ->
                _selectedTask.value = task
            }
        }
    }

    fun getSubTask(subTaskId: Int){

        viewModelScope.launch {
            subTaskRepository.getSubTaskByID(subTaskId).collect{subTask ->
                _selectedSubTask.value = subTask
            }
        }
    }

    fun searchTask(query: String){
        _searchedTasks.value = RequestState.Loading
        try {
            val searchTaskFlow = repository.searchDatabase("%$query%")
            viewModelScope.launch(Dispatchers.IO) {
                searchTaskFlow.collectLatest { list ->
                    _searchedTasks.value = RequestState.Success(list)
                }
            }
        }catch (e: Exception){
            _searchedTasks.value = RequestState.Error(e)
        }
        listAppBarState.value = ListAppBarState.TRIGGERED
    }

    fun searchSubTask(query: String){
        _searchedSubTasks.value = RequestState.Loading
        try {
            val searchSubTaskFlow = subTaskRepository.searchDatabase("%$query%")
            viewModelScope.launch(Dispatchers.IO) {
                searchSubTaskFlow.collectLatest { list ->
                    _searchedSubTasks.value = RequestState.Success(list)
                }
            }
        }catch (e: Exception){
            _searchedSubTasks.value = RequestState.Error(e)
        }
        listAppBarState.value = ListAppBarState.TRIGGERED
    }

    private val id = mutableStateOf(0)
    val taskName = mutableStateOf("")
    val taskDescription: MutableState<String?> = mutableStateOf("")
    val priority = mutableStateOf(Priority.NONE)

    val subTaskName = mutableStateOf("")
    val subTaskDescription: MutableState<String?> = mutableStateOf("")

    fun updateFieldsWithCurrentSelectedTask(task: Task?){

            if (task != null) {
                id.value = task.id
                taskName.value = task.taskName
                taskDescription.value = task.taskDescription
                priority.value = task.taskPriority
            } else {
                id.value = 0
                taskName.value = ""
                taskDescription.value = null
                priority.value = Priority.LOW
            }

    }

    fun updateTaskName(newTaskName: String){
        if(newTaskName.length < CONSTANTS.MAX_TITLE_LENGTH)
            taskName.value = newTaskName
    }
    fun validateFields(): Boolean{
        return taskName.value.isNotBlank()
    }

    fun handleDatabaseActions(action: Action){
        when (action){
            Action.ADD -> addTask()
            Action.UPDATE -> updateTask()
            Action.DELETE -> deleteTask()
            Action.DELETE_ALL -> deleteAllTask()
            Action.UNDO ->  undoTask()
            Action.NO_ACTION -> {}
        }
        this.action.value = Action.NO_ACTION
    }

    private fun undoTask() {
        addTask()
    }

    private fun deleteAllTask() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTask()
        }
    }

    private fun deleteAllSubTask() {
        viewModelScope.launch(Dispatchers.IO) {
            subTaskRepository.deleteAllSubTask()
        }
    }

    private fun deleteTask() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(
                Task(
                    id = id.value,
                    taskName = taskName.value,
                    taskDescription = taskDescription.value,
                    taskPriority = priority.value,
                )
            )
        }
    }

    private fun deleteSubTask() {
        viewModelScope.launch(Dispatchers.IO) {
            subTaskRepository.deleteSubTask(
                SubTask(
                    id = id.value,
                    subTaskName = subTaskName.value,
                    subTaskDescription = subTaskDescription.value,
                    subTaskPriority = priority.value,
                )
            )
        }
    }

    private fun updateTask() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(
                Task(
                    id = id.value,
                    taskName = taskName.value,
                    taskDescription = taskDescription.value,
                    taskPriority = priority.value,
                )
            )
        }
    }

    private fun updateSubTask() {
        viewModelScope.launch(Dispatchers.IO) {
            subTaskRepository.updateSubTask(
                SubTask(
                    id = id.value,
                    subTaskName = subTaskName.value,
                    subTaskDescription = subTaskDescription.value,
                    subTaskPriority = priority.value,
                )
            )
        }
    }

    private fun addTask(){
        viewModelScope.launch(Dispatchers.IO) {
            val task = Task(taskName = taskName.value, taskDescription = taskDescription.value, taskPriority = priority.value)
            repository.insertTask(task)
        }
        listAppBarState.value = ListAppBarState.CLOSED
    }

    private fun addSubTask(){
        viewModelScope.launch(Dispatchers.IO) {
            val subTask = SubTask(subTaskName = subTaskName.value, subTaskDescription = subTaskDescription.value, subTaskPriority = priority.value)
            subTaskRepository.insertSubTask(subTask)
        }
        listAppBarState.value = ListAppBarState.CLOSED
    }

    private val _sortState = MutableStateFlow<RequestState<Priority>>(RequestState.Idle)
    val sortState: StateFlow<RequestState<Priority>>
    get() = _sortState

    fun readSortState(){
        _sortState.value = RequestState.Loading
        try {
            viewModelScope.launch(Dispatchers.IO) {
                dataStoreRepository.getSortOrder().collect {
                    _sortState.value = RequestState.Success(Priority.valueOf(it))
                }
            }
        }catch (e: Exception){
            _sortState.value = RequestState.Error(e)
        }
    }

    fun changeSortPriority(priority: Priority) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveSortOrder(priority)
        }
    }

     fun viewByPriority(priority: Priority){
         when(priority){
             Priority.HIGH -> getTaskSortedHigh()
             Priority.MEDIUM -> { }
             Priority.LOW -> getTaskSortedLow()
             Priority.NONE -> getAllTask()
         }
     }
    //These will help handle events that can be called in the UI
    private val _uiEvent = Channel<UiEvent> {  }
    val uiEvent = _uiEvent.receiveAsFlow()

    //This can cache the recently deleted task in case of an undo to reinstate the task
    private var deletedTask: Task? = null

    //Task Event handler with Ui
    fun onEvent(event: TaskEvent){
        when(event){
            is TaskEvent.OnDeleteTaskClick-> {
                viewModelScope.launch{
                    //store the task before deleting
                    deletedTask = event.task
                    repository.deleteTask(event.task)
                    //This will show the snack bar option to undo delete
                    sendUiEvent(UiEvent.ShowSnackbar(
                        message = "Task deleted",
                        action = "Undo"
                    ))
                }
            }
            is TaskEvent.OnTaskClick -> {
                //calling the coroutine (below) for navigation
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO + "?taskId=${event.task.id}"))
            }
            is TaskEvent.OnAddTaskClick -> {
                //calling the coroutine (below) for navigation
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }
            is TaskEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertTask(
                        event.task.copy(
                            taskCompleted = event.taskCompleted
                        )
                    )
                }
            }
            is TaskEvent.OnUndoDeleteTaskClick -> {
                //check to make sure deleted task isn't set to null
                deletedTask?.let { task ->
                    viewModelScope.launch {
                        //reinsert the task into the repo
                        repository.insertTask(task)
                    }
                }
            }
        }
    }

    //This will be the coroutine to handle the navigation events
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch{
            _uiEvent.send(event)
        }
    }
}