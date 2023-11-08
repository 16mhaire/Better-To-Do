package com.example.betterto_do

//This is imported to use the LocalTime for due date
import java.time.LocalTime
//Imported for task id's
import java.util.UUID

//Class to handle tasks
class Task(_taskName: String) { //intended for taskName to be *Mandatory* for all Tasks
    //Class Properties
    var taskName: String = _taskName
    private var taskDescription: String = ""
    //This should be able to set due date to the time on the user device
    private var taskDueDate: LocalTime? = null
    //To track task completion and will start as "not completed" or false
    private var taskCompleted: Boolean = false
    //Adding an id to track the task when it is in a list
    private val taskID: UUID = UUID.randomUUID()

    //Class Functions
    fun createNewTask(taskName: String): Task {
        //intended for the User to be prompted to give a name for the Task when creating a new Task
        val newTask = object {
            val taskName = readln()
        }
        return Task(readln())
    }
    fun changeTaskDescription(newTaskDescription: String): String {
        this.taskDescription = newTaskDescription
        return this.taskDescription
    }
    fun changeTaskDueDate(newTaskDueDate: LocalTime?): LocalTime? {
        this.taskDueDate = newTaskDueDate
        return this.taskDueDate
    }
    fun changeTaskCompleted(newTaskCompleted: Boolean): Boolean {
        this.taskCompleted = newTaskCompleted
        return this.taskCompleted
    }

    //Inner Class to handle SubTasks
    inner class SubTask(subTaskName: String) {
        //variable for description (may or may not keep this)
        private var subTaskDescription: String = ""
        //This should be able to set due date to the time on the user device
        private var subTaskDueDate: LocalTime? = null
        //To track task completion and will start as "not completed" or false
        private var subTaskCompleted: Boolean = false
        //Adding an id to track the task when it is in a list
        private val subTaskID: UUID = UUID.randomUUID()

        //SubTask Class Functions
//        fun createNewSubTask(newSubTaskName: String): String {
//
//        }
        fun changeSubTaskDescription(newSubTaskDescription: String): String {
            this.subTaskDescription = newSubTaskDescription
            return this.subTaskDescription
        }
        fun changeSubTaskDueDate(newSubTaskDueDate: LocalTime?): LocalTime? {
            this.subTaskDueDate = newSubTaskDueDate
            return this.subTaskDueDate
        }
        fun changeSubTaskCompleted(newSubTaskCompleted: Boolean): Boolean {
            this.subTaskCompleted = newSubTaskCompleted
            return this.subTaskCompleted
        }
    }
}

//Below I'm tinkering trying to find other ways to get this Task class rolling.
// You can uncomment it all if you want to look:

//data class Task(val title: String, val description: String, val dueDate: String)
//
//interface TaskFactory {
//    fun createTask(title: String, description: String, dueDate: String): Task
//}
//
//class DefaultTaskFactory : TaskFactory {
//    override fun createTask(title: String, description: String, dueDate: String): Task {
//        return Task(title, description, dueDate)
//    }
//}
//
//class TaskRepository(private val taskFactory: TaskFactory) {
//    private val taskList: MutableList<Task> = mutableListOf()
//
//    fun createTask(title: String, description: String, dueDate: String) {
//        val task = taskFactory.createTask(title, description, dueDate)
//        taskList.add(task)
//    }
//
//
//
//    // Add methods to retrieve, update, or delete tasks as needed.
//}
//
//val taskFactory = DefaultTaskFactory()
//val taskRepository = TaskRepository(taskFactory)

//// Create a new task
//taskRepository.createTask("Task 1", "Description for Task 1", "2023-12-31")