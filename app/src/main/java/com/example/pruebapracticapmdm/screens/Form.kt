package com.example.pruebapracticapmdm.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.example.pruebapracticapmdm.Info
import com.example.pruebapracticapmdm.navigation.AppScreen
import com.example.pruebapracticapmdm.navigation.AppScreen.Form.info

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

        AddButton(Modifier.align(Alignment.CenterHorizontally),navController,name,surname,dni, age, password){dni="";age="";password=""}
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
fun AddButton(
    modifier: Modifier,
    navController: NavController,
    name: String,
    surname: String,
    dni: String,
    age: String,
    password: String,
    reset: () -> Unit,){
    Button(
        modifier = modifier,
        onClick =
        {
            val r = checkData(name,surname,dni,age,password)
            if (r==0) {
                info = Info(name, surname, dni, age.toInt(), password)
                navController.navigate(route = AppScreen.Salute)
            }else{
                //reset(r)
                reset()
            }
        }
    ){
        Text(text = "Enviar información")
    }
}

fun checkData(name: String, surname: String, dni: String, age: String, password: String): Int {
    return if (name.isBlank()){
        1
    }else if (surname.isBlank()){
        2
    } else if(!checkDNI(dni)){
        3
    }else if (checkInt(age)==-1){
        4
    }else if (password.isBlank()){
        5
    } else{
        0
    }
}

fun checkDNI(dni: String): Boolean {
    val regex = Regex("/([0-9])([A-Z])/")
    //return dni.matches(regex)
    return true
}

fun checkInt(s: String): Int {
    if (s.isBlank()) return -1
    return try {
        s.toInt()
    }catch (e:Exception){
        -1
    }
}