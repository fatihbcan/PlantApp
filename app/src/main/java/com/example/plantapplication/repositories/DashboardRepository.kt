package com.example.plantapplication.repositories

import com.example.plantapplication.repositories.results.GetCategoriesResult
import com.example.plantapplication.repositories.results.GetQuestionsResult

interface DashboardRepository {

    suspend fun getCategories(): GetCategoriesResult

    suspend fun getQuestions(): GetQuestionsResult
}