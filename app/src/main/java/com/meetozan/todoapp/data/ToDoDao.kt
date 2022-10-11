package com.meetozan.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getALl(): LiveData<List<ToDo>>

    @Query("SELECT * FROM todo WHERE is_done LIKE 1")
    fun getDone(): LiveData<List<ToDo>>

    @Query("SELECT * FROM todo WHERE is_done LIKE 0")
    fun getUndone(): LiveData<List<ToDo>>

    @Query("SELECT * FROM todo ORDER BY todo_level ASC")
    fun getByLevel() : LiveData<List<ToDo>>

    @Insert
    fun insert(vararg toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)

    @Update
    fun updateData(toDo: ToDo)

}