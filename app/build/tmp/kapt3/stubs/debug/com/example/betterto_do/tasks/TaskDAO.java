package com.example.betterto_do.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/betterto_do/tasks/TaskDAO;", "", "deleteAllTask", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "task", "Lcom/example/betterto_do/tasks/Task;", "(Lcom/example/betterto_do/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTask", "Lkotlinx/coroutines/flow/Flow;", "", "getSelectedTask", "id", "", "insertTask", "searchTasks", "searchQuery", "", "sortByHighPriority", "sortByLowPriority", "updateTask", "newTask", "app_debug"})
@androidx.room.Dao
public abstract interface TaskDAO {
    
    @androidx.room.Query(value = "select * from task_table order by id")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> getAllTask();
    
    @androidx.room.Query(value = "select * from task_table where id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.example.betterto_do.tasks.Task> getSelectedTask(int id);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task newTask, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Task task, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "delete from task_table")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllTask(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "select * from task_table where taskName like :searchQuery or taskDescription like :searchQuery")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> searchTasks(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery);
    
    @androidx.room.Query(value = "select * from task_table order by case when taskPriority like \'L%\' then 1 when taskPriority like \'M%\' then 2 when taskPriority like \'H%\' then 3 end")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> sortByLowPriority();
    
    @androidx.room.Query(value = "select * from task_table order by case when taskPriority like \'H%\' then 1 when taskPriority like \'M%\' then 2 when taskPriority like \'L%\' then 3 end")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.betterto_do.tasks.Task>> sortByHighPriority();
}