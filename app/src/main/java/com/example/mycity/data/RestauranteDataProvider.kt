package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Restaurante

object RestauranteDataProvider {
    val defaultRestaurante = getRestauranteData()[0]

            fun getRestauranteData(): List<Restaurante>{
                return listOf(
                    Restaurante(
                        id = 1,
                        titleResourceId = R.string.laGavia,
                        imageResourceId = R.drawable.laGavia,
                    )
                )
            }
}