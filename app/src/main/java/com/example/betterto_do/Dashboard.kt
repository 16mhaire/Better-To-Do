package com.example.betterto_do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.ComposeView
import com.example.betterto_do.ui.theme.BetterToDoTheme

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboardlayout)

        // Find the ComposeView in your layout
        val composeView = findViewById<ComposeView>(R.id.compose_view)

        // Set the content of the ComposeView
        composeView.setContent {
            BetterToDoTheme {
           DashboardScreen()
            }
        }
    }
}
@Composable
fun DashboardScreen() {
    // You can switch between different screens or show them based on some condition
    ListCreationScreen()
    TaskItem()
}
@Composable
fun ListCreationScreen() {
    // Define the UI for creating lists
}
@Composable
fun TaskItem() {
    // Define the UI for displaying a task item
}