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
                imageResourceId = R.drawable.laGavia,
            )
        )
    }

}