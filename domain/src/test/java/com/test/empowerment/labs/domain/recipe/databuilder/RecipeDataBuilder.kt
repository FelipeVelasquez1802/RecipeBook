package com.test.empowerment.labs.domain.recipe.databuilder

import com.test.empowerment.labs.domain.recipe.model.Recipe

open class RecipeDataBuilder {

    protected var id: Int = 716429
    protected var title: String = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs"
    protected var imagePath: String = "https://spoonacular.com/recipeImages/716429-312x231.jpg"

    fun withId(id: Int): RecipeDataBuilder = this.apply { this.id = id }

    fun withTitle(title: String): RecipeDataBuilder = this.apply { this.title = title }

    fun withImagePath(imagePath: String): RecipeDataBuilder =
        this.apply { this.imagePath = imagePath }

    open fun build(): Recipe = Recipe(id, title, imagePath)

}