package com.helio.compose.simpleapp.presentation.ui.elements



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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
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
fun NotificationText(
    text: String
){
    Text(
        fontSize = 20.sp,
        color = Color.Gray,
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(vertical = 10.dp)
    )
}

@Composable
fun CommonCard(
    text: String,
    textColor: Color = Color.Black,
    onClick: () -> Unit = {},
    widthMultiplier: Float = 1f
) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth(widthMultiplier)
            .padding(6.dp)
            .clickable { onClick() }
    ) {
        Text(
            color = textColor,
            text = text,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}