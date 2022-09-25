package com.test.empowerment.labs.recipebook.recipe.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.test.empowerment.labs.recipebook.recipe.viewmodel.RecipeViewModel
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme

class RecipeActivity : ComponentActivity() {

    private var recipeViewModel: RecipeViewModel = RecipeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeViewModel.executeGetRecipe()
        setContent {
            RecipeBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Recipes(recipeViewModel = recipeViewModel)
                }
            }
        }
    }
}