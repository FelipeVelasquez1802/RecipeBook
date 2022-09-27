package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.exception.BadValueTimeException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.ingredient.model.Ingredient
import com.test.empowerment.labs.domain.instruction.model.Instruction

class RecipeDetail(
    id: Int,
    title: String,
    imagePath: String?,
    isFavorite: Boolean,
    val summary: String,
    val readyInMinute: Int,
    val ingredients: MutableList<Ingredient>,
    val instructions: MutableList<Instruction>
) : Recipe(id, title, imagePath, isFavorite) {

    init {
        validate()
    }

    private fun validate() {
        validateSummary()
        validateReadyInMinute()
    }

    private fun validateSummary() {
        if (summary.isEmpty()) {
            val message = "This is empty Summary"
            throw EmptyValueException(message)
        }
    }

    private fun validateReadyInMinute() {
        if (readyInMinute < 0) {
            val message = "This is bad value"
            throw BadValueTimeException(message)
        }
    }

}