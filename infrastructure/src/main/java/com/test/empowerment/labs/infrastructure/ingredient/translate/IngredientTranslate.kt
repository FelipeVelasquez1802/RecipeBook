package com.test.empowerment.labs.infrastructure.ingredient.translate

import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto
import com.test.empowerment.labs.domain.ingredient.model.Ingredient as IngredientModel

class IngredientTranslate {
    companion object {
        private fun fromIngredientDtoToModel(ingredientDto: IngredientDto): IngredientModel =
            IngredientModel(
                ingredientDto.id,
                ingredientDto.name,
                ingredientDto.amount,
                ingredientDto.unit
            )

        fun fromIngredientsDtoToModel(ingredientsDto: MutableList<IngredientDto>): MutableList<IngredientModel> =
            ingredientsDto.map { ingredientDto ->
                fromIngredientDtoToModel(ingredientDto)
            }.toMutableList()

    }
}