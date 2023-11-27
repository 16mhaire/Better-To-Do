package com.example.betterto_do

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FirebaseApp.initializeApp(this)
        val auth = FirebaseAuth.getInstance()

        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen(Modifier, auth)
                }
            }
        }
    }



@Composable
fun LoginScreen(modifier: Modifier = Modifier, auth: FirebaseAuth) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column(
            //modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            LoginHeading()
            Text(
                text = "Please login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )

            TextInputField("Email", false) { var email = it }
            TextInputField("Password", true) { var password = it }

        }
        //NewUserButton()

        //
        // New User Button
        //

        /*val context = LocalContext.current

        val registerActivityLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            // Handle the result if needed
        }*/

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            NewUserButton()
            LoginButton(auth)

            /*Button(
                onClick = {
                    val intent = Intent(context, Register::class.java)
                    registerActivityLauncher.launch(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "New User? Click Here!"
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }


            //LoginButton(auth)

            //
            // Login Button
            //

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var buttonState by remember { mutableStateOf("") }



            Button(
                onClick = {
                    Log.d("MyApp", "Login button clicked")
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            buttonState = "Login successful"
                        } else {
                            val exception = task.exception
                            buttonState = "Login failed: ${exception?.message}"
                            Log.d("MyApp", "Login failed: ${exception?.message}")
                        }
                    }

                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buttonState)*/

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BetterToDoTheme {
        val auth = FirebaseAuth.getInstance()
        LoginScreen(Modifier, auth)
    }
}

@Composable
fun LoginHeading(){
    Column (
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Welcome to Better To-Do",
            color = colorResource(id = R.color.cerulean),
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(value:String, isPassword:Boolean, onValueChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText },
        label = {
            Text(value)
                },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

    )
}

@Composable
fun LoginButton(auth: FirebaseAuth){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var buttonState by remember { mutableStateOf("") }

    val context = LocalContext.current

    val mainActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }

        Button(
            onClick = {
                Log.d("MyApp", "Login button clicked")
                      auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                          if (task.isSuccessful){
                              buttonState = "Login successful"

                              val intent = Intent(context, MainActivity::class.java)
                              mainActivityLauncher.launch(intent)
                          }
                          else{
                              val exception = task.exception
                              buttonState = "Login failed: ${exception?.message}"
                              Log.d("MyApp", "Login failed: ${exception?.message}")
                          }
                      }

                      },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buttonState)

}

@Composable
fun NewUserButton(){
    val context = LocalContext.current

    val registerActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }

        Button(
            onClick = {
                val intent = Intent(context, Register::class.java)
                registerActivityLauncher.launch(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
        Text(
            "New User? Click Here!"
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        }

}