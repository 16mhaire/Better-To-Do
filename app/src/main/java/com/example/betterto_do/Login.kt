package com.example.betterto_do

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import java.time.format.TextStyle

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
                }
            }
        }
    }


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column {
            LoginHeading()
            Text(
                text = "Please login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            TextInputField("UserName")
            TextInputField("Password")
            LoginButton()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BetterToDoTheme {
        LoginScreen()
    }
}

@Composable
fun LoginHeading(){
    Text(
        text = "Welcome to Better To-Do",
        color = colorResource(id = R.color.cerulean),
        modifier = Modifier.fillMaxWidth(),
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.Center,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(value:String) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(value) },
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun LoginButton(){
    var buttonState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Button(
            onClick = { /*To-Do Implement this function*/},
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buttonState)

        }
}