package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.CComercial
import com.example.mycity.model.Parque

object ParqueDataProvider {
    val defaultParque = getParqueData()[0]

    fun getParqueData(): List<Parque>{
            return listOf(
                Parque(
                    id = 1,
                    titleResourceId = R.string.laGavia,
                    imageResourceId = R.drawable.laGavia,
                )
            )
    }
}