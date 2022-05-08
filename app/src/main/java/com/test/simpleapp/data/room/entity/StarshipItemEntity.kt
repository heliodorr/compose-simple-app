package com.test.simpleapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.test.simpleapp.domain.model.StarshipItem

@Entity(
    tableName = "starships"
)
data class StarshipItemEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0L,

    val name: String,

    val model: String,

    val manufacturer: String,

    val length: String,

    @ColumnInfo(name = "cost_in_credits")
    val costInCredits: String,

){

    constructor(starshipItem: StarshipItem): this(
        name = starshipItem.name,
        costInCredits = starshipItem.costInCredits,
        length = starshipItem.length,
        manufacturer = starshipItem.manufacturer,
        model = starshipItem.model,
    )

    fun toStarshipItem(): StarshipItem {
        return StarshipItem(
            name = name,
            costInCredits = costInCredits,
            length = length,
            manufacturer = manufacturer,
            model = model,
        )
    }

}



