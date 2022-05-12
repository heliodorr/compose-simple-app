package com.helio.compose.simpleapp.presentation.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.helio.compose.simpleapp.domain.model.DataType

@Composable
fun TopBar(
    onButtonClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text("Test app")
        },
        navigationIcon = {
            IconButton(onClick = onButtonClicked) {
                Icon(Icons.Rounded.Menu, "")
            }
        }
    )

}


@Composable
fun SideBar(
    navigation: (dataType:String) -> Unit,
){
    Column(
        modifier = Modifier
            .background(color = Color.White)
    ){
        for(dataType in DataType.values()){
            CommonCard(
                text = dataType.name,
                onClick = {
                    navigation(dataType.name)
                }
            )
        }

    }
}