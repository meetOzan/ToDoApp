package com.meetozan.todoapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.data.ToDoDatabase
import com.meetozan.todoapp.data.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<ToDo>>
    private val repository : ToDoRepository

    init {
        val toDoDao = ToDoDatabase.getToDoDatabase(application)?.toDoDao()
        repository = ToDoRepository(toDoDao!!)
        readAllData = repository.readAllData
    }

    fun addToDo(toDo: ToDo){
        repository.addToDo(toDo)
        //TODO şuraya olmazsa viewModelScope yap
    }

    fun updateData(toDo: ToDo){
        repository.updateToDo(toDo)
    }

    fun deleteData(toDo: ToDo){
        repository.deleteToDo(toDo)
    }


}