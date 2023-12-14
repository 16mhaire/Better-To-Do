package com.example.betterto_do.listtasks

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.Hold
import com.example.betterto_do.R
import com.example.betterto_do.addtasks.AddFragment
import com.example.betterto_do.models.Task
import android.text.format.DateFormat
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.betterto_do.databinding.FragmentListBinding
import java.util.*

// Date format for displaying dates
const val DATE_FORMAT = "EEEE, MMM, dd, yyyy"

// Fragment responsible for displaying the list of tasks screen
class ListFragment : Fragment() {
    // View binding instance
    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Callback interface for handling task selection
    interface Callbacks {
        fun onTaskSelect(view: View?, taskId: UUID)
    }

    // UI components
    private var callbacks: Callbacks? = null
    private lateinit var fabButton: FloatingActionButton
    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var subTitle: TextView
    private var adapter: TaskAdapter? = TaskAdapter(emptyList())
    private lateinit var priorityIndicator: ImageView

    // ViewModel for the fragment
    // Make sure this is set to lateinit and it is initialized inside onAttach() or app crashes
    private lateinit var taskListViewModel: ListFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
        taskListViewModel = ViewModelProvider(this)[ListFragmentViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize UI components
        taskRecyclerView = view.findViewById(R.id.tasks_list)
        taskRecyclerView.layoutManager = LinearLayoutManager(context)
        taskRecyclerView.adapter = adapter
//        priorityIndicator = view.findViewById(R.id.priorityIndicator)

        subTitle = view.findViewById(R.id.subtitle)

        // Set click listener for floating action button
        //TODO Move to callback into mainactivity?
        fabButton = view.findViewById(R.id.floating_action_button)
        fabButton.setOnClickListener {
            val fragment = AddFragment()
            parentFragmentManager
                .beginTransaction()
                .addSharedElement(it, "list_to_add")
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = (requireActivity() as AppCompatActivity)
        activity.setSupportActionBar(binding.bottomAppBar)

        // Set up bottom app bar and click listener
        binding.bottomAppBar.setNavigationOnClickListener {
            val bottomSheet = NavigationBottomDialogFragment()
            bottomSheet.show(parentFragmentManager, "TAG")
        }

        // Observe LiveData for task list and task count
        taskListViewModel.taskList.observe(viewLifecycleOwner
        ) { tasks ->
            tasks?.let {
                updateList(tasks)
            }
        }

        taskListViewModel.taskListSize.observe(viewLifecycleOwner
        ) { taskCount ->
            updateOverview(taskCount)
        }
    }

    // Set exit transition for fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    // Update the RecyclerView with the latest list of tasks
    private fun updateList(tasks: List<Task>) {
        adapter?.submitList(tasks)
    }

    // Update the subtitle with the task count
    private fun updateOverview(listSize: Int) {
        var overviewString = getString(R.string.overview, listSize.toString())
        if(listSize == 0){
            overviewString += " Nice Job!"
        }
        subTitle.text = overviewString
    }

    //TaskAdapter for RecyclerView
    private inner class TaskAdapter(var tasks: List<Task>): androidx.recyclerview.widget.ListAdapter<Task, TaskHolder>(TaskDiffCallback()){
        override fun onBindViewHolder(holder: TaskHolder, position: Int) {
            val task = getItem(position)
            holder.onBind(task)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
            val view = layoutInflater.inflate(R.layout.task_list_item, parent, false)
            return TaskHolder(view)
        }
    }

    //TaskHolder for RecyclerView
    private inner class TaskHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var task: Task

        val taskTitleView: TextView = itemView.findViewById(R.id.task_title)
        val dateTextView: TextView = itemView.findViewById(R.id.task_date)
        val priorityIndicator: TextView = itemView.findViewById(R.id.task_priority)
        val taskCheckBox: CheckBox = itemView.findViewById(R.id.task_checkbox)

        init{
            itemView.setOnClickListener(this)
            taskCheckBox.setOnClickListener {
                taskListViewModel.deleteItem(task)
            }
        }

        fun onBind(task: Task){
            this.task = task
            taskTitleView.text = this.task.title
            dateTextView.text = DateFormat.format(DATE_FORMAT, this.task.dueDate)
            when (this.task.priorty) {
                0 -> {
                    priorityIndicator
                }
                1 -> {
                    priorityIndicator
                }
                else -> {
                    priorityIndicator
                }
            }
            itemView.transitionName = task.id.toString()
        }

        override fun onClick(v: View?) {
            callbacks?.onTaskSelect(v, task.id)
        }
    }

    class TaskDiffCallback: DiffUtil.ItemCallback<Task>() {
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}