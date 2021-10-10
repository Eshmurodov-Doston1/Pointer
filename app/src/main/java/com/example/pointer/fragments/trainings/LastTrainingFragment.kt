package com.example.pointer.fragments.trainings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pointer.R
import com.example.pointer.adapters.TrainingRecyclerAdapter
import com.example.pointer.databinding.FragmentLastTrainingBinding
import com.example.pointer.databinding.FragmentTrainingMainBinding
import com.example.pointer.models.Training
import java.util.ArrayList

class LastTrainingFragment : Fragment() {

    private lateinit var binding: FragmentLastTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLastTrainingBinding.inflate(inflater, container, false)

        binding.rv.adapter = TrainingRecyclerAdapter(initList()) {
            Toast.makeText(requireContext(), it.trainingName, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    private fun initList(): ArrayList<Training> {

        val list: ArrayList<Training> = ArrayList()

        for (i in 0..10)
        {
            list.add(Training( R.drawable.image20, "UX/UI bo’yicha master klass", "01.10.2021 18:30",
            "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Offlayn", "200 ta joy"))
        }

        return list
    }

}