package com.helio.compose.simpleapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.helio.compose.simpleapp.presentation.ui.screen.AppScreen
import com.helio.compose.simpleapp.presentation.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val myViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppScreen(viewModel = myViewModel)
        }
    }
}

