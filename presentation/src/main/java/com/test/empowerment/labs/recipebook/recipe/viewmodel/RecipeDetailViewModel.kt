package com.test.empowerment.labs.recipebook.recipe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.empowerment.labs.domain.exception.BadValueTimeException
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.service.RecipeDetailService
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.recipe.model.BodyError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var recipeDetailService: RecipeDetailService

    var recipeDetail: MutableLiveData<RecipeDetail> = MutableLiveData()

    val requestComplete = mutableStateOf(false)
    val showErrorDialog = mutableStateOf(false)
    val error = mutableStateOf(BodyError())

    fun executeGetRecipeDetail(id: Int) {
        CoroutineScope(IO).launch {
            try {
                val result: RecipeDetail = recipeDetailService.getRecipeDetail(id)
                recipeDetail.postValue(result)
            } catch (exception: Exception) {
                showErrorDialog.value = true
                var titleId = R.string.error_bad_id_title
                var descriptionId = R.string.error_bad_id_description
                if (exception is BadValueTimeException) {
                    titleId = R.string.error_bad_value_time_title
                    descriptionId = R.string.error_bad_value_time_description
                }
                error.value = BodyError(titleId, descriptionId)
            } finally {
                requestComplete.value = true
            }
        }
    }

    fun executeSetIsFavoriteRecipe(id: Int, isFavorite: Boolean) {
        CoroutineScope(IO).launch {
            recipeDetailService.setIsFavoriteRecipe(id, isFavorite)
        }
    }
}