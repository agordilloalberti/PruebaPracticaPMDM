package com.example.pruebapracticapmdm.navigation

sealed class AppScreen(val route: String) {
    var info: Any? = null
    object Form: AppScreen("Form")
    object Salute: AppScreen("Salute")
}