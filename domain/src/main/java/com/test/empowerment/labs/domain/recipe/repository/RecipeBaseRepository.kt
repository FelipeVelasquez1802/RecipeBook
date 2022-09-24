package com.test.empowerment.labs.domain.recipe.repository

interface RecipeBaseRepository {
    fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean
}