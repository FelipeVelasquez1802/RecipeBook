package com.test.empowerment.labs.infrastructure.recipe.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.empowerment.labs.infrastructure.recipe.enums.ApiKeyEnum.IMAGE
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.IMAGE_PATH
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.IS_FAVORITE
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.TITLE

@Entity
data class Recipe(
    @PrimaryKey
    override val id: Int,
    @ColumnInfo(name = TITLE)
    val title: String,
    @SerializedName(IMAGE)
    @ColumnInfo(name = IMAGE_PATH)
    val imagePath: String?,
    @ColumnInfo(name = IS_FAVORITE)
    var isFavorite: Boolean,
    @Embedded
    val detail: RecipeDetail?
) : IdentityEntity(id)
