package com.example.pointer.fragments.trainings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.example.pointer.R
import com.example.pointer.adapters.TrainingViewPagerAdapter
import com.example.pointer.databinding.FragmentTrainingMainBinding
import com.example.training.animations.DepthPageTransformer

class TrainingMainFragment : Fragment() {

    private lateinit var binding: FragmentTrainingMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingMainBinding.inflate(inflater, container, false)

        val adapter = TrainingViewPagerAdapter(parentFragmentManager)
        binding.viewPager.adapter = adapter
        binding.viewPager.setPageTransformer(true, DepthPageTransformer())
        binding.tablayout.setupWithViewPager(binding.viewPager)

        return binding.root
    }

}