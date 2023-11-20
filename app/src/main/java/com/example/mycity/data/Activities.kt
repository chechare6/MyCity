package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Activities

object Activities {
    val defaultActivity = getActivityData()[0]

    private fun getActivityData(): List<Activities> {
        return listOf(
            Activities(
                id = 1,
                titleResourceId = R.string.CComerciales,
                imageResourceId = R.drawable.laGavia
            ),
            Activities(
                id = 2,
                titleResourceId = R.string.Parques,
                imageResourceId = R.drawable.laGavia
            ),
            Activities(
                id = 3,
                titleResourceId = R.string.Cafeterias,
                imageResourceId = R.drawable.laGavia
            ),
            Activities(
                id = 4,
                titleResourceId = R.string.Restaurantes,
                imageResourceId = R.drawable.laGavia
            )
        )
    }
}