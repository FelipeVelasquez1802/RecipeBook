package com.test.empowerment.labs.domain.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.Recipe

interface RecipeRepository {
    fun selectRecipe(): MutableList<Recipe>
    fun selectRecipeByKeyWord(keyWord: String): MutableList<Recipe>
}