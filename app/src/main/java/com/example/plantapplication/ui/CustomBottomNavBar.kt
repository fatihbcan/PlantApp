package com.example.plantapplication.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.plantapplication.databinding.CustomBottomNavBarBinding

class CustomBottomNavBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: CustomBottomNavBarBinding =
        CustomBottomNavBarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        // Initialize the custom view
        binding.navHome.setOnClickListener {
            Log.d("CustomBottomNavBar", "Home button clicked")
        }
    }

}