package com.example.plantapplication.onboarding.models

data class PremiumOptionModel(
    val title: Int,
    val subtitle: Int,
    var isChecked: Boolean,
    val isFeatured: Boolean
)
