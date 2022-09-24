package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.EmptyValueException
import com.test.empowerment.labs.domain.recipe.repository.RecipeRepository
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeServiceTest {

    @Mock
    private lateinit var recipeRepository: RecipeRepository

    private lateinit var recipeService: RecipeService

    @Before
    fun setUp() {
        recipeService = RecipeService(recipeRepository)
    }

    @Test
    fun givenTheGetRecipeByKeyWord_whenIsEmptyKeyWord_thenReturnEmptyValueException() {
        // Given
        val emptyKeyWord = ""
        try {
            // When
            recipeService.getRecipeByKeyWord(emptyKeyWord)
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            // Then
            assert(exception is EmptyValueException)
        }
    }

}