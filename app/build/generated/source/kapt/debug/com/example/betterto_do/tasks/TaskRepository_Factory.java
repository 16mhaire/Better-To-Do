package com.example.betterto_do.tasks;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TaskRepository_Factory implements Factory<TaskRepository> {
  private final Provider<TaskDAO> taskDAOProvider;

  public TaskRepository_Factory(Provider<TaskDAO> taskDAOProvider) {
    this.taskDAOProvider = taskDAOProvider;
  }

  @Override
  public TaskRepository get() {
    return newInstance(taskDAOProvider.get());
  }

  public static TaskRepository_Factory create(Provider<TaskDAO> taskDAOProvider) {
    return new TaskRepository_Factory(taskDAOProvider);
  }

  public static TaskRepository newInstance(TaskDAO taskDAO) {
    return new TaskRepository(taskDAO);
  }
}
