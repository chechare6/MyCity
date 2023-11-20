package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Recommendation

object RecommendationDataProvider {
    val defaultRecommendation = getRecommendationData(R.string.CComerciales)[0]

    fun getRecommendationData(activity: Int): List<Recommendation> {
        val cComercialList = listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.laGavia,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.laGavia
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string.laVaguada,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.lavaguada
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.pPio,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.ppio
            ),
            Recommendation(
                id = 4,
                titleResourceId = R.string.h2ocio,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.h2ocio
            ),
            Recommendation(
                id = 5,
                titleResourceId = R.string.plenilunio,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.plenilunio
            )
        )

        val parquesList = listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.retiro,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.retiro
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string.jcPrimero,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.jcprimero
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.delOeste,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.deloeste
            ),
            Recommendation(
                id = 4,
                titleResourceId = R.string.dehesaVilla,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.dehesavilla
            ),
            Recommendation(
                id = 5,
                titleResourceId = R.string.deAustria,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.mariaaustria
            )
        )

        val cafeteriaList = listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.starbucks,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.starbucks
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string.rodilla,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.rodilla
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.costaCoffe,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.costacoffe
            ),
            Recommendation(
                id = 4,
                titleResourceId = R.string.cafeTe,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.te
            ),
            Recommendation(
                id = 5,
                titleResourceId = R.string.timHorton,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.timhortons
            )
        )

        val restauranteList = listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.burguerKing,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.burguer
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string.mcDonalds,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.mcdondald
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.goiko,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.goiko
            ),
            Recommendation(
                id = 4,
                titleResourceId = R.string.tagliatella,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.tagliatella
            ),
            Recommendation(
                id = 5,
                titleResourceId = R.string.shifuRamen,
                detailsId = R.string.loremIpsum,
                imageResourceId = R.drawable.shifuramen
            )
        )

        when(activity) {
            R.string.CComerciales -> return cComercialList
            R.string.Parques -> return parquesList
            R.string.Cafeterias -> return cafeteriaList
            R.string.Restaurantes -> return restauranteList

            else -> return cComercialList
        }
    }
}