package com.test.empowerment.labs.infrastructure.recipe.api

import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDetailDto
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipeDetailPath
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipeDetailPath.RECIPE_ID
import com.test.empowerment.labs.infrastructure.recipe.enums.RecipePath.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeDetailApi {
    @GET(RecipeDetailPath.RECIPE)
    fun selectRecipeDetail(
        @Path(RECIPE_ID) recipeId: Int,
        @Query(API_KEY) apiKey: String
    ): Call<RecipeDetailDto>
}