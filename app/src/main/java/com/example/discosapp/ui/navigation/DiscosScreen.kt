package com.example.discosapp.ui.navigation

sealed class DiscosScreen(val route: String) {
    object HomeScreen : DiscosScreen("home")
    object AddDiscoScreen : DiscosScreen("add_disco")
    object DetalleScreen : DiscosScreen("detalle_disco/{discoId}") {
        fun createRoute(discoId: Int) = "detalle_disco/$discoId"
    }
}