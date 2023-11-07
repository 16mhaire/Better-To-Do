package com.example.betterto_do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen("Android")
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(name: String, modifier: Modifier = Modifier) {
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            RegisterHeader();
            NewUserField();
            NewUserField();
            NewUserField();
            NewUserField();
            RegisterButton();
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
fun NewUserField(){
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
fun RegisterButton(){
    var buttonState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { /*To-Do Implement this function*/},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.frenchPink))
        ) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = buttonState)

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    BetterToDoTheme {
        RegisterScreen("Android")
    }
}