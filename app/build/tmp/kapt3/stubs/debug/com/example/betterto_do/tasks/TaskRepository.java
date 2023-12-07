package com.example.betterto_do.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/betterto_do/tasks/TaskRepository;", "Landroidx/lifecycle/ViewModel;", "taskDAO", "Lcom/example/betterto_do/tasks/TaskDAO;", "(Lcom/example/betterto_do/tasks/TaskDAO;)V", "getAllTask", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/betterto_do/tasks/Task;", "getGetAllTask", "()Lkotlinx/coroutines/flow/Flow;", "getTaskSortedHighPriority", "getGetTaskSortedHighPriority", "getTaskSortedLowPriority", "getGetTaskSortedLowPriority", "deleteAllTask", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "task", "(Lcom/example/betterto_do/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskByID", "taskID", "", "insertTask", "searchDatabase", "searchQuery", "", "updateTask", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class TaskRepository extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.betterto_do.tasks.TaskDAO taskDAO = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getAllTask = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getTaskSortedLowPriority = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getTaskSortedHighPriority = null;
    
    @javax.inject.Inject
    public TaskRepository(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.TaskDAO taskDAO) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getGetAllTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getGetTaskSortedLowPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getGetTaskSortedHighPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.betterto_do.tasks.Task> getTaskByID(int taskID) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAllTask(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> searchDatabase(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery) {
        return null;
    }
}