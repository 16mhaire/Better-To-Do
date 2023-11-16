package com.example.betterto_do.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent;", "", "()V", "OnAddTaskClick", "OnDeleteTaskClick", "OnDoneChange", "OnTaskClick", "OnUndoDeleteTaskClick", "Lcom/example/betterto_do/util/TaskEvent$OnAddTaskClick;", "Lcom/example/betterto_do/util/TaskEvent$OnDeleteTaskClick;", "Lcom/example/betterto_do/util/TaskEvent$OnDoneChange;", "Lcom/example/betterto_do/util/TaskEvent$OnTaskClick;", "Lcom/example/betterto_do/util/TaskEvent$OnUndoDeleteTaskClick;", "app_debug"})
public abstract class TaskEvent {
    
    private TaskEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent$OnAddTaskClick;", "Lcom/example/betterto_do/util/TaskEvent;", "()V", "app_debug"})
    public static final class OnAddTaskClick extends com.example.betterto_do.util.TaskEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.example.betterto_do.util.TaskEvent.OnAddTaskClick INSTANCE = null;
        
        private OnAddTaskClick() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent$OnDeleteTaskClick;", "Lcom/example/betterto_do/util/TaskEvent;", "task", "Lcom/example/betterto_do/tasks/Task;", "(Lcom/example/betterto_do/tasks/Task;)V", "getTask", "()Lcom/example/betterto_do/tasks/Task;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnDeleteTaskClick extends com.example.betterto_do.util.TaskEvent {
        @org.jetbrains.annotations.NotNull
        private final com.example.betterto_do.tasks.Task task = null;
        
        public OnDeleteTaskClick(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task getTask() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.util.TaskEvent.OnDeleteTaskClick copy(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent$OnDoneChange;", "Lcom/example/betterto_do/util/TaskEvent;", "task", "Lcom/example/betterto_do/tasks/Task;", "taskCompleted", "", "(Lcom/example/betterto_do/tasks/Task;Z)V", "getTask", "()Lcom/example/betterto_do/tasks/Task;", "getTaskCompleted", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnDoneChange extends com.example.betterto_do.util.TaskEvent {
        @org.jetbrains.annotations.NotNull
        private final com.example.betterto_do.tasks.Task task = null;
        private final boolean taskCompleted = false;
        
        public OnDoneChange(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task, boolean taskCompleted) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task getTask() {
            return null;
        }
        
        public final boolean getTaskCompleted() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.util.TaskEvent.OnDoneChange copy(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task, boolean taskCompleted) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent$OnTaskClick;", "Lcom/example/betterto_do/util/TaskEvent;", "task", "Lcom/example/betterto_do/tasks/Task;", "(Lcom/example/betterto_do/tasks/Task;)V", "getTask", "()Lcom/example/betterto_do/tasks/Task;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnTaskClick extends com.example.betterto_do.util.TaskEvent {
        @org.jetbrains.annotations.NotNull
        private final com.example.betterto_do.tasks.Task task = null;
        
        public OnTaskClick(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task getTask() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.tasks.Task component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.betterto_do.util.TaskEvent.OnTaskClick copy(@org.jetbrains.annotations.NotNull
        com.example.betterto_do.tasks.Task task) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/betterto_do/util/TaskEvent$OnUndoDeleteTaskClick;", "Lcom/example/betterto_do/util/TaskEvent;", "()V", "app_debug"})
    public static final class OnUndoDeleteTaskClick extends com.example.betterto_do.util.TaskEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.example.betterto_do.util.TaskEvent.OnUndoDeleteTaskClick INSTANCE = null;
        
        private OnUndoDeleteTaskClick() {
        }
    }
}