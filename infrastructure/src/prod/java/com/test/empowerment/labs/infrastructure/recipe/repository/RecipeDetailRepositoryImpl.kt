package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.exception.NullObjectException
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import com.test.empowerment.labs.infrastructure.BuildConfig
import com.test.empowerment.labs.infrastructure.common.api.ConfigApi
import com.test.empowerment.labs.infrastructure.common.database.DatabaseConfig
import com.test.empowerment.labs.infrastructure.recipe.api.RecipeDetailApi
import com.test.empowerment.labs.infrastructure.recipe.database.entity.FavoriteRecipe
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeDetailTranslate
import javax.inject.Inject

class RecipeDetailRepositoryImpl @Inject constructor(database: DatabaseConfig) :
    RecipeDetailRepository {

    private val favoriteRecipeDao = database.favoriteRecipe()

    private val api = ConfigApi.getApi(RecipeDetailApi::class.java)

    override fun selectRecipeDetail(id: Int): RecipeDetail {
        val apiKey = BuildConfig.API_KEY
        val recipeDetailDtoCall = api.selectRecipeDetail(recipeId = id, apiKey)
        val recipeDetailDtoResponse = recipeDetailDtoCall.execute()
        val recipeDetailDto = recipeDetailDtoResponse.body() ?: throw NullObjectException()
        recipeDetailDto.isFavorite = isFavorite(id)
        return RecipeDetailTranslate.fromRecipeDetailDtoToModel(recipeDetailDto)
    }

    private fun isFavorite(recipeId: Int): Boolean {
        val exists = favoriteRecipeDao.exists(recipeId)
        if (exists) {
            return favoriteRecipeDao.isFavorite(recipeId)
        }
        return false
    }

    override fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        val exists = favoriteRecipeDao.exists(id)
        val favoriteRecipe = FavoriteRecipe(id, isFavorite)
        if (exists) favoriteRecipeDao.update(favoriteRecipe)
        else favoriteRecipeDao.insert(favoriteRecipe)
        return favoriteRecipeDao.isFavorite(id)
    }
}