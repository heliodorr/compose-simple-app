package com.test.tuturu.presentation.ui.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun LoadingCase() {
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
fun CommonCard(
    text: String,
    onClick: () -> Unit = {},
    space: Float = 1f
) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth(space)
            .padding(6.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}