package com.test.empowerment.labs.infrastructure.recipe.dimodule

import android.content.Context
import androidx.room.Room
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.infrastructure.common.database.DatabaseConfig
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RecipeModule {
    @Binds
    abstract fun bindRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository

    companion object {
        @Singleton
        @Provides
        fun provideDatabase(@ApplicationContext context: Context): DatabaseConfig =
            Room.databaseBuilder(context, DatabaseConfig::class.java, "recipe_book").build()
    }
}