package com.example.pruebapracticapmdm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavController
import com.example.pruebapracticapmdm.Info
import com.example.pruebapracticapmdm.navigation.AppScreen
import com.example.pruebapracticapmdm.navigation.AppScreen.Form.info

@Composable
fun Salute(navController: NavController,modifier: Modifier){
    Saludo(navController,modifier)
}

@Composable
fun Saludo(navController: NavController, modifier: Modifier) {
    Column(modifier=modifier.fillMaxSize()){

        val i = info as Info

        AddText(i,Modifier.align(Alignment.CenterHorizontally))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick =
            {
                navController.navigate(route = AppScreen.Form.toString())
            }
        ){
            Text(text = "Volver al formulario")
        }
    }
}

@Composable
fun AddText(info: Info,modifier: Modifier) {
    val s = "Hola ${info.name} ${info.surname} con dni: ${info.dni}, su información ha sido almacenada\n" +
            "Consulte las opciones que tiene a sus ${info.age} años"

    OutlinedTextField(
        value = s,
        modifier = modifier,
        enabled = true,
        readOnly = true,
        onValueChange = {},
        shape = RectangleShape,
    )
}
