package com.test.empowerment.labs.infrastructure.recipe.dto

import com.google.gson.annotations.SerializedName
import com.test.empowerment.labs.infrastructure.common.dto.IdentityDto
import com.test.empowerment.labs.infrastructure.recipe.enums.ApiKeyEnum.IMAGE

open class RecipeDto(
    override val id: Int,
    val title: String,
    @SerializedName(IMAGE)
    val imagePath: String?,
    var isFavorite: Boolean
) : IdentityDto()
