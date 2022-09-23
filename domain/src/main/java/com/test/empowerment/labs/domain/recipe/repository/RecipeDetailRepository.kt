package com.test.empowerment.labs.domain.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.RecipeDetail

interface RecipeDetailRepository {
    fun selectRecipeDetail(id: Int): RecipeDetail
}