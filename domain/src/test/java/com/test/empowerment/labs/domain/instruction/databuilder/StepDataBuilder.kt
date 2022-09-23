package com.test.empowerment.labs.domain.instruction.databuilder

import com.test.empowerment.labs.domain.instruction.model.Step

class StepDataBuilder {
    private var number: Int = 1
    private var description: String =
        "Take some yogurt in your favorite flavor and add 1 container to your blender."

    fun withNumber(number: Int): StepDataBuilder = this.apply { this.number = number }

    fun withDescription(description: String): StepDataBuilder =
        this.apply { this.description = description }

    fun build(): Step = Step(number, description)
}