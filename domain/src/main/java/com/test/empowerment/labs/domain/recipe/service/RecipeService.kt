package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository

class RecipeService(private val recipeRepository: RecipeRepository) {
    fun getRecipe(): MutableList<Recipe> = recipeRepository.selectRecipe()
}