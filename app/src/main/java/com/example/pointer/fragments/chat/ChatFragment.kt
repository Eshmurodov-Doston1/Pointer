package com.example.pointer.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pointer.R
import com.example.pointer.databinding.FragmentChatBinding

class ChatFragment: Fragment(R.layout.fragment_chat) {
    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChatBinding.inflate(inflater)


        return binding.root
    }
}