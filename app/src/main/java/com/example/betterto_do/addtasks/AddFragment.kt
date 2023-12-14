package com.example.betterto_do.addtasks

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.transition.MaterialContainerTransform
import com.example.betterto_do.DatePickerFragment
import android.text.format.DateFormat
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.example.betterto_do.R
import com.example.betterto_do.databinding.FragmentAddBinding
import com.example.betterto_do.listtasks.DATE_FORMAT
import java.util.*

// Constants for dialog and return values
private const val DIALOG_DATE = "DateDialog"
private const val RETURN_DATE = 0
private const val NO_TITLE_TEXT = "Add a task title to save."

// Fragment responsible for the Add Task Screen
class AddFragment : Fragment(), DatePickerFragment.Callbacks {
    // View binding instance
    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // UI components
    private lateinit var titleInput: com.google.android.material.textfield.TextInputEditText
    private lateinit var descriptionInput: com.google.android.material.textfield.TextInputEditText
    private lateinit var dateTextView: TextView
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var notificationButton: ImageButton
    private lateinit var prioritySelect: TextView
    private lateinit var priorityIndicator: ImageView
    private lateinit var addTaskLayout: ConstraintLayout

    // ViewModel for the fragment
    // Make sure this is set to lateinit and it is initialized inside onCreateView() or app crashes
    private lateinit var addFragmentViewModel: AddFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // Initialize UI components
        saveButton = view.findViewById(R.id.savebtn)
        cancelButton = view.findViewById(R.id.cancelbtn)
        dateTextView = view.findViewById(R.id.taskDate)
        titleInput = view.findViewById(R.id.titleTextInput)
        descriptionInput = view.findViewById(R.id.descriptionTextInput)
        notificationButton = view.findViewById(R.id.notificationButton)
        prioritySelect = view.findViewById(R.id.prioritySelect)
        priorityIndicator = view.findViewById(R.id.priorityIndicator)
        addTaskLayout = view.findViewById(R.id.addtasklayout)

        // Initialize ViewModel
        addFragmentViewModel = ViewModelProvider(this)[AddFragmentViewModel::class.java]

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform(requireContext(), true).apply{
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            duration = 350
        }
    }

    override fun onStart() {
        super.onStart()
        updateUI()

        // Watchers for title and descriptionription input
        val titleWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Intentionally Left Blank
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally Left Blank
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                addFragmentViewModel.currentTask.title = s.toString()
            }
        }

        val descriptionWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Intentionally Left Blank
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally Left Blank
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                addFragmentViewModel.currentTask.description = s.toString()
            }
        }

        // Click listeners for date, notification, priority, save, and cancel buttons
        titleInput.addTextChangedListener(titleWatcher)
        descriptionInput.addTextChangedListener(descriptionWatcher)

        dateTextView.setOnClickListener {
            DatePickerFragment.newInstance(addFragmentViewModel.currentTask.dueDate).apply {
                setTargetFragment(this@AddFragment, RETURN_DATE)
                show(this@AddFragment.requireFragmentManager(), DIALOG_DATE)
            }
        }
        // Click listener for notification button
        notificationButton.setOnClickListener {
            addFragmentViewModel.currentTask.notification = !addFragmentViewModel.currentTask.notification
            if(addFragmentViewModel.currentTask.notification){
                notificationButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_notifications
                    )
                )
            }else{
                notificationButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_notifications_none
                    )
                )
            }
        }
        // Click listener for priority button
        prioritySelect.setOnClickListener {
            val itemSelected = addFragmentViewModel.currentTask.priorty
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.priorityDialog))
                .setSingleChoiceItems(resources.getStringArray(R.array.priority_dialog), itemSelected) { _, which ->
                    addFragmentViewModel.currentTask.priorty = which
                }
                .setPositiveButton("Ok") {dialog, _ ->
                    dialog.dismiss()
                    updateUI()
                }
                .show()
        }
        // Click listener for save button
        saveButton.setOnClickListener {
            if(addFragmentViewModel.currentTask.title.isEmpty()){
                Snackbar.make(addTaskLayout, NO_TITLE_TEXT, Snackbar.LENGTH_SHORT)
                .show()
            }else{
                addFragmentViewModel.addTask(addFragmentViewModel.currentTask)
                parentFragmentManager.popBackStack()
            }
        }

        cancelButton.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

    }

    // Callback method for date selection
    override fun onDateSelected(date: Date) {
        addFragmentViewModel.currentTask.dueDate = date
        updateUI()
    }

    // Update UI based on ViewModel data
    private fun updateUI() {
        titleInput.setText(addFragmentViewModel.currentTask.title)
        descriptionInput.setText(addFragmentViewModel.currentTask.description)
        dateTextView.text = DateFormat.format(DATE_FORMAT, addFragmentViewModel.currentTask.dueDate)
        updatePriority()
    }

    // Update priority UI based on ViewModel data
    private fun updatePriority() {
        when (addFragmentViewModel.currentTask.priorty) {
            0 -> {
                prioritySelect.text = "Low"
                priorityIndicator.setImageResource(R.drawable.ic_prio_low)
            }
            1 -> {
                prioritySelect.text = "Medium"
                priorityIndicator.setImageResource(R.drawable.ic_prio_medium)
            }
            else -> {
                prioritySelect.text = "High"
                priorityIndicator.setImageResource(R.drawable.ic_prio_high)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
