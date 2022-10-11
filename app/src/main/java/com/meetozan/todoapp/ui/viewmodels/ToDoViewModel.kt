package com.meetozan.todoapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.data.ToDoDao
import com.meetozan.todoapp.data.ToDoDatabase
import com.meetozan.todoapp.data.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    /*private val toDoDatabase : ToDoDao? = ToDoDatabase.getToDoDatabase(application)?.toDoDao()
    private val toDoList = MutableLiveData<List<ToDo>>()
    val _toDoList : LiveData<List<ToDo>>
        get() = toDoList
     */

    private val repository: ToDoRepository

    val readAllData: LiveData<List<ToDo>>

    init {
        val ToDoDao = ToDoDatabase.getToDoDatabase(application.applicationContext)?.toDoDao()
        repository = ToDoRepository(ToDoDao!!)
        readAllData = repository.readAllData
    }

    fun addToDo(toDo: ToDo) = viewModelScope.launch {
        repository.addToDo(toDo)
    }

    fun updateData(toDo: ToDo) = viewModelScope.launch {
        repository.updateToDo(toDo)
    }

    fun deleteData(toDo: ToDo) = viewModelScope.launch {
        repository.deleteToDo(toDo)
    }


}