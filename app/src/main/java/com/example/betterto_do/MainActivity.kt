package com.example.betterto_do

import android.R
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {
    class YourActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_item) // replace with your layout file name
        }

        // This method is linked with the button that has android:onClick="TasksItem"
        fun Today(view: View?) {
            // Handle the click event for TasksItem
        }
        // Define similar methods for other buttons
        fun Important(view: View?) {
            // Handle the click event for important
        }
        fun Scheduled(view: View?) {
            // Handle the click event for important
        }
        fun getAllTask(view: View?) {
            // Handle the click event for All
        } // ... other methods ...
    }
}
