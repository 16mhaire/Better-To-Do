package com.example.betterto_do

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterto_do.tasks.Task
import com.example.betterto_do.util.TaskEvent

//This is a example task composable that can get implemented for add task
@Composable
fun TaskItem(
    task: Task,
    onEvent: (TaskEvent) -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
       Column(
           modifier = Modifier.weight(1f),
           verticalArrangement = Arrangement.Center
       ) {
           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               //task name layout with bold text
               Text(
                   text = task.taskName,
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold
                   )
                Spacer(modifier = Modifier.width(8.dp))
               //uses the task event handler for deleting tasks
               IconButton(onClick = {
                   onEvent(TaskEvent.OnDeleteTaskClick(task))

               }) {
                   //Default trash can icon for now with description
                   Icon(imageVector = Icons.Default.Delete,
                       contentDescription = "Delete"
                   )
               }
           }
           //check if the description is null first before showing task description
            task.taskDescription?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it)
            }
           //checkbox placeholder to show if the task is done or not
           Checkbox(
               checked = task.taskCompleted,
               onCheckedChange = { isChecked ->
                   onEvent(TaskEvent.OnDoneChange(task, isChecked))
               }
           )
       }

    }
}