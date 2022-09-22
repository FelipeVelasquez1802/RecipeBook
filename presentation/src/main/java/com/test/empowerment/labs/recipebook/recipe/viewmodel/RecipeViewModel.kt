package com.test.empowerment.labs.recipebook.recipe.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.domain.recipe.service.RecipeService
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private var recipeService: RecipeService

    init {
        val recipeRepository: RecipeRepository = RecipeRepositoryImpl()
        recipeService = RecipeService(recipeRepository)
    }

    val recipes: MutableList<Recipe> = mutableStateListOf()

    fun executeGetRecipe() {
        CoroutineScope(IO).launch {
            val recipeResult = recipeService.getRecipe()
            recipes.addAll(recipeResult)
        }
    }
}