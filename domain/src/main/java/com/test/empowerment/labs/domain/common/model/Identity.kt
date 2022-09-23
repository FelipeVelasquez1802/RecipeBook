package com.test.empowerment.labs.domain.common.model

import com.test.empowerment.labs.domain.exception.BadIdException

open class Identity(val id: Int) {

    init {
        validateId()
    }

    private fun validateId() {
        if (id < 1) {
            val message = "This is bad ID"
            throw BadIdException(message)
        }
    }
}