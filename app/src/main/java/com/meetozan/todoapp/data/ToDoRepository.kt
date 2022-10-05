package com.meetozan.todoapp.data

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val readAllData: List<ToDo> = toDoDao.getALl()
    val readUndone: List<ToDo> = toDoDao.getUndone()
    val readDone: List<ToDo> = toDoDao.getDone()
    val readByLevel: List<ToDo> = toDoDao.getByLevel()


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