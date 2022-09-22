package com.test.empowerment.labs.domain.recipe.model

import com.test.empowerment.labs.domain.exception.BadValueTimeException
import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.databuilder.RecipeDetailDataBuilder
import org.junit.Assert.fail
import org.junit.Test

class RecipeDetailTest : RecipeTest() {

    override fun buildDataBuilder(): RecipeDetailDataBuilder = RecipeDetailDataBuilder()

    @Test
    fun giveTheCreationRecipeDetail_whenSummaryIsEmpty_thenReturnEmptyValueException() {
        val emptySummary = ""
        val dataBuilder = buildDataBuilder().withSummary(emptySummary)
        try {
            dataBuilder.build()
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun giveTheCreationRecipeDetail_whenNegativeReadyInMinute_thenReturnBadValueTimeException() {
        val negativeValue = -1
        val dataBuilder = buildDataBuilder().withReadyInMinute(readyInMinute = negativeValue)
        try {
            dataBuilder.build()
            fail("Expected BadValueTimeException")
        } catch (exception: Exception) {
            assert(exception is BadValueTimeException)
        }
    }

}