package com.helio.compose.simpleapp.presentation.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.helio.compose.simpleapp.domain.model.Item
import com.helio.compose.simpleapp.presentation.ui.elements.CommonCard


@Composable
fun ItemDetails(
    item: Item,
    color: Color
){
    Column {
        Row {
            CommonCard(
                text = item.name
            )
        }
        LazyColumn {

            items(item.details){ data ->
                Row {
                    CommonCard(
                        text = data.first,
                        textColor = color,
                        widthMultiplier = 0.4f
                    )
                    CommonCard(
                        text = data.second,
                        textColor = color,
                        widthMultiplier = 1f
                    )

                }

            }

        }

    }
}
