package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val detailsId: Int,
    @DrawableRes val imageResourceId: Int
)
