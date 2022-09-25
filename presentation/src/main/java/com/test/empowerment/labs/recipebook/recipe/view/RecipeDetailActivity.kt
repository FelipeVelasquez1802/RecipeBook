package com.test.empowerment.labs.recipebook.recipe.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.recipe.viewmodel.RecipeDetailViewModel
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailActivity : ComponentActivity() {

    private val recipeDetailViewModel: RecipeDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recipeId = getRecipeId()
        recipeDetailViewModel.executeGetRecipeDetail(recipeId)
        setContent {
            RecipeBookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RecipeDetail(recipeDetailViewModel = recipeDetailViewModel)
                }
            }
        }
    }

    private fun getRecipeId(): Int {
        val badId = -1
        val recipeId = intent.extras?.getInt(ParamsEnum.RECIPE_ID.value)
        return recipeId ?: badId
    }
}