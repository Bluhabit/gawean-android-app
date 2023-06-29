/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.feature.budget.detailTransaction

import android.os.Parcelable
import com.bluehabit.budgetku.feature.budget.detailTransaction.components.DetailTransactionBottomSheetType
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import javax.annotation.concurrent.Immutable



@Immutable
@Parcelize
data class DetailTransactionState(
    val bottomSheetType: DetailTransactionBottomSheetType = DetailTransactionBottomSheetType.DELETE_CONFIRMATION,
    //data
    val transactionAmount: BigDecimal = BigDecimal(50_000),
    val transactionName: String = "",
    val transactionAccountName: String = "",
    val transactionDate: String="",
    val transactionCategory: String = "",
    val transactionType: String = "",
    val transactionIcon:Int = 0,
    val transactionAccountIcon:Int=0,

    val isLoading:Boolean = true
) : Parcelable

