package com.example.plantapplication.repositories

interface AppConfig {

    fun shouldShowOnboarding(): Boolean

    fun setShouldShowOnboarding(shouldShow: Boolean)

}