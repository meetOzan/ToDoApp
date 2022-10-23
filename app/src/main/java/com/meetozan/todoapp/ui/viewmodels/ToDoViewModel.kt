package com.meetozan.todoapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.data.ToDoDatabase
import com.meetozan.todoapp.data.ToDoRepository
import kotlinx.coroutines.launch

class ToDoViewModel (application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<ToDo>>
    private val repository: ToDoRepository

    init {
        val toDoDao = ToDoDatabase.getToDoDatabase(application.applicationContext)?.toDoDao()
        repository = ToDoRepository(toDoDao!!)
        readAllData = repository.readAllData.asLiveData()
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

    fun readDone() = viewModelScope.launch {
        repository.readDoneData
    }

}