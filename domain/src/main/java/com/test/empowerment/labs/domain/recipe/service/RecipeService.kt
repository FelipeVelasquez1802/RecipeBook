package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import javax.inject.Inject

class RecipeService @Inject constructor(private val recipeRepository: RecipeRepository) :
    RecipeBaseService<RecipeRepository>(recipeRepository) {
    fun getRecipe(): MutableList<Recipe> = recipeRepository.selectRecipe()
    fun getRecipeByKeyWord(keyWord: String): MutableList<Recipe> {
        if (keyWord.isEmpty()) {
            val message = "This is empty key word"
            throw EmptyValueException(message)
        }
        return recipeRepository.selectRecipeByKeyWord(keyWord)
    }
}