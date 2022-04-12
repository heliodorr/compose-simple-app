package com.test.tuturu.domain.model

data class PlanetItem(
    override val name: String,
    val climate: String,
    val diameter: String,
    val gravity: String,
    val orbitalPeriod: String,
    val population: String,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String
): Item() {

    override val data: List<Pair<String, String>> = listOf(
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

