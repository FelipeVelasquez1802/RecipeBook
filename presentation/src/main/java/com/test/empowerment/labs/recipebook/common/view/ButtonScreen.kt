package com.test.empowerment.labs.recipebook.common.view

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500

@Composable
fun FavoriteButton(modifier: Modifier = Modifier, isFavorite: MutableState<Boolean>) {
    val favoriteTint = if (isFavorite.value) Purple500 else Color.DarkGray
    Icon(
        painter = painterResource(id = R.drawable.ic_favorite),
        contentDescription = ParamsEnum.FAVORITE.value,
        modifier = modifier
            .padding(Multiplier_x6),
        tint = favoriteTint
    )
}

@Composable
fun BackButton(modifier: Modifier = Modifier) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Icon(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = ParamsEnum.BACK.value,
        modifier = modifier.clickable { dispatcher?.onBackPressed() },
        tint = Color.White
    )
}