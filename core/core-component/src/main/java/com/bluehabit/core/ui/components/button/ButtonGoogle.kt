/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.core.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.mvi.ui.extensions.Empty
import com.bluehabit.core.ui.R
import com.bluehabit.core.ui.theme.GaweanTheme
import com.bluehabit.core.ui.theme.Gray700

/**
 * Button Social
 * @param modifier
 * @param text text button
 * @sample PreviewButtonGoogle
 * */

@Composable
fun ButtonGoogle(
    modifier: Modifier = Modifier,
    text: String = String.Empty,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    ButtonSocial(
        modifier = modifier,
        text = text,
        enabled = enabled,
        icon = {
            Image(
                painterResource(
                    id = R.drawable.social_icon_google
                ),
                contentDescription = "social icon"
            )
        },
        backgroundColor = Color.White,
        textColor = Gray700,
        onClick = onClick
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, heightDp = 500)
@Composable
fun PreviewButtonGoogle() {
    GaweanTheme {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                )
        ) {
            ButtonGoogle(
                modifier = Modifier,
                text = "Masuk Dengan Google",
                enabled = true,
                onClick = {}
            )
            ButtonGoogle(
                modifier = Modifier,
                text = "Masuk Dengan Google",
                enabled = false,
                onClick = {}
            )
        }
    }
}
