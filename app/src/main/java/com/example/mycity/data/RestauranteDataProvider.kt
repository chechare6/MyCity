package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Restaurante

object RestauranteDataProvider {
    val defaultRestaurante = getRestauranteData()[0]

            fun getRestauranteData(): List<Restaurante>{
                return listOf(
                    Restaurante(
                        id = 1,
                        titleResourceId = R.string.burguerKing,
                        imageResourceId = R.drawable.burguer
                    ),
                    Restaurante(
                        id = 2,
                        titleResourceId = R.string.mcDonalds,
                        imageResourceId = R.drawable.mcdondald
                    ),
                    Restaurante(
                        id = 3,
                        titleResourceId = R.string.goiko,
                        imageResourceId = R.drawable.goiko
,                   ),
                    Restaurante(
                        id = 4,
                        titleResourceId = R.string.tagliatella,
                        imageResourceId = R.drawable.tagliatella
                    ),
                    Restaurante(
                        id = 5,
                        titleResourceId = R.string.shifuRamen,
                        imageResourceId = R.drawable.shifuramen
                    )
                )
            }
}