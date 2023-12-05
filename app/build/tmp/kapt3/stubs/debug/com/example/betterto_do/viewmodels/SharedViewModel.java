package com.example.betterto_do.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u00107\u001a\u000208H\u0002J\u000e\u00109\u001a\u0002082\u0006\u0010%\u001a\u00020\u000fJ\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0006\u0010\u001a\u001a\u000208J\u000e\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u001eJ\b\u0010>\u001a\u000208H\u0002J\b\u0010?\u001a\u000208H\u0002J\u000e\u0010@\u001a\u0002082\u0006\u0010\u0013\u001a\u00020\u0015J\u000e\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u000208J\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020 J\u0010\u0010G\u001a\u0002082\u0006\u0010B\u001a\u00020\u0012H\u0002J\b\u0010H\u001a\u000208H\u0002J\u0010\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u000bJ\b\u0010K\u001a\u000208H\u0002J\u000e\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020 J\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u0002082\u0006\u0010%\u001a\u00020\u000fR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00198F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001bR\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00198F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u001bR\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u00198F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0017R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0017R\u001d\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n02\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u001202\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104\u00a8\u0006Q"}, d2 = {"Lcom/example/betterto_do/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/betterto_do/tasks/TaskRepository;", "dataStoreRepository", "Lcom/example/betterto_do/util/DataStoreRepository;", "(Lcom/example/betterto_do/tasks/TaskRepository;Lcom/example/betterto_do/util/DataStoreRepository;)V", "_allTask", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/betterto_do/util/RequestState;", "", "Lcom/example/betterto_do/tasks/Task;", "_searchedTasks", "_selectedTask", "_sortState", "Lcom/example/betterto_do/tasks/Priority;", "_uiEvent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/betterto_do/util/UiEvent;", "action", "Landroidx/compose/runtime/MutableState;", "Lcom/example/betterto_do/tasks/Action;", "getAction", "()Landroidx/compose/runtime/MutableState;", "allTask", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTask", "()Lkotlinx/coroutines/flow/StateFlow;", "deletedTask", "id", "", "listAppBarSearchQuery", "", "getListAppBarSearchQuery", "listAppBarState", "Lcom/example/betterto_do/util/ListAppBarState;", "getListAppBarState", "priority", "getPriority", "searchedTasks", "getSearchedTasks", "selectedTask", "getSelectedTask", "sortState", "getSortState", "taskDescription", "getTaskDescription", "taskName", "getTaskName", "tasks", "Lkotlinx/coroutines/flow/Flow;", "getTasks", "()Lkotlinx/coroutines/flow/Flow;", "uiEvent", "getUiEvent", "addTask", "", "changeSortPriority", "deleteAllTask", "deleteTask", "getTask", "taskId", "getTaskSortedHigh", "getTaskSortedLow", "handleDatabaseActions", "onEvent", "event", "Lcom/example/betterto_do/util/TaskEvent;", "readSortState", "searchTask", "query", "sendUiEvent", "undoTask", "updateFieldsWithCurrentSelectedTask", "task", "updateTask", "updateTitle", "newTitle", "validateFields", "", "viewByPriority", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.betterto_do.tasks.TaskRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.betterto_do.util.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.betterto_do.util.ListAppBarState> listAppBarState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> listAppBarSearchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.betterto_do.tasks.Action> action = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.betterto_do.util.RequestState<java.util.List<com.example.betterto_do.tasks.Task>>> _allTask = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.betterto_do.util.RequestState<java.util.List<com.example.betterto_do.tasks.Task>>> _searchedTasks = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.betterto_do.tasks.Task> _selectedTask = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Integer> id = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> taskName = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> taskDescription = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.betterto_do.tasks.Priority> priority = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.betterto_do.util.RequestState<com.example.betterto_do.tasks.Priority>> _sortState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> tasks = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<com.example.betterto_do.util.UiEvent> _uiEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.betterto_do.util.UiEvent> uiEvent = null;
    @org.jetbrains.annotations.Nullable
    private com.example.betterto_do.tasks.Task deletedTask;
    
    @javax.inject.Inject
    public SharedViewModel(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.TaskRepository repository, @org.jetbrains.annotations.NotNull
    com.example.betterto_do.util.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.example.betterto_do.util.ListAppBarState> getListAppBarState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getListAppBarSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.example.betterto_do.tasks.Action> getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.betterto_do.util.RequestState<java.util.List<com.example.betterto_do.tasks.Task>>> getAllTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.betterto_do.util.RequestState<java.util.List<com.example.betterto_do.tasks.Task>>> getSearchedTasks() {
        return null;
    }
    
    public final void getAllTask() {
    }
    
    private final void getTaskSortedLow() {
    }
    
    private final void getTaskSortedHigh() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.betterto_do.tasks.Task> getSelectedTask() {
        return null;
    }
    
    public final void getTask(int taskId) {
    }
    
    public final void searchTask(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getTaskName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getTaskDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.example.betterto_do.tasks.Priority> getPriority() {
        return null;
    }
    
    public final void updateFieldsWithCurrentSelectedTask(@org.jetbrains.annotations.Nullable
    com.example.betterto_do.tasks.Task task) {
    }
    
    public final void updateTitle(@org.jetbrains.annotations.NotNull
    java.lang.String newTitle) {
    }
    
    public final boolean validateFields() {
        return false;
    }
    
    public final void handleDatabaseActions(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Action action) {
    }
    
    private final void undoTask() {
    }
    
    private final void deleteAllTask() {
    }
    
    private final void deleteTask() {
    }
    
    private final void updateTask() {
    }
    
    private final void addTask() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.betterto_do.util.RequestState<com.example.betterto_do.tasks.Priority>> getSortState() {
        return null;
    }
    
    public final void readSortState() {
    }
    
    public final void changeSortPriority(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Priority priority) {
    }
    
    public final void viewByPriority(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Priority priority) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.betterto_do.util.UiEvent> getUiEvent() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.util.TaskEvent event) {
    }
    
    private final void sendUiEvent(com.example.betterto_do.util.UiEvent event) {
    }
}