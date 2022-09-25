package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.empowerment.labs.recipebook.ui.theme.RecipeBookTheme

@Composable
fun LoadingDialog() = Box(modifier = Modifier.fillMaxSize()) {
    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
}

@Preview(showBackground = true)
@Composable
private fun LoadingDialogPreview() {
    RecipeBookTheme {
        LoadingDialog()
    }
}