package com.example.pruebapracticapmdm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

        AddText(i.name,Modifier.align(Alignment.CenterHorizontally))
        AddText(i.surname,Modifier.align(Alignment.CenterHorizontally))
        AddText(i.dni,Modifier.align(Alignment.CenterHorizontally))
        AddText(i.age.toString(),Modifier.align(Alignment.CenterHorizontally))
        AddText(occult(i.password),Modifier.align(Alignment.CenterHorizontally))

        Button(
            modifier = modifier,
            onClick =
            {
                navController.navigate(route = AppScreen.Form)
            }
        ){
            Text(text = "Volver al formulario")
        }
    }
}

@Composable
fun AddText(text: String,modifier: Modifier) {
    Text(text=text,modifier=modifier)
}

fun occult(s: String): String {
    var r =""
    for (c in s){
        r+="·"
    }
    return r
}
