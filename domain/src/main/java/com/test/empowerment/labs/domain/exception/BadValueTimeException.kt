package com.test.empowerment.labs.domain.exception

data class BadValueTimeException(override val message: String) : BadIdException(message)