package com.example.plantapplication.network.api

import com.example.plantapplication.network.dto.dashboard.CategoriesResponseNetworkDTO
import com.example.plantapplication.network.dto.dashboard.QuestionsResponseNetworkDTO
import com.example.plantapplication.network.dto.errors.ApiErrorResponseNetworkDTO
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface PlantApi {

    @GET("/getCategories")
    suspend fun getCategories(): NetworkResponse<CategoriesResponseNetworkDTO, ApiErrorResponseNetworkDTO>

    @GET("/getQuestions")
    suspend fun getQuestions(): NetworkResponse<List<QuestionsResponseNetworkDTO>, ApiErrorResponseNetworkDTO>
}