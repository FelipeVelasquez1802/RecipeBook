package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.infrastructure.common.translate.IngredientTranslate
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDetailDto

class RecipeDetailTranslate {
    companion object {
        fun fromRecipeDetailDtoToModel(recipeDetailDto: RecipeDetailDto): RecipeDetail {
            val ingredients =
                IngredientTranslate.fromIngredientsDtoToModel(recipeDetailDto.ingredients)
            return RecipeDetail(
                recipeDetailDto.id,
                recipeDetailDto.title,
                recipeDetailDto.imagePath,
                recipeDetailDto.summary,
                recipeDetailDto.readyInMinute,
                ingredients
            )
        }
    }
}