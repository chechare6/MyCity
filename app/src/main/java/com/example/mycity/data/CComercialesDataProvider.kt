package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.CComercial

object CComercialesDataProvider {
    val defaultCComercial = getCComercialesData()[0]

    fun getCComercialesData(): List<CComercial> {
        return listOf(
            CComercial(
                id = 1,
                titleResourceId = R.string.laGavia,
                imageResourceId = R.drawable.lagavia
            ),
            CComercial(
                id = 2,
                titleResourceId = R.string.laVaguada,
                imageResourceId = R.drawable.lavaguada
            ),
            CComercial(
                id = 3,
                titleResourceId = R.string.h2ocio,
                imageResourceId = R.drawable.h2ocio
            ),
            CComercial(
                id = 4,
                titleResourceId = R.string.pPio,
                imageResourceId = R.drawable.ppio
            ),
            CComercial(
                id = 5,
                titleResourceId = R.string.plenilunio,
                imageResourceId = R.drawable.plenilunio
            )
        )
    }

}