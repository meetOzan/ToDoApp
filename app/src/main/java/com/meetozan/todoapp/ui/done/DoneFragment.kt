package com.meetozan.todoapp.ui.done

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.todoapp.databinding.FragmentDoneBinding

class DoneFragment : Fragment() {

    private lateinit var viewModel: DoneViewModel
    private lateinit var adapter: DoneAdapter
    private lateinit var rv : RecyclerView
    private lateinit var binding: FragmentDoneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DoneViewModel::class.java]

        rv = binding.rvDone
        doneObserver(viewModel)

    }

    private fun doneObserver(viewModel: DoneViewModel){
        viewModel.readDoneData.observe(viewLifecycleOwner) {
            adapter = DoneAdapter(it, viewModel)
            rv.adapter = adapter
        }

    }

}