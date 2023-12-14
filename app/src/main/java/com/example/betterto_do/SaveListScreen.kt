package com.example.betterto_do

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class SavedList(
    val title: String,
    val importance: Boolean,
    val label: String,
    val notes: String
)

@Composable
fun getSavedListsFromStorage(): List<SavedList> {
    val prefs = LocalContext.current.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    val gson = Gson()
    val json = prefs.getString("list_items", null) // Assuming you store lists in "list_items" key

    return if (json != null) {
        gson.fromJson(json, object : TypeToken<List<SavedList>>() {}.type)
    } else {
        emptyList()
    }
}

@Composable
fun SavedListsScreen(onListClick: (SavedList) -> Unit) {
    val savedLists = getSavedListsFromStorage()

    LazyColumn {
        items(savedLists) { savedList ->
            Button(
                onClick = { onListClick(savedList) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(savedList.title)
            }
        }
    }
}

