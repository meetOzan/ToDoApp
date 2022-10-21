package com.meetozan.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id") val id: Int = 0,
    @ColumnInfo(name = "todo_name") val name: String,
    @ColumnInfo(name = "todo_date") val date: String?,
    @ColumnInfo(name = "todo_level") val level: String?,
    @ColumnInfo(name = "is_done") val isDone: Boolean?
) {

}