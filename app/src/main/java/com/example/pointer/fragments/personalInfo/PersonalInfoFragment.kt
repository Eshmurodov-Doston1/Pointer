package com.example.pointer.fragments.personalInfo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.databinding.FragmentPersonalInfoBinding
import com.example.pointer.extensions.PathUtil
import com.github.dhaval2404.imagepicker.ImagePicker

class PersonalInfoFragment : Fragment(R.layout.fragment_personal_info) {
    private lateinit var binding: FragmentPersonalInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentPersonalInfoBinding.bind(view)
        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.GONE
        requireActivity().findViewById<CardView>(R.id.card_chat).visibility = View.GONE
        requireActivity().findViewById<CardView>(R.id.card_price).visibility = View.GONE
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.ivPersonal.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uri = data?.data ?: return
        if (resultCode == Activity.RESULT_OK) {
            val path = PathUtil.getPath(requireContext(), uri)
            binding.ivPersonal.setImageURI(uri)
        }
    }
}