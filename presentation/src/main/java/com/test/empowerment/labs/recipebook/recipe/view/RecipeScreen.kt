package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.EmptyList
import com.test.empowerment.labs.recipebook.common.view.TitleBold
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.recipe.route.RecipeRoute
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x100
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500
import com.test.empowerment.labs.recipebook.ui.theme.Purple700
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme

@Composable
fun Recipes(recipes: MutableList<Recipe>) {
    val recipeRoute = RecipeRoute()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Search(recipeRoute)
        if (recipes.isEmpty()) EmptyList()
        else {
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(recipes){recipe->
                    RecipeRow(recipe = recipe, recipeRoute = recipeRoute)
                }
            }
        }
    }
}

@Composable
private fun Search(recipeRoute: RecipeRoute) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple500)
            .height(Multiplier_x28)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Multiplier_x4, horizontal = Multiplier_x3)
                .clickable { recipeRoute.goToSearch() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Multiplier_x6, vertical = Multiplier_x4)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = ParamsEnum.SEARCH.value
                )
                Text(text = "Search")
            }
        }
    }
}

@Composable
private fun RecipeRow(recipe: Recipe, recipeRoute: RecipeRoute) {
    Row(modifier = Modifier.padding(vertical = Multiplier_x4, horizontal = Multiplier_x3)) {
        Card(modifier = Modifier.clickable { recipeRoute.goToRecipeDetail(recipe.id) }) {
            Column {
                TitleBold(
                    text = recipe.title,
                    modifier = Modifier.padding(
                        vertical = Multiplier_x3,
                        horizontal = Multiplier_x4
                    )
                )
                GlideImage(
                    imageModel = recipe.imagePath,
                    imageOptions = ImageOptions(alignment = Alignment.Center),
                    previewPlaceholder = R.drawable.ic_loading,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePreview() {
    RecipeBookTheme {
        val recipes = mutableListOf(
            Recipe(
                id = 716426,
                title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
                imagePath = "https://spoonacular.com/recipeImages/716426-312x231.jpg"
            ),
            Recipe(
                id = 715594,
                title = "Homemade Garlic and Basil French Fries",
                imagePath = "https://spoonacular.com/recipeImages/715594-312x231.jpg"
            )
        )
        Recipes(recipes)
    }
}