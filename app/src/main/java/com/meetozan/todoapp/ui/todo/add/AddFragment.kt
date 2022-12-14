package com.meetozan.todoapp.ui.todo.add

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.Color
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
import androidx.navigation.findNavController
import com.meetozan.todoapp.R
import com.meetozan.todoapp.data.ToDo
import com.meetozan.todoapp.databinding.FragmentAddBinding
import com.meetozan.todoapp.ui.viewmodels.ToDoViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: ToDoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ToDoViewModel::class.java]

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
            binding.backLayout.setBackgroundColor(Color.GREEN)
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "1"
        }

        binding.button2.setOnClickListener {
            binding.backLayout.setBackgroundColor(Color.YELLOW)
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "2"
        }

        binding.button3.setOnClickListener {
            binding.backLayout.setBackgroundColor(Color.RED)
            binding.txtLevel.setTypeface(null, Typeface.BOLD)
            binding.txtLevel.text = "3"
        }

        binding.buttonAdd.setOnClickListener {

            val name = binding.editTextName.text.toString()
            val date = binding.updateDate.text.toString()
            val level = binding.txtLevel.text.toString()

            if(inputCheck(name,date,level)){
            val tempToDo = ToDo(name = name, date = date, level = level, isDone = false)
            viewModel.addToDo(tempToDo)

            it.findNavController().navigate(R.id.action_addFragment_to_toDoFragment)
            Toast.makeText(requireContext(),"Succesfully Added",Toast.LENGTH_SHORT).show()
            }else Toast.makeText(context,"Please fill out all fields",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(name: String, date: String,level:String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(date)|| TextUtils.isEmpty(level))
    }
}