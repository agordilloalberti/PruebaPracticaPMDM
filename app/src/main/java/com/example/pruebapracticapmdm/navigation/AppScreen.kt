package com.example.pruebapracticapmdm.navigation

open class AppScreen(val route: String) {
    var info: Any? = null
    data object Form: AppScreen("Form")
    data object Salute: AppScreen("Salute")
}