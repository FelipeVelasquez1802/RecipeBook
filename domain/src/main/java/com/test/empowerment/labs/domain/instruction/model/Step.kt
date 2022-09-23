package com.test.empowerment.labs.domain.instruction.model

import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.exception.NegativeNumberException

class Step(val number: Int, val description: String) {
    init {
        validate()
    }

    private fun validate() {
        validateNumber()
        validateDescription()
    }

    private fun validateNumber() {
        if (number < 1) {
            val message = "This is negative number or zero"
            throw NegativeNumberException(message)
        }
    }

    private fun validateDescription() {
        if (description.isEmpty()) {
            val message = "This is empty description"
            throw EmptyValueException(message)
        }
    }
}