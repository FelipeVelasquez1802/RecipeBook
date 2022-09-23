package com.test.empowerment.labs.infrastructure.ingredient.dto

import com.test.empowerment.labs.infrastructure.common.dto.IdentityDto

data class IngredientDto(
    override val id: Int,
    val name: String,
    val amount: Double,
    val unit: String
) : IdentityDto()
