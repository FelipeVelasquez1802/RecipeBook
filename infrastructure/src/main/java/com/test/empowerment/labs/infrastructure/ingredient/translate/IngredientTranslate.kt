package com.test.empowerment.labs.infrastructure.ingredient.translate

import com.test.empowerment.labs.domain.ingredient.model.Ingredient
import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto

class IngredientTranslate {
    companion object {
        private fun fromIngredientDtoToModel(ingredientDto: IngredientDto): Ingredient =
            Ingredient(
                ingredientDto.id,
                ingredientDto.name,
                ingredientDto.amount,
                ingredientDto.unit
            )

        fun fromIngredientsDtoToModel(ingredientsDto: MutableList<IngredientDto>): MutableList<Ingredient> =
            ingredientsDto.map { ingredientDto ->
                fromIngredientDtoToModel(ingredientDto)
            }.toMutableList()

    }
}