package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.exception.BadPathException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.databuilder.RecipeDataBuilder
import org.junit.Assert.fail
import org.junit.Test

class RecipeTest {

    @Test
    fun giveTheCreationRecipe_whenBadId_thenReturnBadIdException() {
        val badId = -1
        val dataBuilder = RecipeDataBuilder().withId(badId)
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
        val dataBuilder = RecipeDataBuilder().withTitle(emptyTitle)
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
        val dataBuilder = RecipeDataBuilder().withImagePath(emptyImagePath)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun giveTheCreationRecipe_whenImageNotIsCorrectPath_thenReturnBadPathException() {
        val badPath = "ho:sss.com"
        val dataBuilder = RecipeDataBuilder().withImagePath(badPath)
        try {
            dataBuilder.build()
            fail("Expected BadPathException")
        } catch (exception: Exception) {
            assert(exception is BadPathException)
        }
    }
}