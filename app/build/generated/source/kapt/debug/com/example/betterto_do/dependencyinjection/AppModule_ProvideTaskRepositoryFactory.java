package com.example.betterto_do.dependencyinjection;

import com.example.betterto_do.tasks.TaskDatabase;
import com.example.betterto_do.tasks.TaskRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideTaskRepositoryFactory implements Factory<TaskRepository> {
  private final Provider<TaskDatabase> databaseProvider;

  public AppModule_ProvideTaskRepositoryFactory(Provider<TaskDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TaskRepository get() {
    return provideTaskRepository(databaseProvider.get());
  }

  public static AppModule_ProvideTaskRepositoryFactory create(
      Provider<TaskDatabase> databaseProvider) {
    return new AppModule_ProvideTaskRepositoryFactory(databaseProvider);
  }

  public static TaskRepository provideTaskRepository(TaskDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTaskRepository(database));
  }
}
