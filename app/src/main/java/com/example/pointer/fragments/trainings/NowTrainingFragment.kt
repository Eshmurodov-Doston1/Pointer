package com.example.pointer.fragments.trainings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.trainingAdapter.NowTrainingRecyclerAdapter
import com.example.pointer.databinding.FragmentNowTrainingBinding
import com.example.pointer.models.Training
import java.util.ArrayList


class NowTrainingFragment : Fragment() {

    private lateinit var binding: FragmentNowTrainingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNowTrainingBinding.inflate(inflater, container, false)

        binding.rv.adapter =  NowTrainingRecyclerAdapter(object:NowTrainingRecyclerAdapter.OnButtonClick{
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
                Training( R.drawable.image20, "UX/UI bo’yicha master klass", "LIVE",
                "Pointers academy", R.drawable.oval, "Bektayev Asadbek", "Onlayn", "200 ta joy")
            )
        }

        return list
    }

}