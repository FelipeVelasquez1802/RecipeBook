package com.test.empowerment.labs.infrastructure.instruction.translate

import com.test.empowerment.labs.infrastructure.instruction.dto.InstructionDto
import com.test.empowerment.labs.domain.instruction.model.Instruction as InstructionModel

class InstructionTranslate {
    companion object {
        private fun fromInstructionDtoToModel(instructionDto: InstructionDto): InstructionModel {
            val steps = StepTranslate.fromStepsDtoToModel(instructionDto.stepsDto)
            return InstructionModel(steps)
        }

        fun fromInstructionsDtoToModel(instructionsDto: MutableList<InstructionDto>): MutableList<InstructionModel> =
            instructionsDto.map { instructionDto ->
                fromInstructionDtoToModel(instructionDto)
            }.toMutableList()
    }
}