package com.example.plantapplication.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.plantapplication.R
import com.example.plantapplication.dashboard.adapter.CategoriesAdapter
import com.example.plantapplication.dashboard.adapter.QuestionsAdapter
import com.example.plantapplication.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {


    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val viewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.categoryList.observe(viewLifecycleOwner) {
            binding.categoriesRecyclerView.adapter = CategoriesAdapter(requireContext(), it)
            binding.categoriesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        viewModel.questionsList.observe(viewLifecycleOwner) {
            binding.questionsRecyclerView.adapter = QuestionsAdapter(requireContext(), it)
            binding.questionsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }


}