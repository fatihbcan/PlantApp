package com.example.plantapplication.usecases

import com.example.plantapplication.repositories.DashboardRepository
import com.example.plantapplication.repositories.results.GetQuestionsResult
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {

    suspend operator fun invoke() : GetQuestionsResult {
        return dashboardRepository.getQuestions()
    }
}