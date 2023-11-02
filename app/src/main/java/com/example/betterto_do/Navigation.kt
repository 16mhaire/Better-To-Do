package com.example.betterto_do

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun navigateToHome(navController: NavController) {
    // Define a composable function to navigate to the "home" destination
    navController.navigate("home")
}

@Composable
fun navigateToNewDestination(navController: NavController, itemID: String) {
    // Define a composable function to navigate to the "new_destination" with an itemID argument
    navController.navigate("new_destination/$itemID")
}

// Define more navigation functions as needed for your app's screens
