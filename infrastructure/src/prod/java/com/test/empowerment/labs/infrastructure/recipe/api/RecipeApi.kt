package com.test.empowerment.labs.infrastructure.recipe.api

import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeResultDto
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.API_KEY
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.KEY_WORD
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.NUMBER
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.RECIPES
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.RECIPE_BY_KEY_WORD
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET(RECIPES)
    fun selectRecipe(@Query(API_KEY) apiKey: String): Call<RecipeResultDto>

    @GET(RECIPE_BY_KEY_WORD)
    fun selectRecipeByKeyWord(
        @Query(KEY_WORD) keyWord: String,
        @Query(API_KEY) apiKey: String,
        @Query(NUMBER) number: Int
    ): Call<MutableList<RecipeDto>>
}