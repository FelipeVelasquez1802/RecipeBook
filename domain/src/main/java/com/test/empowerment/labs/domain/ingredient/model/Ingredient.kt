package com.test.empowerment.labs.domain.ingredient.model

import com.test.empowerment.labs.domain.common.model.Identity
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.exception.NegativeNumberException

class Ingredient(
    id: Int,
    private val name: String,
    private val amount: Double,
    private val unit: String
) : Identity(id) {
    init {
        validate()
    }

    private fun validate() {
        validateName()
        validateAmount()
        validateUnit()
    }

    private fun validateName() {
        if (name.isEmpty()) {
            val message = "This is empty name"
            throw EmptyValueException(message)
        }
    }

    private fun validateAmount() {
        if (amount < 0) {
            val message = "This is negative amount"
            throw NegativeNumberException(message)
        }
    }

    private fun validateUnit() {
        if (unit.isEmpty()) {
            val message = "This is empty unit"
            throw EmptyValueException(message)
        }
    }

    override fun toString(): String {
        return "$amount $unit $name"
    }

}