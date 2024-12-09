package com.example.plantapplication.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.R
import com.example.plantapplication.dashboard.DashboardActivity
import com.example.plantapplication.databinding.FragmentGetStartedBinding
import com.example.plantapplication.databinding.FragmentOnboardingSecondBinding
import com.example.plantapplication.databinding.FragmentOnboardingThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingThirdFragment : Fragment(R.layout.fragment_onboarding_third) {

    private var _binding : FragmentOnboardingThirdBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnboardingThirdBinding.bind(view)

        binding.continueButton.setOnClickListener {
            requireActivity().finish()
            requireActivity().startActivity(Intent(requireContext(), DashboardActivity::class.java))
        }
    }
}