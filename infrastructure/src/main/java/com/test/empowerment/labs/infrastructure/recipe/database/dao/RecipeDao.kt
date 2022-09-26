package com.test.empowerment.labs.infrastructure.recipe.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.empowerment.labs.infrastructure.recipe.entity.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun selectRecipe(): MutableList<Recipe>

    @Update
    fun updateAll(vararg recipes: Recipe)
}