package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Cafeteria

object CafeteriasDataProvider {
    val defaultCafeteria = getCafeteriaData()[0]

    fun getCafeteriaData(): List<Cafeteria> {
        return listOf(
            Cafeteria(
                id = 1,
                titleResourceId = R.string.starbucks,
                imageResourceId = R.drawable.starbucks
            ),
            Cafeteria(
                id = 2,
                titleResourceId = R.string.rodilla,
                imageResourceId = R.drawable.rodilla
            ),
            Cafeteria(
                id = 3,
                titleResourceId = R.string.costaCoffe,
                imageResourceId = R.drawable.costacoffe
            ),
            Cafeteria(
                id = 4,
                titleResourceId = R.string.cafeTe,
                imageResourceId = R.drawable.te
            ),
            Cafeteria(
                id = 5,
                titleResourceId = R.string.timHorton,
                imageResourceId = R.drawable.timhortons
            )
        )
    }
}