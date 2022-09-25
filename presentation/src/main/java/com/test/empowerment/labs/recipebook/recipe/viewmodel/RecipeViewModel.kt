package com.test.empowerment.labs.recipebook.recipe.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.service.RecipeService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var recipeService: RecipeService

    val recipes: MutableList<Recipe> = mutableStateListOf()
    val requestComplete = mutableStateOf(false)
    var showTextHelp = mutableStateOf(false)

    fun executeGetRecipe() {
        CoroutineScope(IO).launch {
            val recipeResult = recipeService.getRecipe()
            recipes.addAll(recipeResult)
            requestComplete.value = true
        }
    }

    fun executeGetRecipeByKeyWord(keyWord: String) {
        CoroutineScope(IO).launch {
            try {
                val recipeResult = recipeService.getRecipeByKeyWord(keyWord = keyWord)
                recipes.clear()
                recipes.addAll(recipeResult)
                showTextHelp.value = false
                requestComplete.value = true
            } catch (_: EmptyValueException) {
                showTextHelp.value = true
                requestComplete.value = true
            }
        }
    }

    fun executeSetIsFavoriteRecipe(id: Int, isFavorite: Boolean) {
        CoroutineScope(IO).launch {
            recipeService.setIsFavoriteRecipe(id, isFavorite)
        }
    }
}