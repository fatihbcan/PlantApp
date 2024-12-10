package com.example.plantapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.plantapplication.dashboard.DashboardActivity
import com.example.plantapplication.repositories.AppConfig
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    @Inject
    lateinit var appConfig: AppConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(appConfig.shouldShowOnboarding()) {
            setContentView(R.layout.activity_main)
        } else {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
    }
}