package com.example.pointer.fragments.trainings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.trainingAdapter.MediaAdapter
import com.example.pointer.databinding.FragmentTrainingVideoBinding
import com.example.pointer.models.medislider.MediaItem

class TrainingVideoFragment : Fragment() {

    private lateinit var binding: FragmentTrainingVideoBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrainingVideoBinding.inflate(inflater, container, false)
        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.GONE
        requireActivity().findViewById<CardView>(R.id.card_price).visibility = View.GONE
        requireActivity().findViewById<CardView>(R.id.card_chat).visibility = View.GONE
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        val list: ArrayList<MediaItem> = arrayListOf()
        list.add(MediaItem(""))
        list.add(MediaItem(null, R.drawable.image20))
        list.add(MediaItem(null, R.drawable.my_image))
        list.add(MediaItem(null, R.drawable.payment))
        val adapter = MediaAdapter(list,childFragmentManager)

        binding.viewPager.adapter = adapter
        binding.indicator.setupWithViewPager(binding.viewPager)
        return binding.root
    }
}