package com.example.betterto_do.viewmodels.add_edit_task;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u0006\'"}, d2 = {"Lcom/example/betterto_do/viewmodels/add_edit_task/AddEditTaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/betterto_do/tasks/TaskRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/betterto_do/tasks/TaskRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_uiEvent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/betterto_do/util/UiEvent;", "<set-?>", "Lcom/example/betterto_do/tasks/Task;", "task", "getTask", "()Lcom/example/betterto_do/tasks/Task;", "setTask", "(Lcom/example/betterto_do/tasks/Task;)V", "task$delegate", "Landroidx/compose/runtime/MutableState;", "", "taskDescript", "getTaskDescript", "()Ljava/lang/String;", "setTaskDescript", "(Ljava/lang/String;)V", "taskDescript$delegate", "taskTitle", "getTaskTitle", "setTaskTitle", "taskTitle$delegate", "uiEvent", "Lkotlinx/coroutines/flow/Flow;", "getUiEvent", "()Lkotlinx/coroutines/flow/Flow;", "onEvent", "", "event", "Lcom/example/betterto_do/viewmodels/add_edit_task/AddEditTaskEvent;", "sendUiEvent", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AddEditTaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.betterto_do.tasks.TaskRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState task$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState taskTitle$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState taskDescript$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<com.example.betterto_do.util.UiEvent> _uiEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.betterto_do.util.UiEvent> uiEvent = null;
    
    @javax.inject.Inject
    public AddEditTaskViewModel(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.TaskRepository repository, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.betterto_do.tasks.Task getTask() {
        return null;
    }
    
    private final void setTask(com.example.betterto_do.tasks.Task p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTaskTitle() {
        return null;
    }
    
    private final void setTaskTitle(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTaskDescript() {
        return null;
    }
    
    private final void setTaskDescript(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.betterto_do.util.UiEvent> getUiEvent() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.viewmodels.add_edit_task.AddEditTaskEvent event) {
    }
    
    private final void sendUiEvent(com.example.betterto_do.util.UiEvent event) {
    }
}