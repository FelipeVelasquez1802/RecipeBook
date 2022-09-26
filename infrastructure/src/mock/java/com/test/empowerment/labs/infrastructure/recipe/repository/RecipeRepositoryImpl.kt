package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.infrastructure.common.database.DatabaseConfig
import com.test.empowerment.labs.infrastructure.recipe.database.entity.FavoriteRecipe
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeTranslate
import javax.inject.Inject
import com.test.empowerment.labs.domain.recipe.model.Recipe as RecipeModel

class RecipeRepositoryImpl @Inject constructor(database: DatabaseConfig) :
    RecipeRepository {

    private val favoriteRecipeDao = database.favoriteRecipe()

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

    override fun selectRecipe(): MutableList<RecipeModel> {
        val favoritesRecipe = favoriteRecipeDao.select()
        favoritesRecipe.forEach { favoriteRecipe ->
            recipesDto.find { recipeDto ->
                recipeDto.id == favoriteRecipe.recipeId
            }?.isFavorite = favoriteRecipe.isFavorite
        }
        return RecipeTranslate.fromListDtoToListModel(recipesDto)
    }

    override fun selectRecipeByKeyWord(keyWord: String): MutableList<RecipeModel> {
        val recipeFilter = recipesDto.filter { recipeDto ->
            recipeDto.title.lowercase().contains(keyWord.lowercase())
        }.toMutableList()
        return RecipeTranslate.fromListDtoToListModel(recipeFilter)
    }

    override fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        val exists = favoriteRecipeDao.exists(id)
        val favoriteRecipe = FavoriteRecipe(id, isFavorite)
        if (exists) favoriteRecipeDao.update(favoriteRecipe)
        else favoriteRecipeDao.insert(favoriteRecipe)
        return favoriteRecipeDao.isFavorite(id)
    }

}