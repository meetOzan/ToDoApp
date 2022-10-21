package com.meetozan.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo ORDER BY todo_id ASC")
    fun getALl(): Flow<List<ToDo>>

    @Query("SELECT * FROM todo WHERE is_done LIKE 1")
    fun getDone(): Flow<List<ToDo>>

    @Query("SELECT * FROM todo WHERE is_done LIKE 0")
    fun getUndone(): Flow<List<ToDo>>

    @Query("SELECT * FROM todo ORDER BY todo_level ASC")
    fun getByLevel() : Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)

    @Update
    fun updateData(toDo: ToDo)

}