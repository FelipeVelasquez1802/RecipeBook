package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.test.empowerment.labs.recipebook.ui.theme.Title

@Composable
fun NormalTitle(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier)
}

@Composable
fun BoldTitle(
    text: String,
    modifier: Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = Title
) {
    Text(text = text, modifier = modifier, fontWeight = fontWeight, fontSize = fontSize)
}