package com.example.betterto_do

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.betterto_do.edittask.EditFragment
import com.example.betterto_do.listtasks.ListFragment
import java.util.*

class MainActivity : AppCompatActivity(), ListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
