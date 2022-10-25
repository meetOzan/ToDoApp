package com.meetozan.todoapp.ui.done

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.TodoCardBinding

class DoneAdapter(private val doneList: List<ToDo>, private val viewModel: DoneViewModel) :
    RecyclerView.Adapter<DoneAdapter.DoneViewHolder>() {

    class DoneViewHolder(binding: TodoCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val doneBinding: TodoCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoneViewHolder {
        val binding = TodoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DoneViewHolder(binding)
    }

    override fun getItemCount(): Int = doneList.size

    override fun onBindViewHolder(holder: DoneViewHolder, position: Int) {
        val done = doneList[position]
        holder.doneBinding.todoCard = done

        holder.doneBinding.toDoCheckBox.setOnClickListener {
            if (done.isDone == true){
                val doneId = done.id
                val doneName = done.name
                val doneDate = done.date
                val doneLevel = done.level

                val updatedDone = ToDo(doneId,doneName,doneDate,doneLevel,isDone = false)

                viewModel.updateDone(updatedDone)
                viewModel.readDoneData
            }
        }

        holder.doneBinding.cardView.setOnClickListener {
            val aciton = DoneFragmentDirections.actionDoneFragmentToUpdateFragment(done)
            it.findNavController().navigate(aciton)
        }
    }
}