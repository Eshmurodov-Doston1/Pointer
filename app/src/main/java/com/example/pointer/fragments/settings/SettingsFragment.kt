package com.example.pointer.fragments.settings

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.MainActivity
import com.example.pointer.R
import com.example.pointer.databinding.FragmentSettingsBinding
import com.example.pointer.databinding.ItemLanguageBinding
import com.example.pointer.utils.BaseDialog
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSettingsBinding.bind(view)

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        binding.linearPersonInfo.setOnClickListener {
            findNavController().navigate(R.id.settings_to_info)
        }

        binding.ivLangIcon.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext()).create()
            val inflater = layoutInflater
            val bn = ItemLanguageBinding.inflate(inflater)
            alertDialog.setView(bn.root)
            alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alertDialog.window?.setGravity(Gravity.CENTER)
            bn.cancelTv.setOnClickListener {
                alertDialog.dismiss()
            }
            bn.okTv.setOnClickListener {
                forRestartIntent2()
                alertDialog.dismiss()
            }

            alertDialog.show()
        }

        binding.linearLogOut.setOnClickListener {
            logOutDialog()
        }
    }

    private fun logOutDialog() {
        val dialog = BaseDialog("Dasturdan chiqmoqchimisiz", "Yo'q", "Ha")
        dialog.setOnDoneListener {
            dialog.dismiss()
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
        dialog.setOnCancelListener {
            dialog.dismiss()
        }
        dialog.show(childFragmentManager, "sdfg")
    }

    private fun forRestartIntent2() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        (activity as MainActivity).finish()
    }
}