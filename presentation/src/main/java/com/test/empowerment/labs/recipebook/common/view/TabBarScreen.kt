package com.test.empowerment.labs.recipebook.common.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x28
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x4
import com.test.empowerment.labs.recipebook.ui.theme.Multiplier_x6
import com.test.empowerment.labs.recipebook.ui.theme.Purple500

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    showBackButton: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .background(Purple500)
            .height(Multiplier_x28)
    ) {
        if (showBackButton) {
            BackButton(
                modifier = Modifier.padding(horizontal = Multiplier_x6, vertical = Multiplier_x4)
            )
        }
        content()
    }
}