package com.test.empowerment.labs.infrastructure.recipe.translate

import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.domain.recipe.model.Recipe as RecipeModel
import com.test.empowerment.labs.infrastructure.recipe.entity.Recipe as RecipeEntity

class RecipeTranslate {
    companion object {
        private fun fromDtoToModel(recipeDto: RecipeDto): RecipeModel =
            RecipeModel(recipeDto.id, recipeDto.title, recipeDto.imagePath, recipeDto.isFavorite)

        fun fromListDtoToListModel(recipesDto: MutableList<RecipeDto>): MutableList<RecipeModel> =
            recipesDto.map { recipeDto -> fromDtoToModel(recipeDto) }.toMutableList()

        private fun fromDtoToEntity(recipeDto: RecipeDto): RecipeEntity =
            RecipeEntity(recipeDto.id, recipeDto.title, recipeDto.imagePath, recipeDto.isFavorite)

        fun fromListDtoToListEntity(recipesDto: MutableList<RecipeDto>): Array<RecipeEntity> =
            recipesDto.map { recipeDto -> fromDtoToEntity(recipeDto) }.toTypedArray()

        private fun fromEntityToModel(recipeEntity: RecipeEntity): RecipeModel =
            RecipeModel(
                recipeEntity.id,
                recipeEntity.title,
                recipeEntity.imagePath,
                recipeEntity.isFavorite
            )

        fun fromListEntityToListModel(recipesEntity: MutableList<RecipeEntity>): MutableList<RecipeModel> =
            recipesEntity.map { recipeEntity -> fromEntityToModel(recipeEntity) }.toMutableList()

    }
}