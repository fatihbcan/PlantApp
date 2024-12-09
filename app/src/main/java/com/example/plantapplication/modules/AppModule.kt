package com.example.plantapplication.modules

import com.example.plantapplication.repositories.DashboardRepository
import com.example.plantapplication.repositories.repository_impls.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AppModule {

    @Binds
    fun bindPlantRepository(plantRepositoryImpl: DashboardRepositoryImpl): DashboardRepository

}