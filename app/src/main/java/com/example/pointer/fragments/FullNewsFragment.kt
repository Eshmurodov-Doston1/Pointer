package com.example.pointer.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentFullNewsBinding
import com.example.pointer.models.News
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationEndContainer

class FullNewsFragment : Fragment(R.layout.fragment_full_news) {
    private lateinit var binding: FragmentFullNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = arguments?.getParcelable<TransformationLayout.Params>(paramsKey)
        onTransformationEndContainer(params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFullNewsBinding.bind(view)

        val poster = arguments?.getParcelable<News>(posterKey)
        poster?.let {

            // [Step2]: sets a transition name to the target view.
            binding.detailContainer.transitionName = poster.title
            binding.ivImage.setImageResource(poster.image)
        }
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    companion object {
        const val TAG = "LibraryFragment"
        const val posterKey = "posterKey"
        const val paramsKey = "paramsKey"
    }
}