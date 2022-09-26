package com.test.empowerment.labs.infrastructure.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.empowerment.labs.infrastructure.recipe.database.dao.RecipeDao
import com.test.empowerment.labs.infrastructure.recipe.database.entity.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class DatabaseConfig : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}