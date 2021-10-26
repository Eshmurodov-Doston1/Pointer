package com.example.pointer.fragments.trainings

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.trainingAdapter.TrainingViewPagerAdapter
import com.example.pointer.databinding.FragmentTrainingMainBinding
import com.example.training.animations.DepthPageTransformer
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class TrainingMainFragment : Fragment() {

    private lateinit var binding: FragmentTrainingMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingMainBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        val adapter = TrainingViewPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = adapter
        binding.viewPager.setPageTransformer(true, DepthPageTransformer())
        binding.mainTablayout.setupWithViewPager(binding.viewPager)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.VISIBLE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.VISIBLE
    }

}