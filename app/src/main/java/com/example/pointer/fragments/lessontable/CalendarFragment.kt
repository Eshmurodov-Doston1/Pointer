package com.example.pointer.fragments.lessontable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.green
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentCalendarBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalendarBinding.inflate(inflater, container, false)

        binding.training.setOnClickListener {
            findNavController().navigate(R.id.trainingMainFragment)
        }

        binding.calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->

            val format: DateFormat = SimpleDateFormat("dd")
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val days = arrayListOf<String>()
            while (calendar.get(Calendar.DAY_OF_WEEK)!=2){
                calendar.add(Calendar.DAY_OF_MONTH, -1)
            }
            for (i in 0..6) {
                days.add(format.format(calendar.time))
                calendar.add(Calendar.DAY_OF_MONTH, 1)
                Calendar.DAY_OF_MONTH.green
            }

            val bundle = Bundle()
            bundle.putStringArrayList("list", days)
            bundle.putInt("week", dayOfWeek)
            findNavController().navigate(R.id.lessonTableFragment,bundle)
        }
        return binding.root
    }


}