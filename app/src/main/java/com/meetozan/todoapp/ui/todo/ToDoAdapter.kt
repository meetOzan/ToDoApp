package com.meetozan.todoapp.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.TodoCardBinding

class ToDoAdapter(private val toDoList: List<ToDo>,private val viewModel: ToDoViewModel):
RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){

    class ToDoViewHolder(binding: TodoCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val toDoBinding : TodoCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = TodoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int  = toDoList.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val toDo = toDoList[position]
        holder.toDoBinding.todoCard = toDo

        holder.toDoBinding.toDoCheckBox.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                val toDoId = toDo.id
                val toDoName = toDo.name
                val toDoLevel = toDo.level
                val toDoDate = toDo.date

                val updatedToDo = ToDo(toDoId,toDoName,toDoDate,toDoLevel,true)

                viewModel.updateData(updatedToDo)
                viewModel.readAllData

            }
        }
    }
}