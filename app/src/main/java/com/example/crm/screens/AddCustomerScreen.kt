package com.example.crm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.crm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCustomerScreen(navController: NavHostController) {
    val nif = remember { mutableStateOf("") }
    val nombre = remember { mutableStateOf("") }
    val direccion = remember { mutableStateOf("") }
    val telefono = remember { mutableStateOf("") }
    val mensajeConfirmacion = remember { mutableStateOf("") }
    val miColorPersonalizado = Color(79, 173, 252)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(
            text = "Guardar Cliente",
            color = Color.Black,
            fontSize = 25.sp,
            style = TextStyle.Default,
        )

        Spacer(modifier = Modifier.size(35.dp))

        OutlinedTextField(
            value = nif.value,
            onValueChange = { nif.value = it },
            label = { Text("NIF") }
        )
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = direccion.value,
            onValueChange = { direccion.value = it },
            label = { Text("Dirección") }
        )
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = telefono.value,
            onValueChange = { telefono.value = it },
            label = { Text("Teléfono") }
        )

        Spacer(modifier = Modifier.size(25.dp))




        Button(
            onClick = {
                val db = Firebase.firestore
                val coleccion = "clientes"
                val nuevoDocumento = db.collection(coleccion).document()

                val datosCliente = hashMapOf(
                    "nif" to nif.value,
                    "nombre" to nombre.value,
                    "direccion" to direccion.value,
                    "telefono" to telefono.value
                )

                nuevoDocumento
                    .set(datosCliente)
                    .addOnSuccessListener { documentReference ->
                        mensajeConfirmacion.value = "Datos guardados correctamente"
                        nif.value = ""
                        nombre.value = ""
                        direccion.value = ""
                        telefono.value = ""
                    }
                    .addOnFailureListener { e ->
                        mensajeConfirmacion.value = "Error al guardar datos: $e"
                    }
            },

            modifier = Modifier.width(110.dp)
        ) {
            Text("Guardar")
        }


        Spacer(modifier = Modifier.size(25.dp))


    }
}
