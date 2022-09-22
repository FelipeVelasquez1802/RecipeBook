package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto

class RecipeTranslate {
    companion object {
        private fun fromDtoToModel(recipeDto: RecipeDto): Recipe =
            Recipe(recipeDto.id, recipeDto.title, recipeDto.imagePath)

        fun fromListDtoToListModel(recipeListDto: MutableList<RecipeDto>): MutableList<Recipe> =
            recipeListDto.map { recipeDto -> fromDtoToModel(recipeDto) }.toMutableList()
    }
}