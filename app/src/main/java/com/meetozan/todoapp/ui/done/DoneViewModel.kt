package com.meetozan.todoapp.ui.done

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.data.ToDoDatabase
import com.meetozan.todoapp.data.ToDoRepository
import kotlinx.coroutines.launch

class DoneViewModel(application: Application) : AndroidViewModel(application) {

    val readDoneData: LiveData<List<ToDo>>
    private val repository: ToDoRepository

    init {
        val toDoDao = ToDoDatabase.getToDoDatabase(application.applicationContext)?.toDoDao()
        repository = ToDoRepository(toDoDao!!)
        readDoneData = repository.readDoneData.asLiveData()
    }

    fun updateDone(toDo: ToDo) = viewModelScope.launch {
        repository.updateToDo(toDo)
    }

    fun deleteDone(toDo: ToDo) = viewModelScope.launch {
        repository.deleteToDo(toDo)
    }
}