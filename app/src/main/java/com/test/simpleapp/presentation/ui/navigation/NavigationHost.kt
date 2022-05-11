package com.test.simpleapp.presentation.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.simpleapp.domain.common.Status
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.presentation.ui.elements.DataView
import com.test.simpleapp.presentation.ui.elements.ItemDetails
import com.test.simpleapp.presentation.vm.MainViewModel

sealed class Nav{

    object ItemsList : Nav(){
        const val ROUTE: String = "items"
        const val DATA_TYPE_ARG: String = "data_type"
        const val COMPLETE_ROUTE: String = "${ROUTE}/{$DATA_TYPE_ARG}"
        fun generateAddress(dataType: String): String {
            return "${ROUTE}/$dataType"
        }
    }
    object DetailsList : Nav(){
        const val ROUTE: String = "details"
        const val INDEX_ARG: String = "index"
        const val COMPLETE_ROUTE: String = "${ROUTE}/{$INDEX_ARG}"
    }


}

fun detailsAddress(index: Int): String {
    return "${Nav.DetailsList.ROUTE}/$index"
}


@Composable
fun ItemsNavigationHost(
    navController: NavHostController,
    viewModel: MainViewModel
){
    NavHost(
        navController = navController,
        startDestination =  Nav.ItemsList.COMPLETE_ROUTE
    ){

       composable(
           route = Nav.ItemsList.COMPLETE_ROUTE,
           arguments = listOf(
               navArgument(Nav.ItemsList.DATA_TYPE_ARG){
                   type = NavType.StringType
                   defaultValue = DataType.PLANETS.name
               }
           )
       ) { backStack ->

           val dataTypeArg: String? = backStack.arguments?.getString(Nav.ItemsList.DATA_TYPE_ARG)

           if (dataTypeArg != null) {
               val dataType: DataType = DataType.getByValue(dataTypeArg)
               viewModel.navigationDataChange(dataType)
           }
           Log.d("AAA", "NavHost ${dataTypeArg}")
           DataView(
               viewModel = viewModel,
               navigation = { index ->
                   navController.navigate(
                       detailsAddress(index)
                   )
               }
           )
       }

       composable(
            route = Nav.DetailsList.COMPLETE_ROUTE,
            arguments = listOf(
                navArgument(Nav.DetailsList.INDEX_ARG) {
                    type = NavType.IntType
                }
            )
       ){ backStack ->

            val index = backStack.arguments?.getInt(Nav.DetailsList.INDEX_ARG) ?: 0
            val itemState = viewModel.itemState.value

            if(itemState !is Status.Loading && itemState.data?.isNotEmpty() == true){

                val item = itemState.data[index]

                ItemDetails(
                    item = item,
                    color = itemState.color
                )

            }

       }

    }

}





