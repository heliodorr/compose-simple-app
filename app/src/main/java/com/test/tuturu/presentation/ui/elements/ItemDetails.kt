package com.test.tuturu.presentation.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.test.tuturu.domain.model.Item

@Composable
fun ItemDetails(
    item: Item,
){
    Column {
        Row {
            CommonCard(text = item.name)
        }
        LazyColumn {

            items(item.data){ data->
                Row {
                    CommonCard(
                        text = data.first,
                        space = 0.4f

                    )
                    CommonCard(
                        text = data.second,
                        space = 1f
                    )

                }

            }

        }

    }
}
