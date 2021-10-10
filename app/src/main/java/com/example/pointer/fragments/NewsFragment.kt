package com.example.pointer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.NewsAdapter
import com.example.pointer.databinding.FragmentNewsBinding
import com.example.pointer.models.News
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.skydoves.transformationlayout.TransformationLayout
import com.example.pointer.onTransformationStartContainer

class NewsFragment : Fragment(R.layout.fragment_news), NewsAdapter.PosterDelegate {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: ArrayList<News>
    private lateinit var viewPager: HorizontalInfiniteCycleViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNewsBinding.bind(view)


        binding.gotocalendar.setOnClickListener {
            findNavController().navigate(R.id.calendarFragment)
        }
        initData()
        newsAdapter = NewsAdapter(this, requireContext(), newsList)
        binding.viewPager.adapter = newsAdapter
//        newsAdapter.setOnCLickListener {
//
//
//        }
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

    override fun onItemClick(news: News, itemView: TransformationLayout) {
        val bundle = itemView.getBundle(FullNewsFragment.paramsKey)
        bundle.putParcelable(FullNewsFragment.posterKey, news)
        findNavController().navigate(R.id.news_to_fullNews, bundle)
    }
}