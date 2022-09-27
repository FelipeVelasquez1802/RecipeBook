package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.recipe.model.ParamsEnum

@Composable
fun EmptyList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleBold(text = "Empty list")
        Icon(
            painter = painterResource(id = R.drawable.ic_empty_box),
            contentDescription = ParamsEnum.EMPTY_LIST.value
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyListPreview() {
    EmptyList()
}