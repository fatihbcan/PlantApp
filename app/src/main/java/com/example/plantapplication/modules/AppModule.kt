package com.example.plantapplication.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.plantapplication.repositories.AppConfig
import com.example.plantapplication.repositories.DashboardRepository
import com.example.plantapplication.repositories.repository_impls.AppConfigImpl
import com.example.plantapplication.repositories.repository_impls.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AppModule {

    companion object {
        private const val APP_CONFIG = "APP_CONFIG"

        @Provides
        fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
            return appContext.getSharedPreferences(APP_CONFIG, Context.MODE_PRIVATE)
        }
    }

    @Binds
    fun bindPlantRepository(plantRepositoryImpl: DashboardRepositoryImpl): DashboardRepository

    @Binds
    fun bindAppConfig(appConfigImpl: AppConfigImpl): AppConfig
}