package com.example.plantapplication.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.R
import com.example.plantapplication.databinding.FragmentOnboardingSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingSecondFragment : Fragment(R.layout.fragment_onboarding_second) {

    private var _binding : FragmentOnboardingSecondBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnboardingSecondBinding.bind(view)

        binding.continueButton.setOnClickListener {
            val action = OnboardingSecondFragmentDirections.actionOnboardingSecondFragmentToOnboardingThirdFragment()
            findNavController().navigate(action)
        }
    }
}