package com.test.empowerment.labs.domain.instruction.model

import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.exception.NegativeNumberException
import com.test.empowerment.labs.domain.instruction.databuilder.StepDataBuilder
import org.junit.Assert.fail
import org.junit.Test

class StepTest {
    @Test
    fun givenTheCreationStep_whenIsNegativeNumberOrZero_thenReturnNegativeNumberException() {
        val negativeNumber = -1
        val dataBuilder = StepDataBuilder().withNumber(negativeNumber)
        try {
            dataBuilder.build()
            fail("Expected NegativeNumberException")
        } catch (exception: Exception) {
            assert(exception is NegativeNumberException)
        }
    }

    @Test
    fun givenTheCreationStep_whenIsEmptyDescription_thenReturnEmptyValueException() {
        val emptyDescription = ""
        val dataBuilder = StepDataBuilder().withDescription(emptyDescription)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }
}