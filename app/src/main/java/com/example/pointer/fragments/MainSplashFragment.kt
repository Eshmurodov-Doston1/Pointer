package com.example.pointer.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentMainSplashBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class MainSplashFragment : Fragment(R.layout.fragment_main_splash) {
    lateinit var handler:Handler
    private val binding by viewBinding(FragmentMainSplashBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            handler = Handler(Looper.getMainLooper())
            text.visibility = View.INVISIBLE
            textPointer.visibility = View.INVISIBLE
            handler.postDelayed({
                textPointer1.visibility = View.GONE
                val loadAnimation = AnimationUtils.loadAnimation(requireContext(),R.anim.text_anim)
                textPointer.animation = loadAnimation
                text.visibility = View.INVISIBLE
                handler.postDelayed({
                    val loadAnimation1 = AnimationUtils.loadAnimation(requireContext(),R.anim.text_anim1)
                    text.animation = loadAnimation1
                    text.visibility = View.VISIBLE
                    textPointer.visibility = View.VISIBLE
                    findNavController()
                },1000)
            },1000)
        }
    }
}