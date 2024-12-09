package com.example.plantapplication.network.mappers

import com.example.plantapplication.network.dto.dashboard.CategoriesResponseNetworkDTO
import com.example.plantapplication.network.dto.dashboard.QuestionsResponseNetworkDTO
import com.example.plantapplication.repositories.entities.CategoriesItem
import com.example.plantapplication.repositories.entities.QuestionsItem

internal fun CategoriesResponseNetworkDTO.toCategoriesItem(): List<CategoriesItem> {
    return this.data.sortedBy { it.rank }.map {
        CategoriesItem(
            title = it.title.replace(" ", "\n"),
            imageUrl = it.image.url
        )
    }
}

internal fun List<QuestionsResponseNetworkDTO>.toQuestionsItem(): List<QuestionsItem> {
    return this.sortedBy { it.order }.map {
        QuestionsItem(
            title = it.title,
            imageUrl = it.image_uri,
            redirectUrl = it.uri,
            order = it.order
        )
    }
}