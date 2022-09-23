package com.test.empowerment.labs.infrastructure.recipe.repository

import com.test.empowerment.labs.domain.exception.NullObjectException
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.domain.recipe.repository.RecipeDetailRepository
import com.test.empowerment.labs.infrastructure.ingredient.dto.IngredientDto
import com.test.empowerment.labs.infrastructure.intruction.dto.InstructionDto
import com.test.empowerment.labs.infrastructure.intruction.dto.StepDto
import com.test.empowerment.labs.infrastructure.recipe.dto.RecipeDetailDto
import com.test.empowerment.labs.infrastructure.recipe.translate.RecipeDetailTranslate

class RecipeDetailRepositoryImpl : RecipeDetailRepository {

    private val ingredientsDto = mutableListOf(
        IngredientDto(
            id = 9040,
            name = "banana",
            amount = 0.25,
            unit = "cup"
        )
    )

    private val stepsDto = mutableListOf(
        StepDto(
            number = 1,
            description = "Take some yogurt in your favorite flavor and add 1 container to your blender."
        ),
        StepDto(
            number = 2,
            description = "Add in the berries, banana, and soy milk and blend. Top your glass with a few graham cracker crumbs and serve."
        ),
    )

    private val instructionsDto = mutableListOf(InstructionDto(stepsDto = stepsDto))

    private val recipesDto = mutableListOf(
        RecipeDetailDto(
            id = 716426,
            title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
            imagePath = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            summary = "Cauliflower, Brown Rice, and Vegetable Fried Rice might be a good recipe to expand your side dish recipe box. Watching your figure? This gluten free, dairy free, lacto ovo vegetarian, and vegan recipe has <b>192 calories</b>, <b>7g of protein</b>, and <b>6g of fat</b> per serving. For <b>$1.12 per serving</b>, this recipe <b>covers 19%</b> of your daily requirements of vitamins and minerals. This recipe serves 8. This recipe from fullbellysisters.blogspot.com has 3689 fans. This recipe is typical of Chinese cuisine. From preparation to the plate, this recipe takes about <b>30 minutes</b>. Head to the store and pick up peas, broccoli, salt, and a few other things to make it today. Overall, this recipe earns an <b>awesome spoonacular score of 100%</b>. Users who liked this recipe also liked <a href=\"https://spoonacular.com/recipes/vegetable-fried-brown-rice-36199\">Vegetable Fried Brown Rice</a>, <a href=\"https://spoonacular.com/recipes/vegetable-fried-cauliflower-rice-933261\">Vegetable Fried Cauliflower Rice</a>, and <a href=\"https://spoonacular.com/recipes/easy-vegetable-fried-brown-rice-with-egg-802042\">Easy Vegetable Fried Brown Rice with Egg</a>.",
            readyInMinute = 30,
            ingredients = ingredientsDto,
            instructions = instructionsDto
        ),
        RecipeDetailDto(
            id = 715594,
            title = "Homemade Garlic and Basil French Fries",
            imagePath = "https://spoonacular.com/recipeImages/715594-312x231.jpg",
            summary = "The recipe Homemade Garlic and Basil French Fries is ready <b>in roughly 45 minutes</b> and is definitely a super <b>vegan</b> option for lovers of American food. One serving contains <b>596 calories</b>, <b>18g of protein</b>, and <b>15g of fat</b>. For <b>83 cents per serving</b>, you get a side dish that serves 2. Several people made this recipe, and 1669 would say it hit the spot. If you have garlic salt, flour, garlic powder, and a few other ingredients on hand, you can make it. All things considered, we decided this recipe <b>deserves a spoonacular score of 100%</b>. This score is outstanding. Try <a href=\"https://spoonacular.com/recipes/homemade-french-fries-with-fresh-garlic-and-dill-494220\">Homemade French Fries with Fresh Garlic and Dill</a>, <a href=\"https://spoonacular.com/recipes/roasted-garlic-french-fries-519898\">Roasted Garlic French Fries</a>, and <a href=\"https://spoonacular.com/recipes/sweet-potato-fries-with-basil-salt-and-garlic-mayonnaise-120735\">Sweet Potato Fries With Basil Salt and Garlic Mayonnaise</a> for similar recipes.",
            readyInMinute = 45,
            ingredients = ingredientsDto,
            instructions = instructionsDto
        ),
        RecipeDetailDto(
            id = 715497,
            title = "Berry Banana Breakfast Smoothie",
            imagePath = "https://spoonacular.com/recipeImages/715497-312x231.jpg",
            summary = "If you have around <b>5 minutes</b> to spend in the kitchen, Berry Banana Breakfast Smoothie might be a tremendous <b>lacto ovo vegetarian</b> recipe to try. This recipe makes 1 servings with <b>501 calories</b>, <b>21g of protein</b>, and <b>11g of fat</b> each. For <b>$2.19 per serving</b>, this recipe <b>covers 32%</b> of your daily requirements of vitamins and minerals. 688 people found this recipe to be tasty and satisfying. It is brought to you by Pink When. Head to the store and pick up graham crackers, soy milk, banana, and a few other things to make it today. It works well as a morn meal. Overall, this recipe earns a <b>super spoonacular score of 100%</b>. If you like this recipe, take a look at these similar recipes: <a href=\"https://spoonacular.com/recipes/berry-banana-breakfast-smoothie-249239\">Berry Banana Breakfast Smoothie</a>, <a href=\"https://spoonacular.com/recipes/berry-and-banana-oat-breakfast-smoothie-626817\">Berry and Bananan Oat Breakfast Smoothie</a>, and <a href=\"https://spoonacular.com/recipes/berry-breakfast-smoothie-774875\">Berry Breakfast Smoothie</a>.",
            readyInMinute = 5,
            ingredients = ingredientsDto,
            instructions = instructionsDto
        )
    )

    override fun selectRecipeDetail(id: Int): RecipeDetail {
        val recipeDetailDto =
            recipesDto.find { recipeDto -> recipeDto.id == id } ?: throw NullObjectException()
        return RecipeDetailTranslate.fromRecipeDetailDtoToModel(recipeDetailDto)
    }

}