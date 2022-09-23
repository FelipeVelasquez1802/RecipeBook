package com.test.empowerment.labs.domain.ingredient.databuilder

import com.test.empowerment.labs.domain.ingredient.model.Ingredient

class IngredientDataBuilder {
    private var id: Int = 9040
    private var name: String = "banana"
    private var amount: Double = 0.25
    private var unit: String = "cup"

    fun withId(id: Int): IngredientDataBuilder = this.apply { this.id = id }

    fun withName(name: String): IngredientDataBuilder = this.apply { this.name = name }

    fun withAmount(amount: Double): IngredientDataBuilder = this.apply { this.amount = amount }

    fun withUnit(unit: String): IngredientDataBuilder = this.apply { this.unit = unit }

    fun build() = Ingredient(id, name, amount, unit)
}