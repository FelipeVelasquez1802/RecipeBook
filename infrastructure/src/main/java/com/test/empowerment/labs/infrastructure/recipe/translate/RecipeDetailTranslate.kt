package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.infrastructure.ingredient.translate.IngredientTranslate
import com.test.empowerment.labs.infrastructure.instruction.translate.InstructionTranslate
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
    }
}