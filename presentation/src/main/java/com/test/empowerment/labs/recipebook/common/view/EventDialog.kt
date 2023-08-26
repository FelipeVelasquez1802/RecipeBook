package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.test.empowerment.labs.recipebook.R
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme

@Composable
fun ErrorDialog(title: String, description: String, isVisibility: MutableState<Boolean>) {
    if (isVisibility.value) {
        AlertDialog(
            onDismissRequest = { isVisibility.value = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_error),
                        contentDescription = null,
                        modifier = Modifier.width(Multiplier_x28),
                        tint = Color.Red
                    )
                    TitleBold(
                        text = title,
                        color = Color.Red,
                        modifier = Modifier.padding(horizontal = Multiplier_x4)
                    )
                }
            },
            text = {
                DescriptionNormal(
                    text = description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Multiplier_x6, vertical = Multiplier_x4)
                )
            },
            confirmButton = {}
        )
    }
}

@Composable
fun ErrorDialog(titleId: Int, descriptionId: Int, isVisibility: MutableState<Boolean>) =
    ErrorDialog(
        title = stringResource(id = titleId),
        description = stringResource(id = descriptionId),
        isVisibility = isVisibility
    )

@Preview(showBackground = true)
@Composable
private fun EventDialogPreview() {
    RecipeBookTheme {
        val isVisibility = remember { mutableStateOf(false) }
        ErrorDialog(title = "Error", description = "Description", isVisibility)
    }
}