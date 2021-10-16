package com.example.pointer.fragments.payme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.PaymeAdapter
import com.example.pointer.adapters.trainingAdapter.NextTrainingRecyclerAdapter
import com.example.pointer.databinding.FragmentPaymeBinding
import com.example.pointer.models.Payme
import com.example.pointer.models.Training
import java.util.ArrayList

class PaymeFragment : Fragment() {

    private lateinit var binding: FragmentPaymeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymeBinding.inflate(inflater, container, false)


        binding.rv.adapter = PaymeAdapter(requireContext(), initList())
        return binding.root
    }

    private fun initList(): ArrayList<Payme> {

        val list: ArrayList<Payme> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                Payme("Tushum", R.drawable.payme, "Naqd", "+1 200 000"))
        }

        return list
    }

}