package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.infrastructure.BuildConfig
import com.test.empowerment.labs.infrastructure.common.api.ConfigApi
import com.test.empowerment.labs.infrastructure.common.database.DatabaseConfig
import com.test.empowerment.labs.infrastructure.recipe.api.RecipeApi
import com.test.empowerment.labs.infrastructure.recipe.database.entity.FavoriteRecipe
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeResultDto
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeTranslate
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(database: DatabaseConfig) : RecipeRepository {

    private val favoriteRecipeDao = database.favoriteRecipe()

    private val api = ConfigApi.getApi(RecipeApi::class.java)

    override fun selectRecipe(): MutableList<Recipe> {
        val apiKey = BuildConfig.API_KEY
        val recipesDtoCall = api.selectRecipe(apiKey)
        val recipesDtoResponse = recipesDtoCall.execute()
        val recipesDto = recipesDtoResponse.body() ?: RecipeResultDto(mutableListOf())
        val results = recipesDto.results
        val favoritesRecipe = favoriteRecipeDao.select()
        favoritesRecipe.forEach { favoriteRecipe ->
            results.find { recipeDto ->
                recipeDto.id == favoriteRecipe.recipeId
            }?.isFavorite = favoriteRecipe.isFavorite
        }
        return RecipeTranslate.fromListDtoToListModel(results)
    }

    override fun selectRecipeByKeyWord(keyWord: String): MutableList<Recipe> {
        val apiKey = BuildConfig.API_KEY
        val numberResponse = 25
        val recipesDtoCall = api.selectRecipeByKeyWord(keyWord, apiKey, number = numberResponse)
        val recipesDtoResponse = recipesDtoCall.execute()
        val recipesDto = recipesDtoResponse.body() ?: mutableListOf()
        return RecipeTranslate.fromListDtoToListModel(recipesDto)
    }

    override fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        val exists = favoriteRecipeDao.exists(id)
        val favoriteRecipe = FavoriteRecipe(id, isFavorite)
        if (exists) favoriteRecipeDao.update(favoriteRecipe)
        else favoriteRecipeDao.insert(favoriteRecipe)
        return favoriteRecipeDao.isFavorite(id)
    }
}