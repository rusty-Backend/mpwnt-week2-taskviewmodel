package com.example.week2_taskviewmodel.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week2_taskviewmodel.domain.createTask
import com.example.week2_taskviewmodel.viewmodel.TaskViewModel

@Composable
fun HomeScreen() {

    val viewModel: TaskViewModel = viewModel()
    val tasks = viewModel.tasks
    var newTaskTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Tasks",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {

            OutlinedButton(
                onClick = { viewModel.filterByDone(true) },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("✅")
            }

            OutlinedButton(
                onClick = { viewModel.sortByDueDate() },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("📅")
            }

            OutlinedButton(
                onClick = { viewModel.resetTasks() },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("🔄")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text("New task title") },
                singleLine = true,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedButton(
                onClick = {
                    if (newTaskTitle.isNotBlank()) {
                        val newTask = createTask(
                            id = tasks.size + 1,
                            title = newTaskTitle
                        )
                        viewModel.addTask(newTask)
                        newTaskTitle = ""
                    }
                },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("➕")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tasks) { task ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        checked = task.done,
                        onCheckedChange = {
                            viewModel.toggleDone(task.id)
                        }
                    )

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = task.title,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Text(
                            text = "Due: ${task.dueDate}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    OutlinedButton(
                        onClick = { viewModel.removeTask(task.id) },
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error)
                    ) {
                        Text("❌", color = MaterialTheme.colorScheme.error)
                    }
                }

                HorizontalDivider()
            }
        }
    }
}
