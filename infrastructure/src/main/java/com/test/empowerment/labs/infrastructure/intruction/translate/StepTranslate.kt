package com.test.empowerment.labs.infrastructure.intruction.translate

import com.test.empowerment.labs.domain.instruction.model.Step
import com.test.empowerment.labs.infrastructure.intruction.dto.StepDto

class StepTranslate {
    companion object {
        private fun fromStepDtoToModel(stepDto: StepDto): Step =
            Step(stepDto.number, stepDto.description)

        fun fromStepsDtoToModel(stepsDto: MutableList<StepDto>): MutableList<Step> =
            stepsDto.map { stepDto -> fromStepDtoToModel(stepDto) }.toMutableList()
    }
}