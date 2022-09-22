package com.test.empowerment.labs.domain.exception

data class EmptyValueException(override val message: String) : Exception(message)