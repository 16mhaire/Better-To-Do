package com.example.betterto_do


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Use the theme from MaterialTheme
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        // Add the HomeScreen composable for the "home" destination
                        composable("home") {
                            HomeScreen(navController)
                        }

                        // Add more destinations here
                        composable("new_destination/{itemID}") { backStackEntry ->
                            val itemID = backStackEntry.arguments?.getString("itemID")
                            // Use the itemID to display the details of the selected item
                            // You can pass this itemID to the composable for the new destination
                            // Create a composable for this destination and use the itemID
                        }

                        // Define routes for other screens as needed
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        @Composable


        fun Greeting(name: String, modifier: Modifier = Modifier) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
        Greeting("Android")
    }
}