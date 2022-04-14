package com.test.simpleapp.presentation.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.test.simpleapp.domain.model.Item


@Composable
fun ItemsList(
    data: List<Item>,
    isLoading: Boolean,
    navigation: (Int) -> Unit
) {
    if (isLoading) {
        LoadingCase()
    } else {
        ItemsLoadedCase(
            data = data,
            navigation = navigation
        )
    }
}

@Composable
fun ItemsLoadedCase (
    data: List<Item>,
    navigation: (Int) -> Unit
) {
    LazyColumn {
        itemsIndexed(data) { index, item ->
            CommonCard(
                text = item.name,
                onClick = { navigation(index) }
            )
        }
    }

}
