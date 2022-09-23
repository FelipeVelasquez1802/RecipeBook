package com.test.empowerment.labs.recipebook.recipe.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.test.empowerment.labs.domain.recipe.model.RecipeDetail
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.common.view.DescriptionHtml
import com.test.empowerment.labs.recipebook.common.view.DescriptionNormal
import com.test.empowerment.labs.recipebook.common.view.TitleBold
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x3
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme


@Composable
fun RecipeDetail(recipeDetail: RecipeDetail?) {
    recipeDetail?.apply {
        Column(modifier = Modifier.fillMaxSize()) {
            Detail(recipeDetail = recipeDetail)
        }
    } ?: NullRecipeDetailDialog()
}

@Composable
private fun Detail(recipeDetail: RecipeDetail) {
    Column(modifier = Modifier.fillMaxWidth()) {
        GlideImage(
            imageModel = recipeDetail.imagePath,
            previewPlaceholder = R.drawable.ic_loading,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier.padding(
                start = Multiplier_x6,
                end = Multiplier_x6,
                top = Multiplier_x3
            )
        ) {
            TitleBold(text = recipeDetail.title)
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
fun DefaultPreview() {
    RecipeBookTheme {
        val recipeDetail = RecipeDetail(
            id = 716426,
            title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
            imagePath = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
            summary = "Cauliflower, Brown Rice, and Vegetable Fried Rice might be a good recipe to expand your side dish recipe box. Watching your figure? This gluten free, dairy free, lacto ovo vegetarian, and vegan recipe has <b>192 calories</b>, <b>7g of protein</b>, and <b>6g of fat</b> per serving. For <b>$1.12 per serving</b>, this recipe <b>covers 19%</b> of your daily requirements of vitamins and minerals. This recipe serves 8. This recipe from fullbellysisters.blogspot.com has 3689 fans. This recipe is typical of Chinese cuisine. From preparation to the plate, this recipe takes about <b>30 minutes</b>. Head to the store and pick up peas, broccoli, salt, and a few other things to make it today. Overall, this recipe earns an <b>awesome spoonacular score of 100%</b>. Users who liked this recipe also liked <a href=\"https://spoonacular.com/recipes/vegetable-fried-brown-rice-36199\">Vegetable Fried Brown Rice</a>, <a href=\"https://spoonacular.com/recipes/vegetable-fried-cauliflower-rice-933261\">Vegetable Fried Cauliflower Rice</a>, and <a href=\"https://spoonacular.com/recipes/easy-vegetable-fried-brown-rice-with-egg-802042\">Easy Vegetable Fried Brown Rice with Egg</a>.",
            readyInMinute = 30
        )
        RecipeDetail(recipeDetail = recipeDetail)
    }
}