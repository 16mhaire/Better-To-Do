package com.example.betterto_do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.example.betterto_do.util.Routes
import com.example.betterto_do.viewmodels.add_edit_task.AddEditTaskScreen
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

//Need Android Entry Point for Dagger Hilt Injection
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        setContent {
            BetterToDoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Routes.TASK_LIST
                ) {
                    composable(Routes.TASK_LIST){
                        TaskScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(
                        route = Routes.ADD_EDIT_TASK + "?taskId={taskId}",
                        arguments = listOf(
                            navArgument(name = "taskId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        AddEditTaskScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Dashboard()
//                }
            }
        }
    }
}