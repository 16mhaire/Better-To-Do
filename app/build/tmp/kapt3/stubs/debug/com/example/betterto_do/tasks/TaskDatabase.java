package com.example.betterto_do.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/betterto_do/tasks/TaskDatabase;", "Landroidx/room/RoomDatabase;", "()V", "taskDAO", "Lcom/example/betterto_do/tasks/TaskDAO;", "getTaskDAO", "()Lcom/example/betterto_do/tasks/TaskDAO;", "app_debug"})
@androidx.room.Database(entities = {com.example.betterto_do.tasks.Task.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends androidx.room.RoomDatabase {
    
    public TaskDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.betterto_do.tasks.TaskDAO getTaskDAO();
}