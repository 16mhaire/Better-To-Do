package com.example.betterto_do

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import android.content.ContentValues.TAG
import android.content.Intent
import android.health.connect.datatypes.units.Length
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        /*if (currentUser != null){
            //something happens
        }*/

        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen(Modifier, auth)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    BetterToDoTheme {
        val auth = FirebaseAuth.getInstance()
        RegisterScreen(auth = auth)
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, auth: FirebaseAuth) {
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            RegisterHeader()
            NewUserField("Email", false) { var email = it }
            NewUserField("Password", true) { var password = it }
            RegisterButton(auth, Register())
        }
    }
}

@Composable
fun RegisterHeader(){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
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
fun NewUserField(value:String, isPassword:Boolean, onValueChanged: (String) -> Unit){
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
fun RegisterButton(auth: FirebaseAuth, activity: Register){
    var email by remember { mutableStateOf("")}
    var pass by remember { mutableStateOf("")}
    var buttonState by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val loginActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        // Handle the result if needed
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                //val toast = Toast.makeText(context, email, Toast.LENGTH_SHORT)
                auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        buttonState = true
                        //toast.show()
                        val intent = Intent(context, Login::class.java)
                        loginActivityLauncher.launch(intent)
                    } else {
                        buttonState = false
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
        ) {
            Text(text = "Register")
        }
    }
}

