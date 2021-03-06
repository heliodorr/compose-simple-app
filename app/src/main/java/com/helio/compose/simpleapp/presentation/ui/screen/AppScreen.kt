package com.helio.compose.simpleapp.presentation.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.helio.compose.simpleapp.presentation.ui.elements.SideBar
import com.helio.compose.simpleapp.presentation.ui.elements.TopBar
import com.helio.compose.simpleapp.presentation.ui.navigation.ItemsNavigationHost
import com.helio.compose.simpleapp.presentation.ui.navigation.Nav
import com.helio.compose.simpleapp.presentation.vm.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun AppScreen(
    viewModel: MainViewModel
){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigation: (String) -> Unit = {dataType ->
        navController.navigate(
            Nav.ItemsList.generateAddress(dataType = dataType)
        )
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                onButtonClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            SideBar(navigation = navigation)
        }
    ) {

        ItemsNavigationHost(
            navController = navController,
            viewModel = viewModel
        )
    }

}