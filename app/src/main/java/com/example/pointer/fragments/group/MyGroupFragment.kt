package com.example.pointer.fragments.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.MyGroupAdapter
import com.example.pointer.databinding.FragmentMyGroupBinding
import com.example.pointer.models.mygroup.MyGroup
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis
import java.util.*

class MyGroupFragment : Fragment() {

    private lateinit var binding: FragmentMyGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyGroupBinding.inflate(layoutInflater, container, false)

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.rv.adapter = MyGroupAdapter(requireContext(), initList()) {
            findNavController().navigate(R.id.studentFragment)
        }
        return binding.root
    }

    private fun initList(): ArrayList<MyGroup> {

        val list: ArrayList<MyGroup> = ArrayList()

        for (i in 0..10) {
            list.add(
                MyGroup("Asadbek Bektayev", R.drawable.news_image3, true)
            )
        }

        return list
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.VISIBLE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.VISIBLE
    }
}