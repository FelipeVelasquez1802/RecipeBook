package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.exception.NullObjectException
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import com.test.empowerment.labs.infrastructure.BuildConfig
import com.test.empowerment.labs.infrastructure.common.api.ConfigApi
import com.test.empowerment.labs.infrastructure.recipe.api.RecipeDetailApi
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeDetailTranslate
import javax.inject.Inject

class RecipeDetailRepositoryImpl @Inject constructor(): RecipeDetailRepository {

    private val api = ConfigApi.getApi(RecipeDetailApi::class.java)

    override fun selectRecipeDetail(id: Int): RecipeDetail {
        val apiKey = BuildConfig.API_KEY
        val recipeDetailDtoCall = api.selectRecipeDetail(recipeId = id, apiKey)
        val recipeDetailDtoResponse = recipeDetailDtoCall.execute()
        val recipeDetailDto = recipeDetailDtoResponse.body() ?: throw NullObjectException()
        return RecipeDetailTranslate.fromRecipeDetailDtoToModel(recipeDetailDto)
    }

    override fun updateIsFavoriteRecipe(id: Int, isFavorite: Boolean): Boolean {
        TODO("Not yet implemented")
    }
}