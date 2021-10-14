package com.example.pointer.fragments.news

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.NewsAdapter
import com.example.pointer.databinding.FragmentNewsBinding
import com.example.pointer.models.News
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager

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


        binding.gotocalendar.setOnClickListener {
            findNavController().navigate(R.id.calendarFragment)
        }
        initData()
        newsAdapter = NewsAdapter(requireContext(), newsList)
        binding.viewPager.adapter = newsAdapter

        newsAdapter.setOnCLickListener {
            val imageView = ImageView(requireContext(), null, 0, it.image)
            val extras: FragmentNavigator.Extras = FragmentNavigator.Extras.Builder()
                .addSharedElement(imageView, "my_image").build()

            findNavController().navigate(R.id.news_to_fullNews, null, null, extras)
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