package com.test.empowerment.labs.infrastructure.recipe.entity

import androidx.room.PrimaryKey

abstract class IdentityEntity(
    @PrimaryKey open val id: Int
)
