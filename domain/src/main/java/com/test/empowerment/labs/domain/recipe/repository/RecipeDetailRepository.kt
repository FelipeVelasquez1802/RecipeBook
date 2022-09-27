package com.test.empowerment.labs.domain.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.RecipeDetail

interface RecipeDetailRepository: RecipeBaseRepository {
    fun selectRecipeDetail(id: Int): RecipeDetail
}