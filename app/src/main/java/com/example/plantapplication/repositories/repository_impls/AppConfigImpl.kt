package com.example.plantapplication.repositories.repository_impls

import android.content.SharedPreferences
import com.example.plantapplication.repositories.AppConfig
import javax.inject.Inject

class AppConfigImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AppConfig {

    override fun shouldShowOnboarding(): Boolean {
        return sharedPreferences.getBoolean(SHOULD_SHOW_ONBOARDING, true)
    }

    override fun setShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences.edit().putBoolean(SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    companion object {
        private const val SHOULD_SHOW_ONBOARDING = "SHOULD_SHOW_ONBOARDING"
    }
}