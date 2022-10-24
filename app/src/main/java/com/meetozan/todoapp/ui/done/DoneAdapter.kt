package com.meetozan.todoapp.ui.done

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.TodoCardBinding

class DoneAdapter(private val doneList: List<ToDo>, viewModel: DoneViewModel) :
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
    }
}