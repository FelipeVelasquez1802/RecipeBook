package com.test.empowerment.labs.infrastructure.intruction.translate

import com.test.empowerment.labs.domain.instruction.model.Instruction
import com.test.empowerment.labs.infrastructure.intruction.dto.InstructionDto

class InstructionTranslate {
    companion object {
        private fun fromInstructionDtoToModel(instructionDto: InstructionDto): Instruction {
            val steps = StepTranslate.fromStepsDtoToModel(instructionDto.stepsDto)
            return Instruction(steps)
        }

        fun fromInstructionsDtoToModel(instructionsDto: MutableList<InstructionDto>): MutableList<Instruction> =
            instructionsDto.map { instructionDto ->
                fromInstructionDtoToModel(instructionDto)
            }.toMutableList()
    }
}