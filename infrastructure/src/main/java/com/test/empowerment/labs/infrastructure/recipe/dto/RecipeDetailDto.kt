package com.test.empowerment.labs.infrastructure.recipe.dto

class RecipeDetailDto(
    id: Int,
    title: String,
    imagePath: String,
    val summary: String,
    val readyInMinute: Int
) : RecipeDto(id, title, imagePath) {
}