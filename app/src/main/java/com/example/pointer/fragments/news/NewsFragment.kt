package com.example.pointer.fragments.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.NewsAdapter
import com.example.pointer.databinding.FragmentNewsBinding
import com.example.pointer.models.News
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class NewsFragment : Fragment(R.layout.fragment_news) {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: ArrayList<News>
    private lateinit var viewPager: HorizontalInfiniteCycleViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun prepareTransition() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNewsBinding.bind(view)

        initData()

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

        newsAdapter = NewsAdapter(requireContext(), newsList)
        binding.viewPager.adapter = newsAdapter

        newsAdapter.setOnCLickListener {
            val bundle = Bundle()
            bundle.putSerializable("news", it)
            findNavController().navigate(R.id.news_to_fullNews, bundle)
        }
    }

    private fun initData() {
        newsList = ArrayList()
        newsList.add(
            News(
                R.drawable.news_image1,
                "16.10.2021",
                1111,
                getString(R.string.news_title1),
                getString(R.string.news_desc1)
            )
        )
        newsList.add(
            News(
                R.drawable.news_image2, "15.10.2021", 2222, getString(R.string.news_title1),
                getString(R.string.news_desc1)
            )
        )
        newsList.add(
            News(
                R.drawable.news_image3, "14.10.2021", 3333, getString(R.string.news_title1),
                getString(R.string.news_desc1)
            )
        )
    }
}