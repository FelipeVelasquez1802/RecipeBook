package com.test.empowerment.labs.domain.exception

data class BadIdException(override val message: String) : Exception(message)