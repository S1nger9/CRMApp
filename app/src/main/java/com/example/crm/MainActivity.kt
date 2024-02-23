package com.example.crm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.crm.screens.AddCustomerScreen
import com.example.crm.screens.AddSaleScreen
import com.example.crm.screens.CustomersScreen
import com.example.crm.screens.DeleteScreen
import com.example.crm.screens.EditCustomerScreen
import com.example.crm.screens.EditSaleScreen
import com.example.crm.screens.FeedScreen
import com.example.crm.screens.HomeScreen
import com.example.crm.screens.LoginScreen
import com.example.crm.screens.SalesScreen
import com.example.crm.ui.theme.CRMTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRMTheme {
                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    MyAppNavigationActions(navController)
                }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val selectedDestination = navBackStackEntry?.destination?.route ?: MyAppRoute.HOME


                MyAppContent(
                    navController=navController,
                    selectedDestination = selectedDestination,
                    navigateTopLevelDestination = navigationActions::navigateTo
                )

            }
        }
    }
}



@Composable
fun MyAppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
){
    val nestedNavHostController = rememberNavController()

//Aquí se  maneja la navegación entre diferentes pantallas.
    Row(modifier = modifier.fillMaxSize()){
        Column(modifier = modifier.fillMaxSize(),){
            //Navhost es un contenedor que define el área donde se muestran las diferentes pantallas
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = MyAppRoute.LOGIN
            ){
                composable(MyAppRoute.LOGIN){
                    LoginScreen(navController)
                }
                composable(MyAppRoute.HOME){
                    HomeScreen(navController)
                }
                composable(MyAppRoute.FEED){
                    FeedScreen()
                }
                composable(MyAppRoute.CUSTOMERS){
                    CustomersScreen(navController)
                }
                composable(MyAppRoute.SALES){
                    SalesScreen(navController)
                }
                //Un NestedNavHostController es un NavController que está anidado dentro de otro NavController.
                // Se utiliza en casos donde tienes un nivel adicional de navegación dentro de un destino de navegación principal.
                composable(MyAppRoute.ADD) {
                    AddCustomerScreen(nestedNavHostController)
                }
                composable(MyAppRoute.ADD2) {
                    AddSaleScreen(nestedNavHostController)
                }
                composable("${MyAppRoute.EDIT}/{clienteId}") { backStackEntry ->
                    val editedClientId = backStackEntry.arguments?.getString("clienteId")
                    EditCustomerScreen(nestedNavHostController, clienteId = editedClientId)
                }
                composable( "${MyAppRoute.EDIT2}/{ventaId}") { backStackEntry ->
                    val editedVentaId = backStackEntry.arguments?.getString("ventaId")
                    EditSaleScreen(nestedNavHostController, ventaId = editedVentaId)
                }


            }
            if (selectedDestination != MyAppRoute.LOGIN) {
                MyAppBottomNavigation(
                    selectedDestination = selectedDestination,
                    navigateTopLevelDestination = navigateTopLevelDestination
                )
            }
        }
    }
}

//Diseño de la barra de navegación
@Composable
fun MyAppBottomNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
) {
    val miColorPersonalizado = Color(79, 148, 252, 255)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(miColorPersonalizado)
            .height(84.dp)// Fondo azul del Box
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Espaciado opcional
            horizontalArrangement = Arrangement.SpaceEvenly, // Ajusta el espaciado entre íconos
            verticalAlignment = Alignment.Bottom // Alinea el Row en la parte inferior
        ) {
            TOP_LEVEL_DESTINATIONS.forEach { destinations ->
                NavigationBarItem(
                    selected = selectedDestination == destinations.route,
                    onClick = { navigateTopLevelDestination(destinations) },
                    icon = {
                        Icon(
                            imageVector = destinations.selectedIcon,
                            contentDescription = stringResource(id = destinations.iconTextId)
                        )
                    }
                )
            }
        }
    }
}
