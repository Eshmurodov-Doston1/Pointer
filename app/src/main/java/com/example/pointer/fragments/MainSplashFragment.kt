package com.example.pointer.fragments

import android.app.ActionBar
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )

//        if (Build.VERSION.SDK_INT < 16) {
//            requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        }else{
//            val decorView: View = requireActivity().window.decorView
//            val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
//            decorView.systemUiVisibility = uiOptions
//        }

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
                    handler.postDelayed({
                        findNavController().navigate(R.id.action_mainSplashFragment_to_loginFragment)
                    },1500)
                },300)
            },600)
        }
    }
}