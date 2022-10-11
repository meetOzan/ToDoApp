package com.meetozan.todoapp.data

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val readAllData: LiveData<List<ToDo>> = toDoDao.getALl()
    val readUndone: LiveData<List<ToDo>> = toDoDao.getUndone()
    val readDone: LiveData<List<ToDo>> = toDoDao.getDone()
    val readByLevel: LiveData<List<ToDo>> = toDoDao.getByLevel()

    fun addToDo(toDo: ToDo) {
        toDoDao.insert(toDo)
    }

    fun deleteToDo(toDo: ToDo) {
        toDoDao.delete(toDo)
    }

    fun updateToDo(toDo: ToDo) {
        toDoDao.updateData(toDo)
    }

}