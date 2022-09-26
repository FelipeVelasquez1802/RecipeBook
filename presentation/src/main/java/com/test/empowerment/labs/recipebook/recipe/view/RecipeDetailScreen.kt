package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.ingredient.model.Ingredient
import com.test.empowerment.labs.domain.instruction.model.Instruction
import com.test.empowerment.labs.domain.instruction.model.Step
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.DescriptionHtml
import com.test.empowerment.labs.recipebook.common.view.DescriptionNormal
import com.test.empowerment.labs.recipebook.common.view.ErrorDialog
import com.test.empowerment.labs.recipebook.common.view.FavoriteButton
import com.test.empowerment.labs.recipebook.common.view.LoadingDialog
import com.test.empowerment.labs.recipebook.common.view.TabBar
import com.test.empowerment.labs.recipebook.common.view.TitleBold
import com.test.empowerment.labs.recipebook.recipe.viewmodel.RecipeDetailViewModel
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x100
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme


@Composable
fun RecipeDetail(recipeDetailViewModel: RecipeDetailViewModel) {
    ShowErrorDialog(recipeDetailViewModel = recipeDetailViewModel)
    if (recipeDetailViewModel.requestComplete.value) {
        val recipeDetail by recipeDetailViewModel.recipeDetail.observeAsState()
        recipeDetail?.apply {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    TabBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Purple500)
                            .height(Multiplier_x28)
                    ) {
                        TitleBold(
                            textId = R.string.title_activity_recipe_detail,
                            color = Color.White
                        )
                    }
                }
                item {
                    Detail(recipeDetail = this@apply, recipeDetailViewModel)
                }
                title(textId = R.string.title_ingredients)
                ingredients(ingredients = ingredients)
                title(textId = R.string.title_instructions)
                this@apply.instructions.forEach { instruction ->
                    title(textId = R.string.title_steps)
                    items(instruction.steps) { step ->
                        StepRow(step = step)
                    }
                }
            }
        } ?: NullRecipeDetailDialog()
    } else LoadingDialog()
}

@Composable
private fun ShowErrorDialog(recipeDetailViewModel: RecipeDetailViewModel) {
    val error = recipeDetailViewModel.error.value
    val isVisibility = recipeDetailViewModel.showErrorDialog
    ErrorDialog(
        titleId = error.title,
        descriptionId = error.description,
        isVisibility = isVisibility
    )
}

@Composable
private fun Detail(recipeDetail: RecipeDetail, recipeDetailViewModel: RecipeDetailViewModel) {
    val isFavorite = remember { mutableStateOf(recipeDetail.isFavorite) }
    GlideImage(
        imageModel = recipeDetail.imagePath,
        previewPlaceholder = R.drawable.ic_loading,
        modifier = Modifier
            .height(Multiplier_x100)
            .fillMaxWidth()
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(
                start = Multiplier_x6,
                end = Multiplier_x6,
                top = Multiplier_x3
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TitleBold(text = recipeDetail.title, modifier = Modifier.weight(1f))
                FavoriteButton(
                    isFavorite = isFavorite,
                    modifier = Modifier.clickable {
                        isFavorite.value = !isFavorite.value
                        recipeDetailViewModel.executeSetIsFavoriteRecipe(
                            id = recipeDetail.id,
                            isFavorite = isFavorite.value
                        )
                    })
            }
            DescriptionHtml(
                text = recipeDetail.summary,
                modifier = Modifier.padding(vertical = Multiplier_x4)
            )
            Divider()
            Time(recipeDetail.readyInMinute)
        }
    }
}

@Composable
private fun Time(time: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Multiplier_x6)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_time),
            contentDescription = "Ready In Minute"
        )
        Text(text = "$time")
    }
}

private fun LazyListScope.title(textId: Int) = item {
    TitleBold(
        textId = textId,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Multiplier_x6, horizontal = Multiplier_x4)
    )
}

private fun LazyListScope.ingredients(
    ingredients: MutableList<Ingredient>,
) = items(count = ingredients.size) { position ->
    IngredientRow(ingredient = ingredients[position])
}

@Composable
private fun IngredientRow(ingredient: Ingredient) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_x6)
    ) {
        DescriptionNormal(
            text = "$ingredient",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Multiplier_x4)
        )
        Divider()
    }
}

@Composable
private fun StepRow(step: Step) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Multiplier_x6)
        ) {
            Text(
                text = "${step.number}",
                modifier = Modifier
                    .padding(end = Multiplier_x6)
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.minDimension
                        )
                    },
                color = Color.White
            )
            DescriptionNormal(
                text = step.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Multiplier_x4)
            )
        }
        Divider()
    }
}

@Composable
fun NullRecipeDetailDialog() {
    val isVisibilityDialog = remember { mutableStateOf(true) }
    AlertDialog(
        onDismissRequest = { isVisibilityDialog.value = false },
        title = { TitleBold(text = "Sorry!, This element not exist :(") },
        text = { DescriptionNormal(text = "Not find this element.") },
        confirmButton = {
            Button(onClick = { isVisibilityDialog.value = false }) {
                Text(text = "Okay!")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview() {
    RecipeBookTheme {
        val ingredients = mutableListOf(
            Ingredient(id = 9040, name = "banana", amount = 0.25, unit = "cup"),
        )
        val steps = mutableListOf(
            Step(
                number = 1,
                description = "Take some yogurt in your favorite flavor and add 1 container to your blender."
            ),
            Step(
                number = 2,
                description = "Add in the berries, banana, and soy milk and blend. Top your glass with a few graham cracker crumbs and serve."
            )
        )
        val instructions = mutableListOf(Instruction(steps = steps))
        val recipeDetail = RecipeDetail(
            id = 716426,
            title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
            imagePath = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            isFavorite = false,
            summary = "Cauliflower, Brown Rice, and Vegetable Fried Rice might be a good recipe to expand your side dish recipe box. Watching your figure? This gluten free, dairy free, lacto ovo vegetarian, and vegan recipe has <b>192 calories</b>, <b>7g of protein</b>, and <b>6g of fat</b> per serving. For <b>$1.12 per serving</b>, this recipe <b>covers 19%</b> of your daily requirements of vitamins and minerals. This recipe serves 8. This recipe from fullbellysisters.blogspot.com has 3689 fans. This recipe is typical of Chinese cuisine. From preparation to the plate, this recipe takes about <b>30 minutes</b>. Head to the store and pick up peas, broccoli, salt, and a few other things to make it today. Overall, this recipe earns an <b>awesome spoonacular score of 100%</b>. Users who liked this recipe also liked <a href=\"https://spoonacular.com/recipes/vegetable-fried-brown-rice-36199\">Vegetable Fried Brown Rice</a>, <a href=\"https://spoonacular.com/recipes/vegetable-fried-cauliflower-rice-933261\">Vegetable Fried Cauliflower Rice</a>, and <a href=\"https://spoonacular.com/recipes/easy-vegetable-fried-brown-rice-with-egg-802042\">Easy Vegetable Fried Brown Rice with Egg</a>.",
            readyInMinute = 30,
            ingredients = ingredients,
            instructions = instructions
        )
        val recipeDetailViewModel = RecipeDetailViewModel()
        recipeDetailViewModel.recipeDetail.value = recipeDetail
        recipeDetailViewModel.requestComplete.value = true
        RecipeDetail(recipeDetailViewModel = recipeDetailViewModel)
    }
}