package com.example.pointer.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.example.pointer.MainActivity
import com.example.pointer.R
import com.example.pointer.databinding.FragmentLoginBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        requireActivity().window.statusBarColor = Color.parseColor("#F7F7FC")
        requireActivity().window.navigationBarColor =Color.parseColor("#F7F7FC")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cons.setOnClickListener {
                val login = login.text.toString().trim()
                val password = simplePassword.text.toString().trim()
                if (login.isNotEmpty() && password.isNotEmpty()){
                    startActivity(Intent(requireContext(),MainActivity::class.java))
                }else{
                    Toast.makeText(requireContext(), "Iltimos Login va Passwordni kiriting", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}