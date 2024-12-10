package com.example.plantapplication.onboarding

import androidx.lifecycle.ViewModel
import com.example.plantapplication.R
import com.example.plantapplication.onboarding.models.PaywallFeaturedItems
import com.example.plantapplication.onboarding.models.PremiumOptionModel
import com.example.plantapplication.repositories.AppConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingThirdViewModel @Inject constructor(
    private val appConfig: AppConfig
): ViewModel() {

    val featuredItems = listOf(
        PaywallFeaturedItems(
            R.drawable.paywall_card_icon_unlimited,
            R.string.unlimited,
            R.string.plant_identify
        ),
        PaywallFeaturedItems(
            R.drawable.paywall_card_icon_faster,
            R.string.faster,
            R.string.process
        ),
        PaywallFeaturedItems(
            R.drawable.paywall_card_icon_unlimited,
            R.string.unlimited,
            R.string.plant_identify
        ),
        PaywallFeaturedItems(
            R.drawable.paywall_card_icon_faster,
            R.string.faster,
            R.string.process
        )
    )


    val premiumOptions = arrayListOf(
        PremiumOptionModel(
            title = R.string.one_month,
            subtitle = R.string.one_month_price,
            isChecked = false,
            isFeatured = false
        ),
        PremiumOptionModel(
            title = R.string.one_year,
            subtitle = R.string.one_year_price,
            isChecked = false,
            isFeatured = true
        )
    )

    fun setOnboardingCompleted() {
        appConfig.setShouldShowOnboarding(false)
    }
}