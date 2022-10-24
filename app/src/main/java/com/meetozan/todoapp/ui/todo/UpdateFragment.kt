package com.meetozan.todoapp.ui.todo

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.Typeface
import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.meetozan.todoapp.R
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.FragmentUpdateBinding
import com.meetozan.todoapp.ui.viewmodels.ToDoViewModel

class UpdateFragment : Fragment() {

    private lateinit var viewModel: ToDoViewModel
    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]

        binding.updateName.setText(args.currentToDo.name)
        binding.updateDate.setText(args.currentToDo.date)
        binding.txtLevel.setText(args.currentToDo.level).toString()

        binding.updateDate.setOnClickListener {

            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(), { _, y, m, d ->

                binding.updateDate.setText("$y/${m + 1}/$d")
                println(y)
                println(m)
                println(d)

            }, year, month, day)

            datePickerDialog.setTitle("Choose Date")
            datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "SET", datePickerDialog)
            datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL", datePickerDialog)

            datePickerDialog.show()
        }

        binding.button.setOnClickListener {
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "1"
        }

        binding.button2.setOnClickListener {
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "2"
        }

        binding.button3.setOnClickListener {
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "3"
        }

        binding.buttonUpdate.setOnClickListener {
            updateToDo()
        }
    }

    private fun updateToDo() {
        val todoName = binding.updateName.text.toString()
        val todoDate = binding.updateDate.text.toString()
        val todoLevel = binding.txtLevel.text.toString()
        val isDone = args.currentToDo.isDone

        if (inputCheck(todoName, todoDate)) {
            val updatedToDo = ToDo(args.currentToDo.id, todoName, todoDate, todoLevel, isDone)
            viewModel.updateData(updatedToDo)

            findNavController().navigate(R.id.action_updateFragment_to_toDoFragment)
            Toast.makeText(context, "Succesfully Updated!!", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
    }

    private fun inputCheck(name: String, date: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(date))
    }
}