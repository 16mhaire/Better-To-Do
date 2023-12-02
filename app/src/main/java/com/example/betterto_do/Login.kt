package com.example.betterto_do

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.google.firebase.auth.FirebaseAuth


class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        val userCredentials = mutableStateOf(Register.UserCredentials())

        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen(Modifier, auth, userCredentials)
            }
        }
    }
}


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    auth: FirebaseAuth,
    userCredentials: MutableState<Register.UserCredentials>
) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            LoginHeading()
            Text(
                text = "Please login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )

            TextInputField("Email", false) { userCredentials.value.email = it }
            TextInputField("Password", true) { userCredentials.value.password = it }

        }

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            NewUserButton()
            LoginButton(auth)
        }
    }

}

@Composable
fun LoginHeading() {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
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
fun TextInputField(value: String, isPassword: Boolean, onValueChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
            onValueChanged(it)
        },
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
fun LoginButton(auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    //var buttonState by remember { mutableStateOf("") }

    val context = LocalContext.current

    val mainActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }

    Button(
        onClick = {
            Log.d("MyApp", "Login button clicked")
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //buttonState = "Login successful"
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()

                    val intent = Intent(context, MainActivity::class.java)
                    mainActivityLauncher.launch(intent)
                } else {
                    val exception = task.exception
                    //buttonState = "Login failed: ${exception?.message}"

                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
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
    //Text(text = buttonState)

}

@Composable
fun NewUserButton() {
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