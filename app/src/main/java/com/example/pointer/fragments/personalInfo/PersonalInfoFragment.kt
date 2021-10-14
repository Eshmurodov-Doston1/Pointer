package com.example.pointer.fragments.personalInfo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentPersonalInfoBinding
import com.example.pointer.extensions.PathUtil
import com.github.dhaval2404.imagepicker.ImagePicker

class PersonalInfoFragment : Fragment(R.layout.fragment_personal_info) {
    private lateinit var binding: FragmentPersonalInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentPersonalInfoBinding.bind(view)

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