package com.example.crm.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crm.R

@Composable
fun FeedScreen(){
    val miColorPersonalizado = Color(79, 148, 252, 255)
    val miColorPersonalizado3 = Color(79, 102, 252, 255)
    val miColorPersonalizado2 = Color(243, 243, 243, 255)
    val imageResource = painterResource(R.drawable._596121)
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
            text = "Novedades",
            color= Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(top = 21.dp)
        )
    }
    Text(
        text = "Recientes",
        color= miColorPersonalizado3,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 95.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // Define la altura que desees para el fondo gris
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f) // Esto indica que el fondo gris ocupe la mitad del ancho disponible
                .height(550.dp) // Define la misma altura que el Box exterior para coincidir con la altura
                .background(color = miColorPersonalizado2)
                .align(Alignment.BottomEnd) // Alinea el fondo gris a la izquierda
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp)
            ){

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .padding(end = 15.dp)
                                .background(color = Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter= imageResource,
                                contentDescription = "Avatar Icon",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .size(57.dp) // Cambia el tamaño del ícono ajustando el valor aquí
                            )
                            Column (){
                                Text(
                                    text = "Paco Sanchez",
                                    color = Color.Black,
                                    fontSize = 17.sp,
                                    modifier = Modifier
                                        .padding(start=14.dp)
                                )
                                Text(
                                    text = "escribió un comentario",
                                    color = Color.Gray,
                                    fontSize = 17.sp,
                                    modifier = Modifier
                                        .padding(start=14.dp)
                                )
                            }
                            Text(
                                text = "Justo ahora",
                                color = Color.Gray,
                                fontSize = 13.sp,
                                modifier = Modifier
                                    .padding(start=14.dp,bottom = 40.dp)
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .padding(top = 3.dp,end =15.dp)
                                .background(color = Color.White),
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .padding(start=7.dp,)
                                    .background(color = Color.White),
                            ){
                                Text(text = "Hola equipo,\nNecesito ayuda redactando un acuerdo de\nTérminos y Condiciones\n\nGracias\ncc: Laura Pérez",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .padding(end = 15.dp,top = 3.dp)
                                .background(color = Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                Icons.Default.Add,
                                tint = miColorPersonalizado,
                                contentDescription = "Avatar Icon",
                                modifier = Modifier
                                    .padding(start = 170.dp)
                                    .size(25.dp)
                                // Cambia el tamaño del ícono ajustando el valor aquí
                            )
                            Text(
                                text = "Añadir Comentario",
                                color = miColorPersonalizado,
                                fontSize = 17.sp,
                                modifier = Modifier
                                    .padding(start=10.dp,)
                            )

                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(18.dp)) // Ejemplo de un Spacer con una altura de 16dp

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .padding(end = 15.dp)
                                .background(color = Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter= imageResource,
                                contentDescription = "Avatar Icon",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .size(57.dp) // Cambia el tamaño del ícono ajustando el valor aquí
                            )
                            Column (){
                                Text(
                                    text = "Juan Sanchez",
                                    color = Color.Black,
                                    fontSize = 17.sp,
                                    modifier = Modifier
                                        .padding(start=14.dp)
                                )
                                Text(
                                    text = "escribió un comentario",
                                    color = Color.Gray,
                                    fontSize = 17.sp,
                                    modifier = Modifier
                                        .padding(start=14.dp)
                                )
                            }
                            Text(
                                text = "Hace 5 días",
                                color = Color.Gray,
                                fontSize = 13.sp,
                                modifier = Modifier
                                    .padding(start=14.dp,bottom = 40.dp)
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .padding(top = 3.dp,end =15.dp)
                                .background(color = Color.White),
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .padding(start=7.dp,)
                                    .background(color = Color.White),
                            ){
                                Text(text = "Hola equipo,\nNecesito ayuda redactando un acuerdo de\nTérminos y Condiciones\n\nGracias\ncc: Laura Pérez",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .padding(end = 15.dp,top = 3.dp)
                                .background(color = Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                Icons.Default.Add,
                                tint = miColorPersonalizado,
                                contentDescription = "Avatar Icon",
                                modifier = Modifier
                                    .padding(start = 170.dp)
                                    .size(25.dp)
                                // Cambia el tamaño del ícono ajustando el valor aquí
                            )
                            Text(
                                text = "Añadir Comentario",
                                color = miColorPersonalizado,
                                fontSize = 17.sp,
                                modifier = Modifier
                                    .padding(start=10.dp,)
                            )

                        }
                    }
                }


            }
        }

    }
}