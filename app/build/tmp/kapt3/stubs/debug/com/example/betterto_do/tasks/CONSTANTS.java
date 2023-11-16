package com.example.betterto_do.tasks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/betterto_do/tasks/CONSTANTS;", "", "()V", "DATABASE_NAME", "", "DATABASE_TABLE", "LIST_SCREEN_ARG_KEY", "LIST_SCREEN_ROUTE", "LOGIN_SCREEN_ROUTE", "MAX_TITLE_LENGTH", "", "PREFERENCE_KEY", "PREFERENCE_NAME", "SPLASH_SCREEN_ROUTE", "TASK_SCREEN_ARG_KEY", "TASK_SCREEN_ROUTE", "app_debug"})
public final class CONSTANTS {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DATABASE_TABLE = "task_table";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DATABASE_NAME = "task_database";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LIST_SCREEN_ROUTE = "list/{action}";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TASK_SCREEN_ROUTE = "task/{taskID}";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SPLASH_SCREEN_ROUTE = "splash/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LOGIN_SCREEN_ROUTE = "login/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LIST_SCREEN_ARG_KEY = "action";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TASK_SCREEN_ARG_KEY = "taskID";
    public static final int MAX_TITLE_LENGTH = 40;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREFERENCE_NAME = "todo_preference";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREFERENCE_KEY = "sort_order";
    @org.jetbrains.annotations.NotNull
    public static final com.example.betterto_do.tasks.CONSTANTS INSTANCE = null;
    
    private CONSTANTS() {
        super();
    }
}