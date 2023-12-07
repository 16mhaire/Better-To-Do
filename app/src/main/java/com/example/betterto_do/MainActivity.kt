package com.example.betterto_do

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.betterto_do.tasks.DashboardActivity
import com.example.betterto_do.tasks.TaskFragment
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)

        setContent {
            BetterToDoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskFragment()
//                    val isLoggedIn = true
//                    val isLoggedIn = FirebaseAuth.getInstance().currentUser != null
//                    if (isLoggedIn) {
//                        DashboardActivity()
//                    } else {
//                         Navigate to Login Activity
//                        navigateToLogin()
//                    }
                }
            }
        }
    }

//    private fun navigateToLogin() {
//        val intent = Intent(this, Login::class.java)
//        startActivity(intent)
//        finish() // Finish MainActivity to prevent returning to it after logging in
//    }
}