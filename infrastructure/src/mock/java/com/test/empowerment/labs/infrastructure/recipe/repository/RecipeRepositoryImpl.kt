package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeTranslate

class RecipeRepositoryImpl : RecipeRepository {

    private val recipesDto = mutableListOf(
        RecipeDto(
            id = 716426,
            title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
            imagePath = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            isFavorite = false
        ),
        RecipeDto(
            id = 715594,
            title = "Homemade Garlic and Basil French Fries",
            imagePath = "https://spoonacular.com/recipeImages/715594-312x231.jpg",
            isFavorite = false
        ),
        RecipeDto(
            id = 715497,
            title = "Berry Banana Breakfast Smoothie",
            imagePath = "https://spoonacular.com/recipeImages/715497-312x231.jpg",
            isFavorite = false
        )
    )

    override fun selectRecipe(): MutableList<Recipe> =
        RecipeTranslate.fromListDtoToListModel(recipesDto)

    override fun selectRecipeByKeyWord(keyWord: String): MutableList<Recipe> {
        val recipeFilter = recipesDto.filter { recipeDto ->
            recipeDto.title.lowercase().contains(keyWord.lowercase())
        }.toMutableList()
        return RecipeTranslate.fromListDtoToListModel(recipeFilter)
    }

    override fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        recipesDto.find { recipeDto -> recipeDto.id == id }?.let { recipeDto ->
            recipeDto.isFavorite = isFavorite
            return true
        } ?: run {
            return false
        }
    }

}