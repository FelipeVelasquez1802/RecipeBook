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
@InstallIn(ActivityComponent::class)
abstract class RecipeModule {
    @Binds
    abstract fun bindRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository
}