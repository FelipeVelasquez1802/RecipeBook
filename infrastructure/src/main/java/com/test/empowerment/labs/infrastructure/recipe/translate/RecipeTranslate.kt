package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.domain.recipe.model.Recipe as RecipeModel

class RecipeTranslate {
    companion object {
        private fun fromDtoToModel(recipeDto: RecipeDto): RecipeModel =
            RecipeModel(recipeDto.id, recipeDto.title, recipeDto.imagePath, recipeDto.isFavorite)

        fun fromListDtoToListModel(recipesDto: MutableList<RecipeDto>): MutableList<RecipeModel> =
            recipesDto.map { recipeDto -> fromDtoToModel(recipeDto) }.toMutableList()

    }
}