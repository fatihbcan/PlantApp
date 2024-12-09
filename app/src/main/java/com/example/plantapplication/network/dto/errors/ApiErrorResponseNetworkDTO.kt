package com.example.plantapplication.network.dto.errors

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiErrorResponseNetworkDTO(
    @SerialName("errors")
    val errors: List<ApiErrorNetworkDTO>?
) {

    @Serializable
    data class ApiErrorNetworkDTO(
        val code: String
    )
}