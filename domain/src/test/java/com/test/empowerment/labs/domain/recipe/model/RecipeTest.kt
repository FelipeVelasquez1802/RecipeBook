package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.exception.BadPathException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.databuilder.RecipeDataBuilder
import org.junit.Assert.fail
import org.junit.Test

open class RecipeTest {

    protected open fun buildDataBuilder(): RecipeDataBuilder = RecipeDataBuilder()

    @Test
    fun giveTheCreationRecipe_whenBadId_thenReturnBadIdException() {
        val badId = -1
        val dataBuilder = buildDataBuilder().withId(badId)
        try {
            dataBuilder.build()
            fail("Expected BadIdException")
        } catch (exception: Exception) {
            assert(exception is BadIdException)
        }
    }

    @Test
    fun giveTheCreationRecipe_whenIsEmptyTitle_thenReturnEmptyValueException() {
        val emptyTitle = ""
        val dataBuilder = buildDataBuilder().withTitle(emptyTitle)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun giveTheCreationRecipe_whenIsEmptyImagePath_thenReturnEmptyValueException() {
        val emptyImagePath = ""
        val dataBuilder = buildDataBuilder().withImagePath(emptyImagePath)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun giveTheCreationRecipe_whenImageNotIsCorrectPath_thenReturnBadPathException() {
        val badPath = "@mmm"
        val dataBuilder = buildDataBuilder().withImagePath(badPath)
        try {
            dataBuilder.build()
            fail("Expected BadPathException")
        } catch (exception: Exception) {
            assert(exception is BadPathException)
        }
    }
}