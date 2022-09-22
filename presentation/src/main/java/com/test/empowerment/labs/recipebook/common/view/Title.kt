package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NormalTitle(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier)
}