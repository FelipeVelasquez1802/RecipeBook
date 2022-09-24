package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.BadIdException
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
        val emptyKeyWord = ""
        try {
            recipeService.getRecipeByKeyWord(emptyKeyWord)
            fail("Expected EmptyValueException")
        } catch (exception: Exception) {
            assert(exception is EmptyValueException)
        }
    }

    @Test
    fun givenTheSetIsFavoriteRecipe_whenIsBadId_thenReturnBadIdException() {
        val badId = -1
        val isFavorite = false
        try {
            recipeService.setIsFavoriteRecipe(badId, isFavorite)
            fail("Expected BadIdException")
        } catch (exception: Exception) {
            assert(exception is BadIdException)
        }
    }

}