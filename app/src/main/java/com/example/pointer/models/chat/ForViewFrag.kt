package com.example.pointer.models.chat

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R

class ForViewFrag : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = View(context)

        view.setBackgroundColor(Color.RED)
        view.setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }
        return view
    }
}