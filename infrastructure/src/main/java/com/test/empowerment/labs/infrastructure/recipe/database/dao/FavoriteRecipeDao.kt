package com.test.empowerment.labs.infrastructure.recipe.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.empowerment.labs.infrastructure.recipe.database.entity.FavoriteRecipe

@Dao
interface FavoriteRecipeDao {
    @Query("select * from favoriterecipe")
    fun select(): MutableList<FavoriteRecipe>

    @Query("select exists(select recipe_id from favoriterecipe where recipe_id=:recipeId)")
    fun exists(recipeId: Int): Boolean

    @Query("select is_favorite from favoriterecipe where recipe_id=:recipeId limit 1")
    fun isFavorite(recipeId: Int): Boolean

    @Update
    fun update(vararg favoritesRecipe: FavoriteRecipe)

    @Insert
    fun insert(vararg favoritesRecipe: FavoriteRecipe)

    @Query("delete from favoriterecipe where recipe_id=:recipeId")
    fun delete(recipeId: Int)

}