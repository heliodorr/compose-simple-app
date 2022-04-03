package com.test.tuturu.presentation

import androidx.compose.foundation.layout.Box
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
import com.test.tuturu.presentation.vm.state.ItemsState

@Composable
fun MainList(
    state: ItemsState
) {

    if(state.isLoading){
        ItemsLoadingCase()
    } else if (!state.isLoading) {
        ItemsLoadedCase(data = state.data)
    }

}

@Composable
fun ItemsLoadingCase() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

}


@Composable
fun ItemsLoadedCase (data: List<Item>) {

    LazyColumn {
        itemsIndexed(data) { _, item ->
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

