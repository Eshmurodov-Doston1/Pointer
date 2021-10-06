package com.example.pointer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pointer.R
import com.example.pointer.adapters.NewsAdapter
import com.example.pointer.databinding.FragmentNewsBinding
import com.example.pointer.models.News
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager

class NewsFragment : Fragment(R.layout.fragment_news) {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter
    lateinit var newsList: ArrayList<News>
    private lateinit var viewPager: HorizontalInfiniteCycleViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNewsBinding.bind(view)


        initData()
        newsAdapter = NewsAdapter(requireContext(), newsList)
        binding.viewPager.adapter = newsAdapter
        newsAdapter.setOnCLickListener {

        }
    }

    private fun initData() {
        newsList = ArrayList()
        newsList.add(News(R.drawable.click1, "", 11, "", ""))
        newsList.add(News(R.drawable.click1, "", 11, "", ""))
        newsList.add(News(R.drawable.click2, "", 11, "", ""))
        newsList.add(News(R.drawable.click3, "", 11, "", ""))
        newsList.add(News(R.drawable.click4, "", 11, "", ""))
        newsList.add(News(R.drawable.click5, "", 11, "", ""))
        newsList.add(News(R.drawable.click6, "", 11, "", ""))
    }
}