package com.test.empowerment.labs.infrastructure.recipe.dimodule

import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeDetailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RecipeDetailModule {
    @Binds
    abstract fun bindRecipeDetailRepository(recipeDetailRepository: RecipeDetailRepositoryImpl): RecipeDetailRepository
}