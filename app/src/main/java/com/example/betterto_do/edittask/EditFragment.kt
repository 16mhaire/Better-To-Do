package com.example.betterto_do.edittask

import android.content.Context
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
import androidx.lifecycle.Observer
import com.example.betterto_do.DatePickerFragment
import android.text.format.DateFormat
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialContainerTransform
import com.example.betterto_do.R
import com.example.betterto_do.databinding.FragmentEditBinding
import com.example.betterto_do.listtasks.DATE_FORMAT
import com.example.betterto_do.models.Task
import java.util.*

// Constants for arguments and dialog
private const val ARG_TASK_ID = "task_id"
private const val DIALOG_DATE = "DateDialog"
private const val RETURN_DATE = 0
private const val NO_TITLE_TEXT = "Add a task title to save."

// Fragment responsible for the editing tasks screen
class EditFragment : Fragment(), DatePickerFragment.Callbacks {
    // View binding instance
    private var _binding: FragmentEditBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // UI components
    private lateinit var task: Task
    private lateinit var titleInput: com.google.android.material.textfield.TextInputEditText
    private lateinit var descriptionInput: com.google.android.material.textfield.TextInputEditText
    private lateinit var dateTextView: TextView
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var notificationButton: ImageButton
    private lateinit var editTaskLayout: ConstraintLayout

    // ViewModel for the fragment
    private lateinit var editFragmentViewModel: EditFragmentViewModel

    // Initialize ViewModel inside onAttach() APP CRASHES WITHOUT THIS!!!!!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        editFragmentViewModel = ViewModelProvider(this)[EditFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize UI components
        titleInput = view.findViewById(R.id.titleTextInput)
        descriptionInput = view.findViewById(R.id.descriptionTextInput)
        dateTextView = view.findViewById(R.id.taskDate)
        saveButton = view.findViewById(R.id.savebtn)
        cancelButton = view.findViewById(R.id.cancelbtn)
        notificationButton = view.findViewById(R.id.notificationButton)
        editTaskLayout = view.findViewById(R.id.edittasklayout)

        task = Task()
        val taskId: UUID = arguments?.getSerializable(ARG_TASK_ID) as UUID
        editFragmentViewModel.loadTask(taskId)
        editTaskLayout.transitionName = taskId.toString()

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set shared element transition for fragment enter
        sharedElementEnterTransition = MaterialContainerTransform(requireContext(), true).apply{
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            duration = 375
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editFragmentViewModel.taskLiveData.observe(viewLifecycleOwner, Observer{ task ->
            task?.let{
                this.task = task
                updateUI()
            }
        })
    }


    override fun onStart() {
        super.onStart()

        // Watcher for title input
        val titleWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Intentionally Left Blank
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally Left Blank
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                task.title = s.toString()
            }
        }

        // Watcher for descriptionription input
        val descriptionWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Intentionally Left Blank
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally Left Blank
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                task.description = s.toString()
            }
        }

        titleInput.addTextChangedListener(titleWatcher)
        descriptionInput.addTextChangedListener(descriptionWatcher)

        dateTextView.setOnClickListener{
            DatePickerFragment.newInstance(task.dueDate).apply {
                setTargetFragment(this@EditFragment, RETURN_DATE)
                show(this@EditFragment.requireFragmentManager(), DIALOG_DATE)
            }
        }

        notificationButton.setOnClickListener{
            task.notification = !task.notification
            if(task.notification){
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

        saveButton.setOnClickListener {
            if(task.title.isEmpty()){
                Snackbar.make(editTaskLayout, NO_TITLE_TEXT, Snackbar.LENGTH_SHORT)
                    .show()
            }

            editFragmentViewModel.saveTask(task)
            parentFragmentManager.popBackStack()
        }

        cancelButton.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }

    // Callback method for date selection
    override fun onDateSelected(date: Date) {
        task.dueDate = date
        updateUI()
    }

    // Update UI based on ViewModel data
    private fun updateUI() {
        titleInput.setText(task.title)
        descriptionInput.setText(task.description)
        dateTextView.setText(DateFormat.format(DATE_FORMAT, task.dueDate))
    }

    // Static method to create a new instance of EditFragment with arguments
    companion object{
        fun newInstance(taskId: UUID): EditFragment {
            val args = Bundle().apply {
                putSerializable(ARG_TASK_ID, taskId)
            }

            return EditFragment().apply {
                arguments = args
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
