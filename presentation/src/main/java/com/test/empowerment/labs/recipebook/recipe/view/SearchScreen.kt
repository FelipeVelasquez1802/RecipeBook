package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.DescriptionNormal
import com.test.empowerment.labs.recipebook.common.view.EmptyList
import com.test.empowerment.labs.recipebook.common.view.TitleBold
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.recipe.route.RecipeRoute
import com.test.empowerment.labs.recipebook.recipe.viewmodel.RecipeViewModel
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x50
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme


@Composable
fun Search(recipeViewModel: RecipeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        SearchField(recipeViewModel)
        TextHelp(showTextHelp = recipeViewModel.showTextHelp.value)
        RecipesResult(recipes = recipeViewModel.recipes)
    }
}

@Composable
private fun SearchField(recipeViewModel: RecipeViewModel) {
    val keyWord = remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple500)
            .height(Multiplier_x28)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = ParamsEnum.BACK.value,
            modifier = Modifier.padding(horizontal = Multiplier_x6, vertical = Multiplier_x4),
            tint = Color.White
        )
        TextField(
            value = keyWord.value,
            onValueChange = { keyWord.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500),
            placeholder = { DescriptionNormal(text = "Search") },
            textStyle = TextStyle(color = Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon = {
                IconButton(onClick = { recipeViewModel.executeGetRecipeByKeyWord(keyWord.value) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = ParamsEnum.SEARCH.value,
                        tint = Color.White
                    )
                }
            }
        )
    }
}

@Composable
private fun TextHelp(showTextHelp: Boolean) {
    if (showTextHelp) DescriptionNormal(text = "Example: Cauliflower")
}

@Composable
private fun RecipesResult(recipes: MutableList<Recipe>) {
    if (recipes.isEmpty()) EmptyList()
    else {
        val recipeRoute = RecipeRoute()
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(recipes) { recipe ->
                RecipeRow(recipe = recipe, recipeRoute = recipeRoute)
            }
        }
    }
}

@Composable
private fun RecipeRow(recipe: Recipe, recipeRoute: RecipeRoute) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Multiplier_x6, vertical = Multiplier_x3)
            .clickable { recipeRoute.goToRecipeDetail(recipeId = recipe.id) }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            GlideImage(
                imageModel = recipe.imagePath,
                previewPlaceholder = R.drawable.ic_loading,
                modifier = Modifier.width(Multiplier_x50)
            )
            TitleBold(text = recipe.title, modifier = Modifier.padding(horizontal = Multiplier_x6))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    RecipeBookTheme {
        val recipeViewModel = RecipeViewModel()
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
        recipeViewModel.recipes.addAll(recipes)
        Search(recipeViewModel)
    }
}