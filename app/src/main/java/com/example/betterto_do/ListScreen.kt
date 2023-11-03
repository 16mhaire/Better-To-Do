package com.example.betterto_do

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCreationScreen(){

    var listTitle by remember { mutableStateOf("")}

    TextField(
        value = listTitle,
        onValueChange = {newValue -> listTitle = newValue} )

}