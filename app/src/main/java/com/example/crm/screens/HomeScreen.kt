package com.example.crm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.crm.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    val imageResource = painterResource(R.drawable._596121)
    val miColorPersonalizado = Color(79, 148, 252, 255)
    val miColorPersonalizado2 = Color(243, 243, 243, 255)
    val imageResource2 = painterResource(R.drawable.icon2)


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp) // Altura del área de color en la parte superior
                .background(color = miColorPersonalizado)
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
            text = "Inicio",
            color= Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(top = 21.dp)
        )

        Image(
            painter= imageResource,
            contentDescription = "Avatar Icon",
            modifier = Modifier
                .padding(top = 90.dp)
                .size(120.dp) // Cambia el tamaño del ícono ajustando el valor aquí
                .align(Alignment.TopCenter)
        )
    }

    val daysOfWeek = listOf("LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM")


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 250.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Diciembre 2023",
            fontSize = 23.sp)

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 145.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until 7) {
            val day = daysOfWeek[i]
            val numberToShow = (i + 7).toString()

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Column() {
                    Text(
                        text = day,
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Text(
                        text = numberToShow,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // Define la altura que desees para el fondo gris
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f) // Esto indica que el fondo gris ocupe la mitad del ancho disponible
                .height(370.dp) // Define la misma altura que el Box exterior para coincidir con la altura
                .background(color = miColorPersonalizado2)
                .align(Alignment.BottomEnd) // Alinea el fondo gris a la izquierda
        ){

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp)
            ){
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "EVENTOS",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                        Icon(
                            Icons.Default.Add,
                            tint = miColorPersonalizado,
                            contentDescription = "Avatar Icon",
                            modifier = Modifier
                                .padding(start = 250.dp)
                                .size(30.dp)
                        // Cambia el tamaño del ícono ajustando el valor aquí
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(end =15.dp)
                            .background(color= Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Text(text = "10:00 AM",
                            color = Color.Gray,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 5.dp))

                        Text(text = "Revisión de proyectos",
                            color = Color.Black,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(top=3.dp,end =15.dp)
                            .background(color= Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Text(text = "17:00 AM",
                            color = Color.Gray,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 5.dp))

                        Text(text = "Reunión",
                            color = Color.Black,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 150.dp)
            ){
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                            Text(text = "TAREAS",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                        Icon(
                            Icons.Default.Add,
                            tint = miColorPersonalizado,
                            contentDescription = "Avatar Icon",
                            modifier = Modifier
                                .padding(start = 261.dp)
                                .size(30.dp)
                            // Cambia el tamaño del ícono ajustando el valor aquí
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(top=3.dp,end =15.dp)
                            .background(color= Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Icon(
                            Icons.Default.CropSquare,
                            tint = Color.Gray,
                            contentDescription = "Avatar Icon",
                            modifier = Modifier
                                .padding(start = 13.dp)
                                .size(25.dp)
                            // Cambia el tamaño del ícono ajustando el valor aquí
                        )

                        Text(text = "Producto Demo",
                            color = Color.Black,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(top=3.dp,end =15.dp)
                            .background(color= Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Icon(
                            Icons.Default.CropSquare,
                            tint = Color.Gray,
                            contentDescription = "Avatar Icon",
                            modifier = Modifier
                                .padding(start = 13.dp)
                                .size(25.dp)
                            // Cambia el tamaño del ícono ajustando el valor aquí
                        )
                        Text(text = "Prototipo",
                            color = Color.Black,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }

                }
            }

        }
    }
}
