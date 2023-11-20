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
                    titleResourceId = R.string.retiro,
                    imageResourceId = R.drawable.retiro
                ),
                Parque(
                    id = 2,
                    titleResourceId = R.string.jcPrimero,
                    imageResourceId = R.drawable.jcprimero
                ),
                Parque(
                    id = 3,
                    titleResourceId = R.string.dehesaVilla,
                    imageResourceId = R.drawable.dehesavilla
                ),
                Parque(
                    id = 4,
                    titleResourceId = R.string.delOeste,
                    imageResourceId = R.drawable.deloeste
                ),
                Parque(
                    id = 5,
                    titleResourceId = R.string.deAustria,
                    imageResourceId = R.drawable.mariaaustria
                )
            )
    }
}