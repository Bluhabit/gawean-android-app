/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.feature.authentication.checkEmailResetPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.mvi.Navigation
import app.trian.mvi.ui.UIWrapper
import app.trian.mvi.ui.internal.UIContract
import app.trian.mvi.ui.internal.rememberUIController
import com.bluehabit.core.ui.BaseMainApp
import com.bluehabit.core.ui.R
import com.bluehabit.core.ui.components.button.ButtonOutlinedPrimary
import com.bluehabit.core.ui.components.button.ButtonPrimary
import com.bluehabit.core.ui.routes.AuthenticationConstants
import com.bluehabit.core.ui.routes.Routes

@Navigation(
    route = Routes.CheckEmailResetPassword.routeName,
    group = AuthenticationConstants.parentRoute,
    viewModel = CheckEmailResetPasswordViewModel::class
)
@Composable
fun CheckEmailResetPasswordScreen(
    uiContract: UIContract<CheckEmailResetPasswordState,CheckEmailResetPasswordIntent,CheckEmailResetPasswordAction>
) = UIWrapper(
    uiContract
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.logo_email_notify), contentDescription = "")
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.title_check_email_reset_password),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121),
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = stringResource(id = R.string.detail_check_email_reset_password),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF616161),
            )
            Text(
                text = state.email,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF0074C9),
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 40.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ButtonPrimary(
                text = stringResource(id = R.string.open_email_check_email_reset_password),
                onClick = { dispatch(CheckEmailResetPasswordAction.OpenEmailApplication) }
            )
            ButtonOutlinedPrimary(
                text = stringResource(id = R.string.try_another_email_check_email_reset_password),
                onClick = { dispatch(CheckEmailResetPasswordAction.ChangeEmailForResetPassword) }
            )
        }

    }

}


@Preview
@Composable
fun PreviewScreenSignIn() {
    BaseMainApp {
        CheckEmailResetPasswordScreen(
            uiContract = UIContract(
                controller = rememberUIController(),
                state = CheckEmailResetPasswordState()
            )
        )
    }
}
