//package com.example.betterto_do.unused
//
//import android.content.Context
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.ExposedDropdownMenuDefaults
//import androidx.compose.material3.Switch
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.material3.*
//import androidx.compose.ui.platform.LocalContext
////import com.google.gson.Gson
////import com.google.gson.reflect.TypeToken
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@Preview(showBackground = true)
//fun ListCreationScreen() {
//    var listTitle by remember { mutableStateOf("") }
//    var listBody by remember { mutableStateOf("") }
//    var isImportant by remember { mutableStateOf(false) }
//    var isDropdownExpanded by remember { mutableStateOf(false) }
//    var labels by remember { mutableStateOf(value = "") }
//    var selectedLabel by remember { mutableStateOf("") }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clip(RoundedCornerShape(8.dp))
//            .border(3.dp, Color.Black)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            TextField(
//                value = listTitle,
//                onValueChange = { newValue -> listTitle = newValue },
//                label = { Text("List Title") },
//                modifier = Modifier
//                    .padding(16.dp)
//                    .width(180.dp)
//            )
////Save button
//            SaveButton(listTitle, isImportant, selectedLabel, listBody){
//                //onSaveButtonClick(listTitle, isImportant, selectedLabel, listBody)
//            }
//
//            /*Button(
//                onClick = { onSaveButtonClick(listTitle, isImportant, selectedLabel, listBody)},
//                modifier = Modifier.padding(16.dp)
//            ) { Text("Save") }*/
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//
////Second version (Better one so far)
//            ExposedDropdownMenuBox(expanded = isDropdownExpanded,
//                onExpandedChange = { isDropdownExpanded = it })
//            {
//                TextField(
//                    value = labels,
//                    label = { Text("Select a Label") },
//                    onValueChange = {},
//                    readOnly = true,
//                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded) },
//                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
//                    modifier = Modifier
//                        .menuAnchor()
//                        .padding(16.dp)
//                        .width(180.dp)
//                )
//
//                ExposedDropdownMenu(
//                    expanded = isDropdownExpanded,
//                    onDismissRequest = { isDropdownExpanded = false })
//                {
//
////Here are the lables themselves (there should be a way to add to and edit these later on
//                    DropdownMenuItem(
//                        text = { Text(text = "Groceries") },
//                        onClick = {
//                            labels = "Groceries"
//                            isDropdownExpanded = false
//                        })
//
//                    DropdownMenuItem(
//                        text = { Text(text = "Work") },
//                        onClick = {
//                            labels = "Work"
//                            isDropdownExpanded = false
//                        })
//
//                    DropdownMenuItem(
//                        text = { Text(text = "School") },
//                        onClick = {
//                            labels = "School"
//                            isDropdownExpanded = false
//                        })
//
//                    DropdownMenuItem(
//                        text = { Text(text = "Hobbies") },
//                        onClick = {
//                            labels = "Hobbies"
//                            isDropdownExpanded = false
//                        })
//
//                    DropdownMenuItem(
//                        text = { Text(text = "Chores") },
//                        onClick = {
//                            labels = "Chores"
//                            isDropdownExpanded = false
//                        })
//                }
//            }
//
////Important bool/switch
//            Text("Important:")
//            Switch(
//                checked = isImportant,
//                onCheckedChange = { newValue -> isImportant = newValue }
//            )
//        }
//
////This is the main body of the List it is supposed to take up a majority of the screen (like a notepad)
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Card (
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//                    .clip(RoundedCornerShape(8.dp))
//                    .border(3.dp, Color.Black)
//
//            ){
//
//                TextField(
//                    value = listBody,
//                    onValueChange = { newValue -> listBody = newValue },
//                    label = { Text("List Body") },
//                    modifier = Modifier
//                        .fillMaxHeight()
//                )
//            }
//        }
//    }
//}
//
//
//data class SavedItems(
//    val title: String,
//    val importance: Boolean,
//    val label: String,
//    val notes: String
//)
////@Composable
////fun getSavedItemsFromStorage(): List<SavedItems> {
////    val prefs = LocalContext.current.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
////    val gson = Gson()
////    val json = prefs.getString("item_list", null)
////
////    return if (json != null) {
////        gson.fromJson(json, object : TypeToken<List<SavedItems>>() {}.type)
////    } else {
////        emptyList()
////    }
////}
////@Composable
////fun saveItemsToStorage(items: List<SavedItems>) {
////    val prefs = LocalContext.current.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
////    val gson = Gson()
////    val json = gson.toJson(items)
////
////    prefs.edit().putString("item_list", json).apply()
////}
//
//@Composable
//fun SaveButton(title: String, importance: Boolean, label: String, body: String, onSaveClick: () -> Unit
//){
//    Button(onClick = { onSaveClick() },
//        modifier = Modifier.padding(16.dp)
//    ) {
//        Text("Save")
//    }
//}
//
////@Composable
////fun onSaveButtonClick(title: String, importance: Boolean, label: String, body: String) {
////    val savedItem = SavedItems(title, importance, label, body)
////    val existingSavedItems = getSavedItemsFromStorage().toMutableList()
////
////    existingSavedItems.add(savedItem)
////    saveItemsToStorage(existingSavedItems)
////}
//
//
//
