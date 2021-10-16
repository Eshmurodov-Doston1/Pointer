package com.example.pointer.fragments.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.databinding.FragmentFullNewsBinding
import com.example.pointer.models.News

class FullNewsFragment : Fragment(R.layout.fragment_full_news) {
    private lateinit var binding: FragmentFullNewsBinding
    private lateinit var news: News
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFullNewsBinding.bind(view)

        news = arguments?.getSerializable("news") as News

        binding.ivImage.setImageResource(news.image)
        binding.tvDate.text = news.date
        binding.tvViews.text = news.views.toString()
        binding.tvTitle.text = news.title
        binding.tvDesc.text = news.description
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