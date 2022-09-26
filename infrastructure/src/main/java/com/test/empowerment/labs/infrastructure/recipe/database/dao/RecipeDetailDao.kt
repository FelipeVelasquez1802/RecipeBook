package com.test.empowerment.labs.infrastructure.recipe.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeAndDetail
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeDetail

@Dao
interface RecipeDetailDao {
    @Transaction
    @Query("SELECT * FROM recipe WHERE id=:id LIMIT 1")
    fun selectRecipeDetail(id: Int): RecipeAndDetail

    @Transaction
    @Insert
    fun insertRecipeDetail(recipeDetail: RecipeDetail): Long
}