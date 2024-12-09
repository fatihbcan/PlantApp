package com.example.plantapplication.network.dto.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponseNetworkDTO (
    val data : List<CategoryResponseNetworkDTO>
) {

    @Serializable
    data class CategoryResponseNetworkDTO (
        val rank: Int,
        val title: String,
        val image: ImageResponseNetworkDTO
    )

    @Serializable
    data class ImageResponseNetworkDTO(
        val url : String
    )
}