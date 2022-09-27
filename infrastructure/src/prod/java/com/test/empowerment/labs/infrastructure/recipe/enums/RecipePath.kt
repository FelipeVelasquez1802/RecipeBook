package com.test.empowerment.labs.infrastructure.recipe.enums

import com.test.empowerment.labs.infrastructure.common.enums.Path.HOSTNAME

object RecipePath {
    const val RECIPES = "${HOSTNAME}recipes/complexSearch"
    const val RECIPE_BY_KEY_WORD = "${HOSTNAME}recipes/autocomplete"
    const val API_KEY = "apiKey"
    const val KEY_WORD = "query"
    const val NUMBER = "number"
}