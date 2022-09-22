package com.test.empowerment.labs.domain.exception

data class BadPathException(override val message: String) : Exception(message)