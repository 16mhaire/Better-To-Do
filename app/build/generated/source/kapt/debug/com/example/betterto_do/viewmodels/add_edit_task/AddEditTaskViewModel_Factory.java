package com.example.betterto_do.viewmodels.add_edit_task;

import androidx.lifecycle.SavedStateHandle;
import com.example.betterto_do.tasks.TaskRepository;
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
public final class AddEditTaskViewModel_Factory implements Factory<AddEditTaskViewModel> {
  private final Provider<TaskRepository> repositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public AddEditTaskViewModel_Factory(Provider<TaskRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public AddEditTaskViewModel get() {
    return newInstance(repositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static AddEditTaskViewModel_Factory create(Provider<TaskRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new AddEditTaskViewModel_Factory(repositoryProvider, savedStateHandleProvider);
  }

  public static AddEditTaskViewModel newInstance(TaskRepository repository,
      SavedStateHandle savedStateHandle) {
    return new AddEditTaskViewModel(repository, savedStateHandle);
  }
}
