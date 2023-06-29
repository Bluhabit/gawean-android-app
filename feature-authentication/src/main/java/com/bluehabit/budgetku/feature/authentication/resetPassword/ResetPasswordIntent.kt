/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.feature.authentication.resetPassword

sealed interface ResetPasswordIntent {
    object ValidateEmailAddress : ResetPasswordIntent
    class SendLinkResetPasswordToEmail(var email: String): ResetPasswordIntent
}