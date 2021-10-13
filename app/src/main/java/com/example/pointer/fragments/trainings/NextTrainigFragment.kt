package com.example.pointer.fragments.trainings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.trainingAdapter.NextTrainingRecyclerAdapter
import com.example.pointer.databinding.FragmentNextTrainigBinding
import com.example.pointer.models.Training
import java.util.ArrayList


class NextTrainigFragment : Fragment() {

    private lateinit var binding: FragmentNextTrainigBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNextTrainigBinding.inflate(inflater, container, false)

        binding.rv.adapter = NextTrainingRecyclerAdapter(object: NextTrainingRecyclerAdapter.OnButtonClick{
            override fun onTraningClick(training: Training, position: Int) {
                findNavController().navigate(R.id.trainingVideoFragment)
            }
        },requireContext(), initList()) {
            findNavController().navigate(R.id.trainingVideoFragment)        }
        return binding.root
    }

    private fun initList(): ArrayList<Training> {

        val list: ArrayList<Training> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                Training( R.drawable.image20, "UX/UI bo’yicha master klass", "25.09.2021 12:00",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
            )
        }

        return list
    }

}