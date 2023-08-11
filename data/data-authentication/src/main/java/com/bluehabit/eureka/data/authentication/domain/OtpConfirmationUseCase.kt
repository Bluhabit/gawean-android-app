/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.data.authentication.domain

import com.bluehabit.eureka.data.authentication.datasource.remote.response.OtpConfirmationResponse
import com.bluehabit.eureka.data.authentication.repositories.SignUpRepository
import com.bluehabit.eureka.data.common.Response
import javax.inject.Inject

class OtpConfirmationUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    suspend operator fun invoke(otp: String): Response<OtpConfirmationResponse> =
        signUpRepository.otpConfirmation(otp)
}