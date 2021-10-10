package com.example.pointer.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pointer.R
import com.example.pointer.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSettingsBinding.bind(view)
    }
}