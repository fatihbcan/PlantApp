package com.example.plantapplication.repositories.repository_impls

import android.util.Log
import com.example.plantapplication.network.api.PlantApi
import com.example.plantapplication.network.mappers.toCategoriesItem
import com.example.plantapplication.network.mappers.toQuestionsItem
import com.example.plantapplication.repositories.DashboardRepository
import com.example.plantapplication.repositories.results.GetCategoriesResult
import com.example.plantapplication.repositories.results.GetQuestionsResult
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val plantApi: PlantApi
) : DashboardRepository {

    override suspend fun getCategories(): GetCategoriesResult {
        return when (val res = plantApi.getCategories()) {
            is NetworkResponse.Success ->  {
                GetCategoriesResult.Success(res.body.toCategoriesItem())
            }
            is NetworkResponse.ServerError -> {
                GetCategoriesResult.Error.Unknown()
            }
            is NetworkResponse.NetworkError -> {
                GetCategoriesResult.Error.Unknown()
            }
            is NetworkResponse.UnknownError -> {
                GetCategoriesResult.Error.Unknown()
            }
        }
    }

    override suspend fun getQuestions(): GetQuestionsResult {
        return when (val res = plantApi.getQuestions()) {
            is NetworkResponse.Success -> GetQuestionsResult.Success(res.body.toQuestionsItem())
            is NetworkResponse.ServerError -> GetQuestionsResult.Error.Unknown()
            is NetworkResponse.NetworkError -> GetQuestionsResult.Error.Unknown()
            is NetworkResponse.UnknownError -> GetQuestionsResult.Error.Unknown()
        }
    }
}