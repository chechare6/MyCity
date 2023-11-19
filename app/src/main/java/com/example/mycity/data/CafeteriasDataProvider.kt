package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Cafeteria

object CafeteriasDataProvider {
    val defaultCafeteria = getCafeteriaData()[0]

    fun getCafeteriaData(): List<Cafeteria> {
        return listOf(
            Cafeteria(
                id = 1,
                titleResourceId = R.string.laGavia,
                imageResourceId = R.drawable.laGavia,
            )
        )
    }
}