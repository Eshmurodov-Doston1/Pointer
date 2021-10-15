package com.example.pointer.fragments.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.MyGroupAdapter
import com.example.pointer.adapters.StudentHistoryAdapter
import com.example.pointer.databinding.FragmentStudentBinding
import com.example.pointer.models.mygroup.History
import com.example.pointer.models.mygroup.MyGroup
import java.util.ArrayList

class StudentFragment : Fragment() {

    private lateinit var binding: FragmentStudentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentBinding.inflate(inflater, container, false)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.rv.adapter = StudentHistoryAdapter(requireContext(), initList())
        return binding.root
    }

    private fun initList(): ArrayList<History> {

        val list: ArrayList<History> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                History("Android", "19.01.2021", false)
            )
            list.add(
                History("Kotlin", "19.01.2022", true)
            )
        }

        return list
    }

}