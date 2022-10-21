package com.meetozan.todoapp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.R
import com.meetozan.todoapp.databinding.FragmentToDoBinding
import com.meetozan.todoapp.ui.viewmodels.ToDoViewModel

class ToDoFragment : Fragment() {

    private lateinit var binding: FragmentToDoBinding
    private lateinit var viewModel: ToDoViewModel
    private lateinit var rv: RecyclerView
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]

        rv = binding.rvToDo
        observer(viewModel)

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_toDoFragment_to_addFragment)
        }
    }

    private fun observer(viewModel: ToDoViewModel) {
        viewModel.readAllData.observe(viewLifecycleOwner) {

            adapter = ToDoAdapter(it, viewModel)
            rv.adapter = adapter
        }
    }
}