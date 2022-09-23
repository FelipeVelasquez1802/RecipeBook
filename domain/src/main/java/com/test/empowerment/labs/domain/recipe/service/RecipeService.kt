package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository

class RecipeService(private val recipeRepository: RecipeRepository) {
    fun getRecipe(): MutableList<Recipe> = recipeRepository.selectRecipe()
    fun getRecipeByKeyWord(keyWord: String): MutableList<Recipe> {
        if (keyWord.isEmpty()) {
            val message = "This is empty key word"
            throw EmptyValueException(message)
        }
        return recipeRepository.selectRecipeByKeyWord(keyWord)
    }
}