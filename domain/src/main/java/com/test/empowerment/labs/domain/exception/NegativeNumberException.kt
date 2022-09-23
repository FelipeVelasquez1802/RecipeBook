package com.test.empowerment.labs.domain.exception

data class NegativeNumberException(override val message: String) : Exception(message)