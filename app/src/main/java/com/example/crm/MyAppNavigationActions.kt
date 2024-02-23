package com.example.crm

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination


class MyAppNavigationActions(private val navController: NavController){
    fun navigateTo(destination: MyAppTopLevelDestination){
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

//Características de cada instancia
//El iconTextId sirve para identificar cada destino, para que sepa la aplicación hacia donde
//tiene que navegar
data class MyAppTopLevelDestination(
    val route:String,
    val selectedIcon:ImageVector,
    val iconTextId: Int
)

//Esto una lista que contiene instancias.
//Cada instancia representa un destino de la aplicación.
val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route= MyAppRoute.HOME,
        selectedIcon = Icons.Default.Home,
        // R.string.home es una referencia a este recurso
        iconTextId =R.string.home
    ),MyAppTopLevelDestination(
        route= MyAppRoute.FEED,
        selectedIcon = Icons.Default.Feed,
        iconTextId =R.string.feed
    ),MyAppTopLevelDestination(
        route= MyAppRoute.CUSTOMERS,
        selectedIcon = Icons.Default.Contacts,
        iconTextId =R.string.customers
    ),MyAppTopLevelDestination(
        route= MyAppRoute.SALES,
        selectedIcon = Icons.Default.AddShoppingCart,
        iconTextId =R.string.sales
    ),
)

//Es un objeto que define las constantes para las rutas.
object MyAppRoute{
    const val HOME = "home"
    const val FEED = "feed"
    const val CUSTOMERS = "customers"
    const val SALES = "sales"
    const val ADD = "addcustomers"
    const val ADD2 = "addsales"
    const val EDIT = "edit"
    const val EDIT2 = "edit2"
    const val LOGIN = "login"
}