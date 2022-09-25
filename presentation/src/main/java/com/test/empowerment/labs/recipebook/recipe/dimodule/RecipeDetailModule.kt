package com.test.empowerment.labs.recipebook.recipe.dimodule

import com.test.empowerment.labs.domain.recipe.service.RecipeDetailService
import com.test.empowerment.labs.infrastructure.recipe.repository.RecipeDetailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RecipeDetailModule {

    @Provides
    fun provideRecipeDetailService(recipeDetailRepository: RecipeDetailRepositoryImpl): RecipeDetailService =
        RecipeDetailService(recipeDetailRepository)

}