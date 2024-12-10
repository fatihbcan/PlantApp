package com.example.plantapplication.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.R
import com.example.plantapplication.databinding.FragmentOnboardingFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFirstFragment : Fragment(R.layout.fragment_onboarding_first) {

    private var _binding : FragmentOnboardingFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnboardingFirstBinding.bind(view)

        binding.continueButton.setOnClickListener {
            val action = OnboardingFirstFragmentDirections.actionOnboardingFirstFragmentToOnboardingSecondFragment()
            findNavController().navigate(action)
        }
    }
}