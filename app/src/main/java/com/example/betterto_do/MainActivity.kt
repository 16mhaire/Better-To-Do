package com.example.betterto_do

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.betterto_do.edittask.EditFragment
import com.example.betterto_do.listtasks.ListFragment
import java.util.*
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.betterto_do.ui.theme.BetterToDoTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), ListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            BetterToDoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var isLoggedIn = FirebaseAuth.getInstance().currentUser
                    if (true){
                        setContentView(R.layout.activity_main)

                        // Check if the fragment container is empty and add ListFragment if it is
                        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                        if(currentFragment == null){
                            val fragment = ListFragment()
                            supportFragmentManager
                                .beginTransaction()
                                .add(R.id.fragment_container, fragment)
                                .commit()
                    }
                    else{
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}

    // Callback method for task selection in ListFragment
    override fun onTaskSelect(view: View?, taskId: UUID) {
        val fragment = EditFragment.newInstance(taskId)
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(view!!, taskId.toString())
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
