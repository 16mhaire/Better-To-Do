package com.example.betterto_do.dependencyinjection;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/betterto_do/dependencyinjection/AppModule;", "", "()V", "provideTaskDatabase", "Lcom/example/betterto_do/tasks/TaskDatabase;", "app", "Landroid/app/Application;", "provideTaskRepository", "Lcom/example/betterto_do/tasks/TaskRepository;", "database", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.betterto_do.dependencyinjection.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.betterto_do.tasks.TaskDatabase provideTaskDatabase(@org.jetbrains.annotations.NotNull
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.betterto_do.tasks.TaskRepository provideTaskRepository(@org.jetbrains.annotations.NotNull
    com.example.betterto_do.tasks.TaskDatabase database) {
        return null;
    }
}