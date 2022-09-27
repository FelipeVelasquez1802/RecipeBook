package com.test.empowerment.labs.domain.ingredient.model

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.exception.NegativeNumberException
import com.test.empowerment.labs.domain.ingredient.databuilder.IngredientDataBuilder
import org.junit.Assert.fail
import org.junit.Test

class IngredientTest {
    @Test
    fun givenTheCreationIngredient_whenIsBadId_thenReturnBadIdException() {
        val badId = -1
        val dataBuilder = IngredientDataBuilder().withId(badId)
        try {
            dataBuilder.build()
            fail("Expected BadIdException")
        } catch (exception: Exception) {
            assert(exception is BadIdException)
        }
    }

    @Test
    fun givenTheCreationIngredient_whenIsEmptyName_thenReturnEmptyValueException() {
        val emptyName = ""
        val dataBuilder = IngredientDataBuilder().withName(emptyName)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun givenTheCreationIngredient_whenIsNegativeAmount_thenReturnNegativeNumberException() {
        val negativeAmount = -1.0
        val dataBuilder = IngredientDataBuilder().withAmount(negativeAmount)
        try {
            dataBuilder.build()
            fail("Expected NegativeNumberException")
        } catch (exception: Exception) {
            assert(exception is NegativeNumberException)
        }
    }

}