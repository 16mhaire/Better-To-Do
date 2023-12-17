package com.example.betterto_do

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material3.MaterialTheme
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

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        //val currentUser = auth.currentUser
        val userCredentials = mutableStateOf(UserCredentials())

        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme

                RegisterScreen(Modifier, auth, userCredentials,
                    onEmailChanged = { email ->
                        userCredentials.value = userCredentials.value.copy(email = email)
                    },
                    onPasswordChanged = { password ->
                        userCredentials.value = userCredentials.value.copy(password = password)
                    })

            }
        }
    }

    data class UserCredentials(var email: String = "", var password: String = "")


}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    auth: FirebaseAuth,
    userCredentials: MutableState<Register.UserCredentials>,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            RegisterHeader()
            NewUserField("Email", false, onEmailChanged)
            NewUserField("Password", false, onPasswordChanged)
        }



        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            ReturningUserButton()
            RegisterButton(
                auth,
                Register(),
                userCredentials.value.email,
                userCredentials.value.password
            )
        }
    }

}


@Composable
fun RegisterHeader() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.cerulean),
            text = "New User?",
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = R.color.cerulean),
            text = "Please register below.",
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewUserField(value: String, isPassword: Boolean, onValueChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
            if (it.isNotEmpty()) {
                onValueChanged(it)
            }
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
fun RegisterButton(
    auth: FirebaseAuth,
    activity: Register,
    email: String,
    password: String
) {

    //var buttonState by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val loginActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }


    Button(
        onClick = {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        //buttonState = true
                        Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT)
                            .show()

                        val intent = Intent(context, Login::class.java)
                        loginActivityLauncher.launch(intent)
                    } else {
                        //buttonState = false
                        Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
    ) {
        Text(text = "Register")
        Spacer(Modifier.height(16.dp))
    }

}

@Composable
fun ReturningUserButton() {
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
            "Have an account? Login here!"
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}