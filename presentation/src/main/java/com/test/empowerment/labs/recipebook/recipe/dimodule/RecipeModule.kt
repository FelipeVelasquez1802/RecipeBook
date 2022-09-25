package com.test.empowerment.labs.recipebook.recipe.dimodule

import com.test.empowerment.labs.domain.recipe.service.RecipeService
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RecipeModule {

    @Provides
    fun provideRecipeService(recipeRepository: RecipeRepositoryImpl): RecipeService =
        RecipeService(recipeRepository)
}