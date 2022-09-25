package com.test.empowerment.labs.infrastructure.recipe.enums

import com.test.empowerment.labs.infrastructure.common.enums.Path.HOSTNAME

object RecipeDetailPath {
    const val RECIPE_ID = "recipeId"
    const val RECIPE = "${HOSTNAME}recipes/{$RECIPE_ID}/information"
}