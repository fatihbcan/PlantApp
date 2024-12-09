package com.example.plantapplication.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantapplication.repositories.entities.CategoriesItem
import com.example.plantapplication.repositories.entities.QuestionsItem
import com.example.plantapplication.repositories.results.GetCategoriesResult
import com.example.plantapplication.repositories.results.GetQuestionsResult
import com.example.plantapplication.usecases.GetCategoriesUseCase
import com.example.plantapplication.usecases.GetQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getQuestionsUseCase: GetQuestionsUseCase
) : ViewModel() {

    private val _categoryList = MutableLiveData<List<CategoriesItem>>()
    val categoryList: LiveData<List<CategoriesItem>> = _categoryList

    private val _questionList = MutableLiveData<List<QuestionsItem>>()
    val questionsList: LiveData<List<QuestionsItem>> = _questionList

    init {
        loadDataAsync()
    }

    private fun loadDataAsync() {
        viewModelScope.launch {
            val getCategoriesAsync = async { getCategoriesUseCase() }
            val getQuestionsAsync = async { getQuestionsUseCase() }

            val (getCategoriesResult, getQuestionsResult) = getCategoriesAsync.await() to getQuestionsAsync.await()

            when {
                getCategoriesResult is GetCategoriesResult.Success && getQuestionsResult is GetQuestionsResult.Success -> {
                    _categoryList.value = getCategoriesResult.categories
                    _questionList.value = getQuestionsResult.questionsList
                }
                getCategoriesResult is GetCategoriesResult.Success && getQuestionsResult is GetQuestionsResult.Error -> {
                    _categoryList.value = getCategoriesResult.categories
                    Log.d("DashboardViewModel", "Error loading question list data")
                }
                getCategoriesResult is GetCategoriesResult.Error && getQuestionsResult is GetQuestionsResult.Success -> {
                    _questionList.value = getQuestionsResult.questionsList
                    Log.d("DashboardViewModel", "Error loading category list data")
                }
                else -> Log.d("DashboardViewModel", "Error loading data")
            }

        }
    }
}