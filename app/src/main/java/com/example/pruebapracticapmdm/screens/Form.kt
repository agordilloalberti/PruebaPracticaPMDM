package com.example.pruebapracticapmdm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.example.pruebapracticapmdm.navigation.AppScreen

@Composable
fun Form(navController: NavController, modifier: Modifier){
    Formulario(navController,modifier)
}

@Composable
fun Formulario(navController: NavController, modifier: Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var dni by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize())
    {
        Text(text = "Titulo", modifier = Modifier.align(Alignment.CenterHorizontally))

        AddTextField("Nombre",Modifier.align(Alignment.CenterHorizontally), VisualTransformation.None,name) {name = it}

        AddTextField("Apellido",Modifier.align(Alignment.CenterHorizontally), VisualTransformation.None,surname) {surname=it}

        AddTextField("DNI",Modifier.align(Alignment.CenterHorizontally), VisualTransformation.None,dni) {dni=it}

        AddTextField("Edad",Modifier.align(Alignment.CenterHorizontally), VisualTransformation.None,age) {age=it}

        AddTextField("Contraseña",Modifier.align(Alignment.CenterHorizontally), PasswordVisualTransformation(),password) {password=it}

        AddButton(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun AddTextField(label:String,modifier: Modifier, transformation: VisualTransformation,text:String,onValueChange:(String) -> Unit) {
    OutlinedTextField(
        value = text,
        modifier = modifier,
        placeholder = { Text(text = "Introduzca aqui su $label") },
        enabled = true,
        onValueChange = onValueChange,
        shape = RectangleShape,
        label = { Text(text = label)},
        visualTransformation = transformation,
        colors = OutlinedTextFieldDefaults.colors()
    )
}

@Composable
fun AddButton(modifier: Modifier,navController: NavController){
    Button(
        modifier = modifier,
        onClick = {navController.navigate(route = AppScreen.Salute)}
    ){

    }
}

fun checkInt(s: String): Int {
    return try {
        s.toInt()
    }catch (e:Exception){
        -1
    }
}