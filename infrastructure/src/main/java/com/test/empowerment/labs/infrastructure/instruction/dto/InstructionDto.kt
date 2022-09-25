package com.test.empowerment.labs.infrastructure.instruction.dto

import com.google.gson.annotations.SerializedName
import com.test.empowerment.labs.infrastructure.recipe.enums.ApiKeyEnum

data class InstructionDto(
    @SerializedName(ApiKeyEnum.STEPS)
    val stepsDto: MutableList<StepDto>
)