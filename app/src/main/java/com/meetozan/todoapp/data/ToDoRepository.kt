package com.meetozan.todoapp.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ToDoRepository(private val toDoDao: ToDoDao) {

    val readAllData: Flow<List<ToDo>> = toDoDao.getALl()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addToDo(toDo: ToDo) {
        toDoDao.insert(toDo)
    }

    fun deleteToDo(toDo: ToDo) {
        toDoDao.delete(toDo)
    }

    fun updateToDo(toDo: ToDo) {
        toDoDao.updateData(toDo)
    }

}