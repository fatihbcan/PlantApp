package com.example.plantapplication.repositories.results

import com.example.plantapplication.repositories.entities.QuestionsItem

sealed interface GetQuestionsResult {

    data class Success(val questionsList: List<QuestionsItem>) : GetQuestionsResult

    sealed interface Error : GetQuestionsResult {

        val cause: Throwable?

        data class Unknown(override val cause: Throwable? = null) : Error
    }
}