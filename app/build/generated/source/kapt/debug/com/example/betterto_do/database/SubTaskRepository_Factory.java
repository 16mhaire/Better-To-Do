package com.example.betterto_do.database;

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
public final class SubTaskRepository_Factory implements Factory<SubTaskRepository> {
  private final Provider<SubTaskDAO> subTaskDAOProvider;

  public SubTaskRepository_Factory(Provider<SubTaskDAO> subTaskDAOProvider) {
    this.subTaskDAOProvider = subTaskDAOProvider;
  }

  @Override
  public SubTaskRepository get() {
    return newInstance(subTaskDAOProvider.get());
  }

  public static SubTaskRepository_Factory create(Provider<SubTaskDAO> subTaskDAOProvider) {
    return new SubTaskRepository_Factory(subTaskDAOProvider);
  }

  public static SubTaskRepository newInstance(SubTaskDAO subTaskDAO) {
    return new SubTaskRepository(subTaskDAO);
  }
}
