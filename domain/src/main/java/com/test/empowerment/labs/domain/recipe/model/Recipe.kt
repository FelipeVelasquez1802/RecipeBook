package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.common.model.Identity
import com.test.empowerment.labs.domain.exception.BadPathException
import com.test.empowerment.labs.domain.exception.EmptyValueException

open class Recipe(
    id: Int,
    val title: String,
    val imagePath: String,
    val isFavorite: Boolean = false
) : Identity(id) {
    init {
        validate()
    }

    private fun validate() {
        validateTitle()
        validateImagePath()
    }

    private fun validateTitle() {
        if (title.isEmpty()) {
            val message = "This is empty title"
            throw EmptyValueException(message)
        }
    }

    private fun validateImagePath() {
        validateEmptyImagePath()
        validateCorrectImagePath()
    }

    private fun validateEmptyImagePath() {
        if (imagePath.isEmpty()) {
            val message = "This is empty Path Image"
            throw EmptyValueException(message)
        }
    }

    private fun validateCorrectImagePath() {
        val pathRegex =
            "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)".toRegex()
        if (!imagePath.matches(pathRegex)) {
            val message = "This is bad image path"
            throw BadPathException(message)
        }
    }
}