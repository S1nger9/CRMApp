package com.example.crm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MiscellaneousServices
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.crm.MyAppRoute
import com.example.crm.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesScreen(navController: NavHostController){

        val ventasRecuperadas = remember { mutableStateOf<List<String>>(emptyList()) }
        val miColorPersonalizado = Color(202, 253, 187, 255)
        val miColorPersonalizado2 = Color(76, 175, 80, 255)
        val miColorPersonalizado3 = Color(79, 148, 252, 255)
        val miColorPersonalizado4 = Color(79, 173, 252)
        val imageResource2 = painterResource(R.drawable.icon2)



        LaunchedEffect(Unit) {
            val db = Firebase.firestore
            val coleccion = "ventas"

            try {
                val querySnapshot = db.collection(coleccion).get().await()
                val ventas = mutableListOf<String>()

                for (document in querySnapshot) {
                    val ventasId = document.id
                    val identificador = document.getString("identificador")
                    val nombre = document.getString("nombre")
                    val precio = document.getString("precio")
                    val fecha = document.getString("fecha")
                    val ventaInfo = buildString {
                        appendLine("ID: $ventasId")
                        appendLine("Identificador: $identificador")
                        appendLine("Nombre: $nombre")
                        appendLine("Fecha: $fecha")
                        appendLine("Precio: $precio")
                        // Agregar los demás datos aquí...
                        // appendLine("Dirección: ${document.getString("direccion")}")
                        // appendLine("Teléfono: ${document.getString("telefono")}")
                    }
                    ventas.add(ventaInfo)
                }

                ventasRecuperadas.value = ventas
            } catch (exception: Exception) {
                // Manejar la excepción si ocurre algún error al obtener datos
                // Por ejemplo: Log.e("CustomersScreen", "Error: ${exception.message}")
            }
        }

        val showDialog = remember { mutableStateOf(false) }
        val selectedVentaInfo = remember { mutableStateOf("") }

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                    selectedVentaInfo.value = ""
                },
                title = {
                    Text(
                        text = "Detalles de la venta",
                        fontSize = 19.sp, // Tamaño del título aumentado a 20sp
                        fontWeight = FontWeight.Bold // Fuente en negrita
                    )
                },
                text = {
                    Text(
                        text = buildAnnotatedString {
                            selectedVentaInfo.value.split("\n").forEachIndexed { index, line ->
                                append(line)
                                if (index < selectedVentaInfo.value.split("\n").size - 1) {
                                    append("\n\n") // Agregar espacio solo entre líneas
                                }
                            }
                        },
                        fontSize = 20.sp
                    )
                },
                confirmButton = {
                    Spacer(modifier = Modifier.height(8.dp)) // Espacio entre el texto y el botón
                    Button(onClick = { showDialog.value = false }) {
                        Text(text = "Cerrar")
                    }
                }
            )

        }
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(color = miColorPersonalizado3)
                            .align(Alignment.TopCenter)
                    )
                    Image(
                        painter = imageResource2,
                        contentDescription = "Logo Icon",
                        modifier = Modifier
                            .padding(top=10.dp, start = 5.dp)
                            .size(60.dp) // Cambia el tamaño del ícono ajustando el valor aquí
                    )
                    Text(
                        text = "Ventas",
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .align(Alignment.TopCenter)
                    )
                }
            },
            content = {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(800.dp) // Altura fija para la sección de clientes
                            .padding(top=90.dp,bottom = 95.dp) // Espacio para el botón de agregar
                    ) {

                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        )
                        {
                            items(ventasRecuperadas.value) { ventaInfo ->
                                val parts = ventaInfo.split("\n")
                                val identificador = parts.find { it.startsWith("Identificador:") }
                                val nombre = parts.find { it.startsWith("Nombre:") }
                                val ventaId = parts.find { it.startsWith("ID:") }?.replace("ID:", "")?.trim() ?: ""

                                if (nombre != null && identificador != null) {
                                    val modifiedNombre = nombre.replace("Nombre:", "").trim()
                                    val modifiedIdentificador = identificador.replace("Identificador:", "").trim()

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                selectedVentaInfo.value = ventaInfo
                                                showDialog.value = true
                                            }
                                            .padding(top = 16.dp)
                                            .padding(vertical = 8.dp, horizontal = 16.dp)
                                            .background(color = miColorPersonalizado)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(70.dp)
                                                .padding(8.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                Icons.Default.MiscellaneousServices,
                                                contentDescription = "Icono de venta",
                                                tint = Color.Black,
                                                modifier = Modifier
                                                    .padding(4.dp)
                                                    .size(40.dp)
                                            )
                                            Spacer(modifier = Modifier.width(11.dp))
                                            Text(
                                                text = "$modifiedNombre",
                                                color = Color.Black,
                                                modifier = Modifier
                                                    .padding(4.dp)
                                                    .scale(1.2f)
                                            )
                                            Spacer(modifier = Modifier.width(20.dp))
                                            Text(
                                                text = "$modifiedIdentificador",
                                                color = Color.Black,
                                                modifier = Modifier
                                                    .padding(4.dp)
                                                    .scale(1.2f)
                                            )
                                            Spacer(modifier = Modifier.width(30.dp))
                                            Spacer(modifier = Modifier.weight(1f))
                                            Icon(
                                                Icons.Default.Edit,
                                                contentDescription = "Editar",
                                                tint = miColorPersonalizado2,
                                                modifier = Modifier
                                                    .padding(4.dp)
                                                    .size(24.dp)
                                                    .clickable {
                                                        // Abrir pantalla de edición con los datos del cliente seleccionado
                                                        navController.navigate("${MyAppRoute.EDIT2}/$ventaId")
                                                    }

                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            // Icono de Eliminar
                                            Icon(
                                                Icons.Default.Delete,
                                                contentDescription = "Eliminar",
                                                tint = Color.Red,
                                                modifier = Modifier
                                                    .padding(4.dp)
                                                    .size(24.dp)
                                                    .clickable {
                                                        // Realizar la eliminación del cliente
                                                        eliminarVenta(ventaId) {
                                                            // En este bloque de código se actualizará la lista de clientes
                                                            obtenerVentas(ventasRecuperadas)
                                                        }// Suponiendo que tienes el ID del cliente
                                                    }
                                            )

                                        }
                                    }
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(start = 240.dp, bottom = 16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                                .background(color = miColorPersonalizado4)
                                .clickable {
                                    navController.navigate(MyAppRoute.ADD2)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Agregar",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        )
    }
    private fun eliminarVenta(ventaId: String, onVentaEliminado: () -> Unit) {
        val db = Firebase.firestore
        val coleccion = "ventas"

        db.collection(coleccion)
            .document(ventaId)
            .delete()
            .addOnSuccessListener {
                // Invocar la función onClienteEliminado después de eliminar el cliente
                onVentaEliminado()
            }
            .addOnFailureListener {
                // Manejar errores en caso de fallo al eliminar
            }
    }
    private fun obtenerVentas(ventasRecuperadas: MutableState<List<String>>) {
        val db = Firebase.firestore
        val coleccion = "ventas"

        db.collection(coleccion)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val updatedVentas = mutableListOf<String>()

                for (document in querySnapshot) {
                    val ventaId = document.id
                    val identificador = document.getString("identificador")
                    val nombre = document.getString("nombre")
                    val precio = document.getString("precio")
                    val fecha = document.getString("fecha")
                    val ventaInfo = buildString {
                        appendLine("ID: $ventaId")
                        appendLine("Identificador: $identificador")
                        appendLine("Nombre: $nombre")
                        appendLine("Precio: $precio")
                        appendLine("Fecha: $fecha")
                        // Agregar los demás datos aquí...
                    }
                    updatedVentas.add(ventaInfo)
                }

                ventasRecuperadas.value = updatedVentas
            }
            .addOnFailureListener {
                // Manejar errores en caso de falla al obtener clientes
            }
    }