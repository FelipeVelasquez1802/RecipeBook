package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.test.empowerment.labs.recipebook.ui.theme.Title

@Composable
fun TitleNormal(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier)
}

@Composable
fun TitleBold(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = Title,
    color: Color = Black
) = Text(
    text = text,
    modifier = modifier,
    fontWeight = fontWeight,
    fontSize = fontSize,
    color = color
)

@Composable
fun TitleBold(
    textId: Int,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = Title,
    color: Color = Black
) = TitleBold(
    text = stringResource(id = textId),
    modifier = modifier,
    fontWeight = fontWeight,
    fontSize = fontSize,
    color = color
)