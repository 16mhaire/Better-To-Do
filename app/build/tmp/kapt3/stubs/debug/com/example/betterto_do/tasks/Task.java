package com.example.betterto_do.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010!\u001a\u00020\fH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0001H\u00c6\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0001H\u00c6\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/example/betterto_do/tasks/Task;", "", "id", "", "taskName", "", "taskDescription", "taskPriority", "Lcom/example/betterto_do/tasks/Priority;", "taskDueDate", "Ljava/time/LocalTime;", "taskCompleted", "", "subTask", "(ILjava/lang/String;Ljava/lang/String;Lcom/example/betterto_do/tasks/Priority;Ljava/time/LocalTime;ZLjava/lang/Object;)V", "getId", "()I", "getSubTask", "()Ljava/lang/Object;", "getTaskCompleted", "()Z", "getTaskDescription", "()Ljava/lang/String;", "getTaskDueDate", "()Ljava/time/LocalTime;", "getTaskName", "getTaskPriority", "()Lcom/example/betterto_do/tasks/Priority;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "task_table")
public final class Task {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String taskName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String taskDescription = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.betterto_do.tasks.Priority taskPriority = null;
    @org.jetbrains.annotations.Nullable
    private final java.time.LocalTime taskDueDate = null;
    private final boolean taskCompleted = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object subTask = null;
    
    public Task(int id, @org.jetbrains.annotations.NotNull
    java.lang.String taskName, @org.jetbrains.annotations.Nullable
    java.lang.String taskDescription, @org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Priority taskPriority, @org.jetbrains.annotations.Nullable
    java.time.LocalTime taskDueDate, boolean taskCompleted, @org.jetbrains.annotations.NotNull
    java.lang.Object subTask) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTaskName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTaskDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.betterto_do.tasks.Priority getTaskPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalTime getTaskDueDate() {
        return null;
    }
    
    public final boolean getTaskCompleted() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getSubTask() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.betterto_do.tasks.Priority component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalTime component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.betterto_do.tasks.Task copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String taskName, @org.jetbrains.annotations.Nullable
    java.lang.String taskDescription, @org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.Priority taskPriority, @org.jetbrains.annotations.Nullable
    java.time.LocalTime taskDueDate, boolean taskCompleted, @org.jetbrains.annotations.NotNull
    java.lang.Object subTask) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}