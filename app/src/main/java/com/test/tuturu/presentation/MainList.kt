package com.test.tuturu.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.tuturu.domain.model.Item
import com.test.tuturu.presentation.state.ItemState

@Composable
fun MainList(
    data: ItemState
) {

    if(data.isLoading){
        CircularProgressIndicator(modifier = Modifier)
    }
    else if (!data.isLoading) {
        LazyColumn() {

            itemsIndexed(data.data) { _, item ->
                Card(
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                ) {
                    Text(
                        text = item.name,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

        }

    }

}




