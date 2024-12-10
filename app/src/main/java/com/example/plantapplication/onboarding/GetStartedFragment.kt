package com.example.plantapplication.onboarding


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.R
import com.example.plantapplication.databinding.FragmentGetStartedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartedFragment : Fragment(R.layout.fragment_get_started) {

    private var _binding : FragmentGetStartedBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGetStartedBinding.bind(view)

        binding.getStartedButton.setOnClickListener {
            Log.d("Fatih","get start button clicked")
            val action =
                GetStartedFragmentDirections.actionGetStartedFragmentToOnboardingFirstFragment()
            findNavController().navigate(action)
        }
    }
}