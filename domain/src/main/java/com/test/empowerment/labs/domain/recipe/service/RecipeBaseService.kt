package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.recipe.repository.RecipeBaseRepository

abstract class RecipeBaseService<Repository : RecipeBaseRepository>(protected val repository: Repository) {

    fun setIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        if (id < 1) {
            val message = "This is bad id"
            throw BadIdException(message)
        }
        return repository.updateIsFavoriteRecipe(id, isFavorite)
    }
}