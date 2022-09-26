package com.test.empowerment.labs.infrastructure.recipe.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.IS_FAVORITE
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.RECIPE_ID

@Entity
data class FavoriteRecipe(
    @PrimaryKey
    @ColumnInfo(name = RECIPE_ID)
    val recipeId: Int,
    @ColumnInfo(name = IS_FAVORITE)
    val isFavorite: Boolean
)
