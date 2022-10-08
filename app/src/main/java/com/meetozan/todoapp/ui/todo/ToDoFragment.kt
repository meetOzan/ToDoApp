package com.meetozan.todoapp.ui.todo

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.R
import com.meetozan.todoapp.databinding.FragmentToDoBinding
import com.meetozan.todoapp.ui.viewmodels.ToDoViewModel
import java.util.*

class ToDoFragment : Fragment() {

    private lateinit var binding : FragmentToDoBinding
    private lateinit var viewModel: ToDoViewModel
    private lateinit var rv : RecyclerView
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = binding.rvToDo



        binding.floatingActionButton.setOnClickListener {

        }

    }

}