package com.test.empowerment.labs.infrastructure.recipe.database.entity

import androidx.room.ColumnInfo
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.READY_IN_MINUTES

data class RecipeDetail(
    val summary: String?,
    @ColumnInfo(name = READY_IN_MINUTES)
    val readyInMinutes: Int?,
//    val ingredients: MutableList<IngredientDto>,
//    val instructions: MutableList<InstructionDto>
)
