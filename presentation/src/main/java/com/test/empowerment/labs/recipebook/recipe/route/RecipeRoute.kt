package com.test.empowerment.labs.recipebook.recipe.route

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import com.test.empowerment.labs.recipebook.common.route.BaseRoute
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.recipe.view.RecipeDetailActivity
import com.test.empowerment.labs.recipebook.recipe.view.SearchActivity

class RecipeRoute : BaseRoute() {

    fun goToRecipeDetail(recipeId: Int) {
        context?.apply {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra(ParamsEnum.RECIPE_ID.value, recipeId)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    fun goToSearch() {
        context?.apply {
            val intent = Intent(context, SearchActivity::class.java)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}