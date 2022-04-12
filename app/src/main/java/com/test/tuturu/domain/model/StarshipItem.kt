package com.test.tuturu.domain.model

data class StarshipItem(
    override val name: String,
    val model: String,
    val manufacturer: String,
    val length: String,
    val costInCredits: String,
    val crew: String,
    val passengers: String,
    val starshipClass: String,
    val cargoCapacity: String
) : Item() {

    override val data: List<Pair<String, String>> = listOf(
        Pair(modelKey, model),
        Pair(manufacturerKey, manufacturer),
        Pair(lengthKey, length),
        Pair(costInCreditsKey, costInCredits)
    )

    companion object {
       const val modelKey = "Model:"
       const val manufacturerKey = "Manufacturer:"
       const val lengthKey = "Length:"
       const val costInCreditsKey = "Cost in credits:"
    }

    override fun getDataType(): DataType {
        return DataType.STARSHIPS
    }


}

