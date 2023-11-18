package com.example.betterto_do.util;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataStoreRepository_Factory implements Factory<DataStoreRepository> {
  private final Provider<Context> contextProvider;

  public DataStoreRepository_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DataStoreRepository get() {
    return newInstance(contextProvider.get());
  }

  public static DataStoreRepository_Factory create(Provider<Context> contextProvider) {
    return new DataStoreRepository_Factory(contextProvider);
  }

  public static DataStoreRepository newInstance(Context context) {
    return new DataStoreRepository(context);
  }
}
