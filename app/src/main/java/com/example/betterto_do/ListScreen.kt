package com.example.betterto_do

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ListCreationScreen() {
    var currentScreen: String by remember { mutableStateOf("Dashboard") }

    var listTitle by remember { mutableStateOf("") }
    var listBody by remember { mutableStateOf("") }
    var isImportant by remember { mutableStateOf(false) }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var labels by remember { mutableStateOf(value = "") }
    var selectedLabel by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(3.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = listTitle,
                onValueChange = { newValue -> listTitle = newValue },
                label = { Text("List Title") },
                modifier = Modifier
                    .padding(16.dp)
                    .width(180.dp)
            )
//Save button
            Button(
                onClick = { /* Save this List */ },
                modifier = Modifier.padding(16.dp)
            ) { Text("Save") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

//Second version (Better one so far)
            ExposedDropdownMenuBox(expanded = isDropdownExpanded,
                onExpandedChange = { isDropdownExpanded = it })
            {
                TextField(
                    value = labels,
                    label = { Text("Select a Label") },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .padding(16.dp)
                        .width(180.dp)
                )

                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false })
                {

//Here are the lables themselves (there should be a way to add to and edit these later on
                    DropdownMenuItem(
                        text = { Text(text = "Groceries") },
                        onClick = {
                            labels = "Groceries"
                            isDropdownExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text(text = "Work") },
                        onClick = {
                            labels = "Work"
                            isDropdownExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text(text = "School") },
                        onClick = {
                            labels = "School"
                            isDropdownExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text(text = "Hobbies") },
                        onClick = {
                            labels = "Hobbies"
                            isDropdownExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text(text = "Chores") },
                        onClick = {
                            labels = "Chores"
                            isDropdownExpanded = false
                        })
                }
            }

//Important bool/switch
            Text("Important:")
            Switch(
                checked = isImportant,
                onCheckedChange = { newValue -> isImportant = newValue }
            )
        }

//This is the main body of the List it is supposed to take up a majority of the screen (like a notepad)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(3.dp, Color.Black)

            ){

                    TextField(
                        value = listBody,
                        onValueChange = { newValue -> listBody = newValue },
                        label = { Text("List Body") },
                        modifier = Modifier
                            .fillMaxHeight()
                    )
            }
        }
    }
}

data class SavedItems(
    val title: String,
    val importance: Boolean,
    val label: String,
    val notes: String
)
val Save = listOf<SavedItems>()


//First version of the drop down bar
    /*Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ){
            Text("Select a Label:")
            OutlinedTextField(
                value = selectedLabel,
                onValueChange = { newValue -> selectedLabel = newValue },
                singleLine = true,
                readOnly = true, //Change when we want to make lables editable
                trailingIcon = {
                    IconButton(onClick = { isDropdownExpanded }) {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )}*/


//This is tied to the first version of the dropdown menu (I couldnt figure this part out)
        /*DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false }
        ) {
            labels.forEach { label ->
                if (label.isNotBlank()) {
                    DropdownMenuItem(
                        onClick = {
                            selectedLabel = label
                            isDropdownExpanded = false
                        }
                    ) {
                        Text(text = label)
                    }
                }
            }
        }*/


 //Original List Body code
            /*Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextField(
                        value = listBody,
                        onValueChange = { newValue -> listBody = newValue },
                        label = { Text("List Body") }
                    )
                }

            }*/












