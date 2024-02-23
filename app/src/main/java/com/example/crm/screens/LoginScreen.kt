package com.example.crm.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.crm.MyAppRoute
import com.example.crm.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val nif = remember { mutableStateOf("") }
    val miColorPersonalizado = Color(79, 148, 252, 255)
    val imageResource2 = painterResource(R.drawable.icon2)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = miColorPersonalizado) // Establecer el fondo en azul
            .padding(top = 100.dp)
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {

        Spacer(modifier = Modifier.size(0.dp))

        Image(
            painter = imageResource2,
            contentDescription = "Logo Icon",
            modifier = Modifier
                .size(150.dp) // Cambia el tamaño del ícono ajustando el valor aquí
        )
        Text(
            text = "Iniciar Sesión",
            color = Color.White,
            fontSize = 25.sp,
            style = TextStyle.Default,
        )

        Spacer(modifier = Modifier.size(20.dp))

        Column {
            Column {

                Text("Email", modifier = Modifier.padding(start = 5.dp), color = Color.White)
                        OutlinedTextField(
                        value = nif.value,
                        onValueChange = { nif.value = it },
                        label = { Text("Email") },
                        )

                Spacer(modifier = Modifier.size(8.dp))
                Text("Contraseña", modifier = Modifier.padding(start = 5.dp), color = Color.White)

                    OutlinedTextField(
                        value = nif.value,
                        onValueChange = { nif.value = it },
                        label = { Text("Contraseña") },
                        )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                navController.navigate(MyAppRoute.HOME)
            },

            modifier = Modifier.width(110.dp)
        ) {
            Text("Guardar")
        }
    }
}
}

