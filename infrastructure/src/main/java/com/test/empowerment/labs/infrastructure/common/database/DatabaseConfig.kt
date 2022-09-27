package com.test.empowerment.labs.infrastructure.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.empowerment.labs.infrastructure.BuildConfig
import com.test.empowerment.labs.infrastructure.recipe.database.dao.FavoriteRecipeDao
import com.test.empowerment.labs.infrastructure.recipe.database.entity.FavoriteRecipe

@Database(
    entities = [FavoriteRecipe::class],
    version = BuildConfig.DATABASE_VERSION
)
abstract class DatabaseConfig : RoomDatabase() {
    abstract fun favoriteRecipe(): FavoriteRecipeDao
}