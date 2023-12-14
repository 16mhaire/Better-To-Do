package com.example.betterto_do.listtasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.betterto_do.R

// Bottom sheet dialog fragment for navigation options
class NavigationBottomDialogFragment: BottomSheetDialogFragment() {
    // UI components for navigation options
    private lateinit var settingsButton: TextView
    private lateinit var bugsButton: TextView
    private lateinit var translateButton: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)

        // Initialize UI components
        settingsButton = view.findViewById(R.id.settings_button)
        bugsButton = view.findViewById(R.id.bugs_button)
        translateButton = view.findViewById(R.id.translate_button)

        // TODO() Make bugsButton do something
        bugsButton.setOnClickListener {
            // do something
        }

        // TODO() Make translateButton do something
        translateButton.setOnClickListener {
            // do something
        }

        return view
    }
}