package com.example.plantapplication.usecases

import com.example.plantapplication.repositories.DashboardRepository
import com.example.plantapplication.repositories.results.GetCategoriesResult
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {

    suspend operator fun invoke() : GetCategoriesResult {
        return dashboardRepository.getCategories()
    }
}