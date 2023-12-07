package com.example.betterto_do.viewmodels;

import com.example.betterto_do.tasks.TaskRepository;
import com.example.betterto_do.tasks.subtasks.SubTaskRepository;
import com.example.betterto_do.util.DataStoreRepository;
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
public final class SharedViewModel_Factory implements Factory<SharedViewModel> {
  private final Provider<TaskRepository> repositoryProvider;

  private final Provider<SubTaskRepository> subTaskRepositoryProvider;

  private final Provider<DataStoreRepository> dataStoreRepositoryProvider;

  public SharedViewModel_Factory(Provider<TaskRepository> repositoryProvider,
      Provider<SubTaskRepository> subTaskRepositoryProvider,
      Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.subTaskRepositoryProvider = subTaskRepositoryProvider;
    this.dataStoreRepositoryProvider = dataStoreRepositoryProvider;
  }

  @Override
  public SharedViewModel get() {
    return newInstance(repositoryProvider.get(), subTaskRepositoryProvider.get(), dataStoreRepositoryProvider.get());
  }

  public static SharedViewModel_Factory create(Provider<TaskRepository> repositoryProvider,
      Provider<SubTaskRepository> subTaskRepositoryProvider,
      Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    return new SharedViewModel_Factory(repositoryProvider, subTaskRepositoryProvider, dataStoreRepositoryProvider);
  }

  public static SharedViewModel newInstance(TaskRepository repository,
      SubTaskRepository subTaskRepository, DataStoreRepository dataStoreRepository) {
    return new SharedViewModel(repository, subTaskRepository, dataStoreRepository);
  }
}
