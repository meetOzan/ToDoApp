package com.meetozan.todoapp.data

import androidx.room.*

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getALl(): List<ToDo>

    @Query("SELECT * FROM todo WHERE is_done LIKE 1")
    fun getDone(): List<ToDo>

    @Query("SELECT * FROM todo WHERE is_done LIKE 0")
    fun getUndone(): List<ToDo>

    @Query("SELECT * FROM todo ORDER BY todo_level ASC")
    fun getByLevel() : List<ToDo>

    @Insert
    fun insert(vararg toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)

    @Update
    fun updateData(toDo: ToDo)


}