package com.test.empowerment.labs.recipebook.common.view

import android.widget.TextView
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun DescriptionNormal(text: String, modifier: Modifier = Modifier, color: Color = Black) {
    Text(text = text, modifier = modifier, color = color)
}

@Composable
fun DescriptionNormal(textId: Int, modifier: Modifier = Modifier, color: Color = Black) =
    DescriptionNormal(text = stringResource(id = textId), modifier = modifier, color = color)

@Composable
fun DescriptionHtml(text: String, modifier: Modifier = Modifier) {
    AndroidView(modifier = modifier, factory = { context ->
        TextView(context).apply {
            setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
        }
    })
}