package com.test.simpleapp.domain.model

data class PlanetItem(

    override val name: String,
    val climate: String,
    val diameter: String,
    val gravity: String,
    val orbitalPeriod: String,

): Item() {

    override val details: List<Pair<String, String>> = listOf(
        Pair(climateKey, climate),
        Pair(diameterKey, diameter),
        Pair(gravityKey, gravity),
        Pair(orbitalPeriodKey, orbitalPeriod)
    )

    companion object{
        const val climateKey = "Climate:"
        const val diameterKey = "Diameter:"
        const val gravityKey = "Gravity:"
        const val orbitalPeriodKey = "Orbital period:"
    }

    override fun getDataType(): DataType {
        return DataType.PLANETS
    }


}

