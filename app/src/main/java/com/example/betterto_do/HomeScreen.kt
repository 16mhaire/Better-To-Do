package com.example.betterto_do

import com.example.betterto_do.navigateToHome
import com.example.betterto_do.navigateToNewDestination
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Home Screen",
            style = MaterialTheme.typography.headlineLarge, // Use a different typography style, e.g., h4
            fontWeight = FontWeight.Bold, // Add fontWeight
        )

        Spacer(modifier = Modifier.height(16.dp))


    

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Navigate to the "new_destination" destination with the entered name
                navController.navigate("new_destination/$name")
            }
        ) {
            Text("Go to New Destination")
        }
    }
}
