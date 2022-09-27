package com.test.empowerment.labs.recipebook.recipe.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.service.RecipeService
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.recipe.model.BodyError
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
    val showErrorDialog = mutableStateOf(false)
    val error = mutableStateOf(BodyError())

    fun executeGetRecipe() {
        CoroutineScope(IO).launch {
            try {
                val recipeResult = recipeService.getRecipe()
                recipes.addAll(recipeResult)
            } catch (_: BadIdException) {
                showErrorDialog.value = true
                error.value = BodyError(
                    R.string.error_bad_id_title,
                    R.string.error_bad_id_description
                )
            } catch (_: EmptyValueException) {
                showErrorDialog.value = true
                error.value = BodyError(
                    R.string.error_empty_value_title,
                    R.string.error_empty_value_description
                )
            } finally {
                requestComplete.value = true
            }
        }
    }

    fun executeGetRecipeByKeyWord(keyWord: String) {
        CoroutineScope(IO).launch {
            try {
                val recipeResult = recipeService.getRecipeByKeyWord(keyWord = keyWord)
                recipes.clear()
                recipes.addAll(recipeResult)
                showTextHelp.value = false
            } catch (_: BadIdException) {
                showErrorDialog.value = true
                error.value = BodyError(
                    R.string.error_bad_id_title,
                    R.string.error_bad_id_description
                )
            } catch (_: EmptyValueException) {
                showTextHelp.value = true
            } finally {
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