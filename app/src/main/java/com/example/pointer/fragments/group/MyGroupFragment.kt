package com.example.pointer.fragments.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.MyGroupAdapter
import com.example.pointer.databinding.FragmentMyGroupBinding
import com.example.pointer.models.mygroup.MyGroup
import java.util.*

class MyGroupFragment : Fragment() {

    private lateinit var binding: FragmentMyGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyGroupBinding.inflate(layoutInflater, container, false)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.rv.adapter = MyGroupAdapter(requireContext(), initList()) {
            findNavController().navigate(R.id.studentFragment)        }
        return binding.root
    }

    private fun initList(): ArrayList<MyGroup> {

        val list: ArrayList<MyGroup> = ArrayList()

        for (i in 0..10)
        {
            list.add(
                MyGroup("Asadbek Bektayev", R.drawable.news_image3, true)
            )
        }

        return list
    }

}