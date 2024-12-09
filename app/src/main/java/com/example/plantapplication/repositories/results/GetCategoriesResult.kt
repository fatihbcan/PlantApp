package com.example.plantapplication.repositories.results

import com.example.plantapplication.repositories.entities.CategoriesItem

sealed interface GetCategoriesResult {

    data class Success(val categories: List<CategoriesItem>) : GetCategoriesResult

    sealed interface Error : GetCategoriesResult {

        val cause: Throwable?

        data class Unknown(override val cause: Throwable? = null) : Error
    }
}