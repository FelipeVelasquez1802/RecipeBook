package com.test.empowerment.labs.infrastructure.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.empowerment.labs.infrastructure.BuildConfig
import com.test.empowerment.labs.infrastructure.recipe.database.dao.RecipeDao
import com.test.empowerment.labs.infrastructure.recipe.database.dao.RecipeDetailDao
import com.test.empowerment.labs.infrastructure.recipe.database.entity.Recipe
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeAndDetail
import com.test.empowerment.labs.infrastructure.recipe.database.entity.RecipeDetail

@Database(
    entities = [Recipe::class],
    version = BuildConfig.DATABASE_VERSION
)
abstract class DatabaseConfig : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun recipeDetailDao(): RecipeDetailDao
}