package com.test.empowerment.labs.domain.recipe.databuilder

import com.test.empowerment.labs.domain.ingredient.databuilder.IngredientDataBuilder
import com.test.empowerment.labs.domain.ingredient.model.Ingredient
import com.test.empowerment.labs.domain.instruction.model.Instruction
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail

class RecipeDetailDataBuilder : RecipeDataBuilder() {
    private var isFavorite = false
    private var summary: String =
        "Cauliflower, Brown Rice, and Vegetable Fried Rice might be a good recipe to expand your side dish recipe box. Watching your figure? This gluten free, dairy free, lacto ovo vegetarian, and vegan recipe has <b>192 calories</b>, <b>7g of protein</b>, and <b>6g of fat</b> per serving. For <b>\$1.12 per serving</b>, this recipe <b>covers 19%</b> of your daily requirements of vitamins and minerals. This recipe serves 8. This recipe from fullbellysisters.blogspot.com has 3689 fans. This recipe is typical of Chinese cuisine. From preparation to the plate, this recipe takes about <b>30 minutes</b>. Head to the store and pick up peas, broccoli, salt, and a few other things to make it today. Overall, this recipe earns an <b>awesome spoonacular score of 100%</b>. Users who liked this recipe also liked <a href=\\\"https://spoonacular.com/recipes/vegetable-fried-brown-rice-36199\\\">Vegetable Fried Brown Rice</a>, <a href=\\\"https://spoonacular.com/recipes/vegetable-fried-cauliflower-rice-933261\\\">Vegetable Fried Cauliflower Rice</a>, and <a href=\\\"https://spoonacular.com/recipes/easy-vegetable-fried-brown-rice-with-egg-802042\\\">Easy Vegetable Fried Brown Rice with Egg</a>."
    private var readyInMinute: Int = 30
    private val ingredients: MutableList<Ingredient> =
        mutableListOf(IngredientDataBuilder().build())
    private val instruction: MutableList<Instruction> = mutableListOf()

    fun withSummary(summary: String): RecipeDetailDataBuilder =
        this.apply { this.summary = summary }

    fun withReadyInMinute(readyInMinute: Int): RecipeDetailDataBuilder =
        this.apply { this.readyInMinute = readyInMinute }

    override fun build(): RecipeDetail =
        RecipeDetail(
            id,
            title,
            imagePath,
            isFavorite,
            summary,
            readyInMinute,
            ingredients,
            instruction
        )
}
