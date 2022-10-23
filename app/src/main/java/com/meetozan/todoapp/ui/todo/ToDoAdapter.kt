package com.meetozan.todoapp.ui.todo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.R
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.TodoCardBinding
import com.meetozan.todoapp.ui.viewmodels.ToDoViewModel

class ToDoAdapter(private val toDoList: List<ToDo> , private val viewModel: ToDoViewModel):
RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){

    class ToDoViewHolder(binding: TodoCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val toDoBinding : TodoCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = TodoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int  = toDoList.size

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val toDo = toDoList[position]
        holder.toDoBinding.todoCard = toDo

        holder.toDoBinding.toDoCheckBox.setOnClickListener{
            if (toDo.isDone == false){
                val toDoId = toDo.id
                val toDoName = toDo.name
                val toDoLevel = toDo.level
                val toDoDate = toDo.date

                val updatedToDo = ToDo(toDoId,toDoName,toDoDate,toDoLevel,true)

                viewModel.updateData(updatedToDo)
                viewModel.readAllData

            }else{
                val toDoId = toDo.id
                val toDoName = toDo.name
                val toDoLevel = toDo.level
                val toDoDate = toDo.date

                val updatedToDo = ToDo(toDoId,toDoName,toDoDate,toDoLevel,false)

                viewModel.updateData(updatedToDo)
                viewModel.readAllData
                viewModel.readDone()
            }
        }

        if (toDo.level=="1"){
           holder.toDoBinding.backLayout.setBackgroundResource(R.color.green)
        }
        if (toDo.level=="2"){
            holder.toDoBinding.backLayout.setBackgroundResource(R.color.orange)
        }
        if (toDo.level=="3"){
            holder.toDoBinding.backLayout.setBackgroundResource(R.color.red)
        }

        holder.toDoBinding.cardView.setOnClickListener{
            it.findNavController().navigate(R.id.action_toDoFragment_to_updateFragment)
        }
    }
}