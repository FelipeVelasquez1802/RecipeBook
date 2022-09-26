package com.test.empowerment.labs.infrastructure.recipe.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeAndDetail(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    var recipeDetail: RecipeDetail
)
