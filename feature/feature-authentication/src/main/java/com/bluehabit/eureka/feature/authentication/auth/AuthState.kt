/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.feature.authentication.auth

import android.os.Parcelable
import app.trian.mvi.ui.extensions.Empty
import app.trian.mvi.ui.internal.contract.MviState
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class AuthState(
    val email: String = String.Empty,
    val password: String = String.Empty,
    val isRememberChecked:Boolean=false,

    //tabs
    val tabs: @RawValue List<String> = listOf("Masuk", "Daftar"),
    val selectedTab:Int=0,
    //
    override val effect: @RawValue AuthEffect = AuthEffect.Nothing
) : MviState<AuthEffect>(), Parcelable
