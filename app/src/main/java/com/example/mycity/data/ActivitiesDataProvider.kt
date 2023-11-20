package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Activities

object ActivitiesDataProvider {
    val defaultActivity = getActivityData()[0]

    fun getActivityData(): List<Activities> {
        return listOf(
            Activities(
                id = 1,
                titleResourceId = R.string.CComerciales,
                imageResourceId = R.drawable.ccomercial
            ),
            Activities(
                id = 2,
                titleResourceId = R.string.Parques,
                imageResourceId = R.drawable.parques
            ),
            Activities(
                id = 3,
                titleResourceId = R.string.Cafeterias,
                imageResourceId = R.drawable.cafeterias
            ),
            Activities(
                id = 4,
                titleResourceId = R.string.Restaurantes,
                imageResourceId = R.drawable.restaurantes
            )
        )
    }
}