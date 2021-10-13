package com.example.pointer.fragments.trainings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentTrainingVideoBinding

class TrainingVideoFragment : Fragment() {

    private lateinit var binding: FragmentTrainingVideoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrainingVideoBinding.inflate(inflater, container, false)


        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

       return binding.root
    }

}