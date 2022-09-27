package com.test.empowerment.labs.infrastructure.recipe.dto

import com.google.gson.annotations.SerializedName
import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto
import com.test.empowerment.labs.infrastructure.instruction.dto.InstructionDto
import com.test.empowerment.labs.infrastructure.recipe.enums.ApiKeyEnum.INGREDIENT
import com.test.empowerment.labs.infrastructure.recipe.enums.ApiKeyEnum.INSTRUCTION

class RecipeDetailDto(
    id: Int,
    title: String,
    imagePath: String,
    isFavorite: Boolean,
    val summary: String,
    val readyInMinutes: Int,
    @SerializedName(INGREDIENT)
    val ingredients: MutableList<IngredientDto>,
    @SerializedName(INSTRUCTION)
    val instructions: MutableList<InstructionDto>
) : RecipeDto(id, title, imagePath, isFavorite)