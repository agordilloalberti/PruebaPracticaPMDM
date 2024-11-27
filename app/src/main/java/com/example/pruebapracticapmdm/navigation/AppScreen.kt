package com.example.pruebapracticapmdm.navigation

sealed class AppScreen(val route: String) {
    object Form: AppScreen("Form")
    object Salute: AppScreen("Salute")
}