package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.infrastructure.ingredient.translate.IngredientTranslate
import com.test.empowerment.labs.infrastructure.instruction.translate.InstructionTranslate
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeAndDetail
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeDetail
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDetailDto
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail as RecipeDetailModel

class RecipeDetailTranslate {
    companion object {
        fun fromRecipeDetailDtoToModel(recipeDetailDto: RecipeDetailDto): RecipeDetailModel {
            val ingredients =
                IngredientTranslate.fromIngredientsDtoToModel(recipeDetailDto.ingredients)
            val instructions =
                InstructionTranslate.fromInstructionsDtoToModel(recipeDetailDto.instructions)
            return RecipeDetailModel(
                recipeDetailDto.id,
                recipeDetailDto.title,
                recipeDetailDto.imagePath,
                recipeDetailDto.isFavorite,
                recipeDetailDto.summary,
                recipeDetailDto.readyInMinutes,
                ingredients,
                instructions
            )
        }

        fun fromDtoToEntity(recipeDetailDto: RecipeDetailDto): RecipeDetail = RecipeDetail(
            recipeDetailDto.id,
            recipeDetailDto.summary,
            recipeDetailDto.readyInMinutes
        )

        fun fromEntityToModel(recipeAndDetail: RecipeAndDetail): RecipeDetailModel {
            val recipe = recipeAndDetail.recipe
            val recipeDetail = recipeAndDetail.recipeDetail
            return RecipeDetailModel(
                id = recipe.id,
                title = recipe.title,
                imagePath = recipe.imagePath,
                isFavorite = recipe.isFavorite,
                summary = recipeDetail.summary,
                readyInMinute = recipeDetail.readyInMinutes,
                ingredients = mutableListOf(),
                instructions = mutableListOf()
            )
        }
    }
}