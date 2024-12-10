package com.example.plantapplication.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantapplication.R
import com.example.plantapplication.dashboard.DashboardActivity
import com.example.plantapplication.databinding.FragmentOnboardingThirdBinding
import com.example.plantapplication.onboarding.adapter.PaywallFeaturedAdapter
import com.example.plantapplication.onboarding.adapter.PremiumOptionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingThirdFragment : Fragment(R.layout.fragment_onboarding_third) {

    private var _binding : FragmentOnboardingThirdBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OnboardingThirdViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnboardingThirdBinding.bind(view)

        binding.paywallFeaturedCards.adapter = PaywallFeaturedAdapter(requireContext(), viewModel.featuredItems)
        binding.paywallFeaturedCards.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.premiumOptions.adapter = PremiumOptionsAdapter(requireContext(), viewModel.premiumOptions) { clickedItem ->
            viewModel.premiumOptions.map {
                if (clickedItem.title != it.title) {
                    it.isChecked = false
                } else {
                    it.isChecked = true
                }
            }
            binding.premiumOptions.adapter?.notifyDataSetChanged()
        }
        binding.premiumOptions.layoutManager = LinearLayoutManager(requireContext())

        binding.tryFreeButton.setOnClickListener {
           goToDashboard()
        }

        binding.closeButton.setOnClickListener {
            goToDashboard()
        }
    }

    private fun goToDashboard() {
        viewModel.setOnboardingCompleted()
        requireActivity().finish()
        requireActivity().startActivity(Intent(requireContext(), DashboardActivity::class.java))

    }
}