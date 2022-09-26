package com.test.empowerment.labs.infrastructure.recipe.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.empowerment.labs.infrastructure.recipe.enums.DatabaseKeyEnum.UPDATE_DATE
import java.util.*

@Entity
data class UpdateDatabase(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = UPDATE_DATE)
    val updateDate: Date
)