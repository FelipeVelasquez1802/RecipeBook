package com.test.empowerment.labs.infrastructure.recipe.dto

import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto
import com.test.empowerment.labs.infrastructure.intruction.dto.InstructionDto

class RecipeDetailDto(
    id: Int,
    title: String,
    imagePath: String,
    isFavorite: Boolean,
    val summary: String,
    val readyInMinute: Int,
    val ingredients: MutableList<IngredientDto>,
    val instructions: MutableList<InstructionDto>
) : RecipeDto(id, title, imagePath, isFavorite)