package com.test.empowerment.labs.recipebook.recipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import com.test.empowerment.labs.domain.recipe.service.RecipeDetailService
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeDetailRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RecipeDetailViewModel : ViewModel() {

    private var recipeDetailService: RecipeDetailService

    init {
        val recipeDetailRepository: RecipeDetailRepository = RecipeDetailRepositoryImpl()
        recipeDetailService = RecipeDetailService(recipeDetailRepository)
    }

    var recipeDetail: MutableLiveData<RecipeDetail> = MutableLiveData()

    fun executeGetRecipeDetail(id: Int) {
        CoroutineScope(IO).launch {
            val result: RecipeDetail = recipeDetailService.getRecipeDetail(id)
            recipeDetail.postValue(result)
        }
    }
}