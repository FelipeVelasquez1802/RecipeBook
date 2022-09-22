package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDto
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeTranslate

class RecipeRepositoryImpl : RecipeRepository {
    override fun selectRecipe(): MutableList<Recipe> {
        val recipesDto = mutableListOf(
            RecipeDto(
                id = 716429,
                title = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
                imagePath = "https://spoonacular.com/recipeImages/716429-312x231.jpg"
            ),
            RecipeDto(
                id = 715538,
                title = "What to make for dinner tonight?? Bruschetta Style Pork & Pasta",
                imagePath = "https://spoonacular.com/recipeImages/715538-312x231.jpg"
            )
        )
        return RecipeTranslate.fromListDtoToListModel(recipesDto)
    }
}