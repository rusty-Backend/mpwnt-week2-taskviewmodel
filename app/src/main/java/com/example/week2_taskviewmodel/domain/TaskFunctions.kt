package com.example.week2_taskviewmodel.domain

fun addTask(list: List<Task>, task: Task): List<Task> {
    return list + task
}

fun toggleDone(list: List<Task>, id: Int): List<Task> {
    return list.map {
        if (it.id == id) it.copy(done = !it.done) else it
    }
}

fun filterByDone(list: List<Task>, done: Boolean): List<Task> {
    return list.filter { it.done == done }
}

fun sortByDueDate(list: List<Task>): List<Task> {
    return list.sortedBy { it.dueDate }
}

fun createTask(id: Int, title: String): Task {
    return Task(
        id = id,
        title = title,
        description = "Placeholder text, add later(?)",
        priority = 1,
        dueDate = "15-01-2026",
        done = false
    )
}