package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.exception.BadValueTimeException
import com.test.empowerment.labs.domain.exception.EmptyValueException

class RecipeDetail(
    id: Int,
    title: String,
    imagePath: String,
    private val summary: String,
    val readyInMinute: Int
) : Recipe(id, title, imagePath) {

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