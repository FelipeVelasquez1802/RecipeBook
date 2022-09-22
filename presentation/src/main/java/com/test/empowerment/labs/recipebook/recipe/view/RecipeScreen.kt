package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.NormalTitle
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme


@Composable
fun Recipe(recipes: MutableList<Recipe>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(items = recipes, key = { recipe -> recipe.id }) { recipe ->
            RecipeRow(recipe = recipe)
        }
    }
}

@Composable
private fun RecipeRow(recipe: Recipe) {
    Row(modifier = Modifier.padding(vertical = Multiplier_x4, horizontal = Multiplier_x3)) {
        Card {
            Column {
                NormalTitle(
                    text = recipe.title,
                    modifier = Modifier.padding(
                        vertical = Multiplier_x3,
                        horizontal = Multiplier_x4
                    )
                )
                GlideImage(
                    imageModel = recipe.imagePath,
                    imageOptions = ImageOptions(alignment = Alignment.Center),
                    previewPlaceholder = R.drawable.loading,
                    modifier = Modifier.fillMaxWidth()
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
                id = 716429,
                title = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
                imagePath = "https://spoonacular.com/recipeImages/716429-312x231.jpg"
            ),
            Recipe(
                id = 715538,
                title = "What to make for dinner tonight?? Bruschetta Style Pork & Pasta",
                imagePath = "https://spoonacular.com/recipeImages/715538-312x231.jpg"
            )
        )
        Recipe(recipes)
    }
}