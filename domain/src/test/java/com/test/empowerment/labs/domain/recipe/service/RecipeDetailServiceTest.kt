package com.test.empowerment.labs.domain.recipe.service

import com.test.empowerment.labs.domain.exception.BadIdException
import com.test.empowerment.labs.domain.recipe.databuilder.RecipeDetailDataBuilder
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import org.junit.Assert.assertNotNull
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecipeDetailServiceTest {

    @Mock
    private lateinit var recipeDetailRepository: RecipeDetailRepository

    private lateinit var recipeDetailService: RecipeDetailService

    @Before
    fun setUp() {
        recipeDetailService = RecipeDetailService(recipeDetailRepository)
    }

    @Test
    fun giveTheGetRecipeDetail_whenIsBadId_thenReturnBadIdException() {
        val badId = -1
        try {
            recipeDetailService.getRecipeDetail(badId)
            fail("Expected BadIdException")
        } catch (exception: Exception) {
            assert(exception is BadIdException)
        }
    }

    @Test
    fun giveTheGetRecipeDetail_whenIsGoodId_thenReturnObject() {
        val id = 1
        val recipeDetail: RecipeDetail =
            RecipeDetailDataBuilder().withId(id).build() as RecipeDetail
        Mockito.`when`(recipeDetailRepository.selectRecipeDetail(id)).thenReturn(recipeDetail)
        val response: RecipeDetail = recipeDetailService.getRecipeDetail(id)
        assertNotNull(response)
    }

    @Test
    fun givenTheSetIsFavoriteRecipeDetail_whenIsBadId_thenReturnBadIdException() {
        val badId = -1
        val isFavorite = false
        try {
            recipeDetailService.setIsFavoriteRecipe(badId, isFavorite)
            fail("Expected BadIdException")
        } catch (exception: Exception) {
            assert(exception is BadIdException)
        }
    }

}