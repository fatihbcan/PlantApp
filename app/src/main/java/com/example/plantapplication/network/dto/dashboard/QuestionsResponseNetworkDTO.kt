package com.example.plantapplication.network.dto.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponseNetworkDTO (
    val title: String,
    val image_uri: String,
    val uri: String,
    val order: Int
)