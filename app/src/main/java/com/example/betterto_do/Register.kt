package com.example.betterto_do

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
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
        //FirebaseApp.initializeApp(this)
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null){
            //something happens
        }

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

    companion object {
        fun createUser(email: String, pass: String, auth: FirebaseAuth, activity: Register){
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity) {  task ->
                    if (task.isSuccessful){
                        //Log.d(TAG, "User created")
                        val user = auth.currentUser
                        //updateUI(user)
                    } else{
                        //Log.w(TAG, "User creation failure", task.exception)
                        Toast.makeText(
                            activity,
                            "Creation failed",
                            Toast.LENGTH_SHORT
                        ).show()
                        //updateUI(null)
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
            NewUserField("email")
            NewUserField("Password")
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
fun NewUserField(field:String){
    var text by remember { mutableStateOf("")}
    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(text)},
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
}

@Composable
fun RegisterButton(auth: FirebaseAuth, activity: Register){
    var email by remember { mutableStateOf("")}
    var pass by remember { mutableStateOf("")}
    var buttonState by remember { mutableStateOf("Register now") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { /*To-Do Implement this function*/},
            modifier = Modifier.fillMaxWidth(),
            //colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
        ) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = buttonState)

    }
    Register.createUser(email, pass, auth, activity)
}
