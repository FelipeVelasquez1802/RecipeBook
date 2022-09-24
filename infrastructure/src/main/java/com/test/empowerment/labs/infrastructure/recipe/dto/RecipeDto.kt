package com.test.empowerment.labs.infrastructure.recipe.dto

import com.test.empowerment.labs.infrastructure.common.dto.IdentityDto

open class RecipeDto(
    override val id: Int,
    val title: String,
    val imagePath: String,
    var isFavorite: Boolean
) : IdentityDto()
