package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import javax.inject.Inject

class RecipeDetailService @Inject constructor(private val recipeDetailRepository: RecipeDetailRepository) :
    RecipeBaseService<RecipeDetailRepository>(recipeDetailRepository) {
    fun getRecipeDetail(id: Int): RecipeDetail {
        if (id < 0) {
            val message = "This is bad ID"
            throw BadIdException(message)
        }
        return recipeDetailRepository.selectRecipeDetail(id)
    }
}