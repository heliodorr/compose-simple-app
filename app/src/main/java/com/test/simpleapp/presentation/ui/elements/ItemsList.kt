package com.test.simpleapp.presentation.ui.elements

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.test.simpleapp.domain.common.Status
import com.test.simpleapp.domain.model.Item
import com.test.simpleapp.presentation.vm.MainViewModel


@Composable
fun DataView(
    viewModel: MainViewModel,
    navigation: (Int) -> Unit
){
    val state = viewModel.itemState

    SwipeRefresh(
        state = rememberSwipeRefreshState(state.value is Status.Loading),
        onRefresh = {
            Log.d("AAA", "COMPOSE/SWIPEREFRESH")
            viewModel.refresh()
                    },
    ) {
        Log.d("AAA", "COMPOSE/TRYIN TO LOAD ITEMSLIST")
        ItemsList(
            status = viewModel.itemState.value,
            navigation = navigation
        )
    }
}


@Composable
fun ItemsList(
    status: Status<List<Item>>,
    navigation: (Int) -> Unit
) {

    val data = status.data ?: emptyList<Item>()
    when(status) {
        is Status.Loading -> {
            Log.d("AAA", "COMPOSE/Loadingcase")
            LoadingCase()
        }
        is Status.Success<List<Item>> -> {
            Log.d("AAA", "COMPOSE/Success")
            ShowData(
                data = data,
                navigation = navigation,
                color = status.color
            )
        }
        is Status.Outdated<List<Item>> -> {
            Log.d("AAA", "COMPOSE/ItemsListError")
            Column {
                Row (
                    modifier = Modifier.align(
                        alignment = Alignment.CenterHorizontally
                    )
                ){
                    NotificationText(text = "Unable to refresh")
                }
                ShowData(
                    data = data,
                    navigation = navigation,
                    color = status.color
                )
            }
        }
        is Status.Error<List<Item>> -> {
            Log.d("AAA", "COMPOSE/ItemsListError")
            Column {
                Row (modifier = Modifier.fillMaxWidth()){
                    NotificationText(text = "Unable to refresh")
                }
                ShowData(
                    data = data,
                    navigation = navigation,
                    color = status.color
                )
            }
        }

    }
}

@Composable
fun ShowData (
    data: List<Item>,
    navigation: (Int) -> Unit,
    color: Color,
) {
    LazyColumn {
        itemsIndexed(data) { index, item ->
            CommonCard(
                text = item.name,
                onClick = { navigation(index) },
                textColor = color
            )
        }
    }

}
