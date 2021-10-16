package com.example.pointer.fragments.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentFullNewsBinding
import com.example.pointer.models.News
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class FullNewsFragment : Fragment(R.layout.fragment_full_news) {
    private lateinit var binding: FragmentFullNewsBinding
    private lateinit var news: News
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFullNewsBinding.bind(view)

        news = arguments?.getSerializable("news") as News

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        binding.ivImage.setImageResource(news.image)
        binding.tvDate.text = news.date
        binding.tvViews.text = news.views.toString()
        binding.tvTitle.text = news.title
        binding.tvDesc.text = news.description
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}