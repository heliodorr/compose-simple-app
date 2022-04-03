package com.test.tuturu.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import com.test.tuturu.presentation.MainList
import com.test.tuturu.presentation.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val myViewModel: MainViewModel by viewModel()

    lateinit var navigationCotroller: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var itemsState = myViewModel.itemsState.value

            MainList(state = itemsState)
        }
    }
}

