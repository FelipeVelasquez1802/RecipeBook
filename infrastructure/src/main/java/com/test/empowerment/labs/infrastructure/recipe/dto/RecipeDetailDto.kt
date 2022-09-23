package com.test.empowerment.labs.infrastructure.recipe.dto

import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto

class RecipeDetailDto(
    id: Int,
    title: String,
    imagePath: String,
    val summary: String,
    val readyInMinute: Int,
    val ingredients: MutableList<IngredientDto>
) : RecipeDto(id, title, imagePath)