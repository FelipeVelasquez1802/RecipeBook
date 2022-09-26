package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.recipe.model.Recipe
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.DescriptionNormal
import com.test.empowerment.labs.recipebook.common.view.EmptyList
import com.test.empowerment.labs.recipebook.common.view.ErrorDialog
import com.test.empowerment.labs.recipebook.common.view.FavoriteButton
import com.test.empowerment.labs.recipebook.common.view.LoadingDialog
import com.test.empowerment.labs.recipebook.common.view.TabBar
import com.test.empowerment.labs.recipebook.common.view.TitleBold
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.recipe.route.RecipeRoute
import com.test.empowerment.labs.recipebook.recipe.viewmodel.RecipeViewModel
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme

@Composable
fun Recipes(recipeViewModel: RecipeViewModel) {
    ShowErrorDialog(recipeViewModel = recipeViewModel)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        val recipeRoute = RecipeRoute()
        Search(recipeRoute)
        if (recipeViewModel.requestComplete.value) {
            RecipesColumn(recipeViewModel = recipeViewModel, recipeRoute = recipeRoute)
        } else LoadingDialog()
    }
}

@Composable
private fun ShowErrorDialog(recipeViewModel: RecipeViewModel) {
    val error = recipeViewModel.error.value
    val isVisibility = recipeViewModel.showErrorDialog
    ErrorDialog(
        titleId = error.title,
        descriptionId = error.description,
        isVisibility = isVisibility
    )
}

@Composable
private fun RecipesColumn(recipeViewModel: RecipeViewModel, recipeRoute: RecipeRoute) {
    val recipes = recipeViewModel.recipes
    if (recipes.isEmpty()) EmptyList()
    else {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(recipes) { recipe ->
                RecipeRow(
                    recipe = recipe,
                    recipeViewModel = recipeViewModel,
                    recipeRoute = recipeRoute
                )
            }
        }
    }
}

@Composable
private fun Search(recipeRoute: RecipeRoute) {
    TabBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple500)
            .height(Multiplier_x28),
        showBackButton = false
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
                DescriptionNormal(textId = R.string.search_title)
            }
        }
    }
}

@Composable
private fun RecipeRow(recipe: Recipe, recipeViewModel: RecipeViewModel, recipeRoute: RecipeRoute) {
    val isFavorite = remember { mutableStateOf(recipe.isFavorite) }
    Row(modifier = Modifier.padding(vertical = Multiplier_x4, horizontal = Multiplier_x3)) {
        Card(modifier = Modifier.clickable { recipeRoute.goToRecipeDetail(recipe.id) }) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TitleBold(
                        text = recipe.title,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                vertical = Multiplier_x3,
                                horizontal = Multiplier_x4
                            )
                    )
                    FavoriteButton(
                        isFavorite = isFavorite,
                        modifier = Modifier.clickable {
                            recipeViewModel.executeSetIsFavoriteRecipe(recipe.id, isFavorite.value)
                            isFavorite.value = !isFavorite.value
                        })
                }
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
        recipeViewModel.requestComplete.value = true
        Recipes(recipeViewModel = recipeViewModel)
    }
}