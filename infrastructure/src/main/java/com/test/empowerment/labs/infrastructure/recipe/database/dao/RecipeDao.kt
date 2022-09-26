package com.test.empowerment.labs.infrastructure.recipe.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.test.empowerment.labs.infrastructure.recipe.database.entity.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun selectRecipe(): MutableList<Recipe>

    @Query("SELECT * FROM recipe WHERE id=:id LIMIT 1")
    fun selectRecipe(id: Int): Recipe

    @Update
    fun updateAll(vararg recipes: Recipe)

    @Query("UPDATE recipe SET is_favorite=:isFavorite WHERE id=:id")
    fun update(isFavorite: Boolean, id: Int): Int
}