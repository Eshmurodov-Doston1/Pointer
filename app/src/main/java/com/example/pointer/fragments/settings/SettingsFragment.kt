package com.example.pointer.fragments.settings

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.MainActivity
import com.example.pointer.R
import com.example.pointer.databinding.FragmentSettingsBinding
import com.example.pointer.databinding.ItemLanguageBinding
import com.example.pointer.utils.BaseDialog
import com.example.pointer.utils.SharedPref
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var mySharedPref: SharedPref

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSettingsBinding.bind(view)
        val handlerThread = Handler(Looper.getMainLooper())
        val mainMenuBtn = requireActivity().findViewById<CircleButton>(R.id.main_menu_btn)
        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        handlerThread.postDelayed({
            mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
            mainMenuBtn.setPadding(0, 0, 0, 9)
        }, 490)
        val rotateAnimation = RotateAnimation(
            0F,
            180F,
            RotateAnimation.RELATIVE_TO_SELF,
            .5f,
            RotateAnimation.RELATIVE_TO_SELF,
            .5f
        )
        rotateAnimation.duration = 450
        mainMenuBtn.startAnimation(rotateAnimation)

        mySharedPref = SharedPref(requireContext())

        binding.linearPersonInfo.setOnClickListener {
            findNavController().navigate(R.id.settings_to_info)
        }

        binding.ivLangIcon.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext()).create()
            val inflater = layoutInflater
            val bn = ItemLanguageBinding.inflate(inflater)
            alertDialog.setView(bn.root)
//            alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            alertDialog.window?.setGravity(Gravity.CENTER)
            bn.apply {
                consUz.setOnClickListener {
                    language("uz")
                    alertDialog.dismiss()
                }
                consRu.setOnClickListener {
                    language("ru")
                    alertDialog.dismiss()
                }
                consEn.setOnClickListener {
                    language("en")
                    alertDialog.dismiss()
                }

            }
            alertDialog.show()
        }

        binding.linearLogOut.setOnClickListener {
            logOutDialog()
        }
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()

        }
    }

    private fun language(lang: String) {
        mySharedPref.setLang(lang)
        forRestartIntent2()
    }

    private fun logOutDialog() {
        val dialog = BaseDialog("Rostdan ham akkauntdan\n chiqmoqchimisiz?", "Yo'q", "Ha")
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

    override fun onResume() {
        super.onResume()
        if (requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility == View.GONE)
            requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility =
                View.VISIBLE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.VISIBLE
    }
}