package com.example.pointer.fragments.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.pointer.R
import com.example.pointer.adapters.news.ImageAdapter
import com.example.pointer.databinding.FragmentFullNewsBinding
import com.example.pointer.models.news.News2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class FullNewsFragment : Fragment(R.layout.fragment_full_news) {
    private lateinit var binding: FragmentFullNewsBinding
    private lateinit var news2: News2
    private lateinit var imageList: List<Int>

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFullNewsBinding.bind(view)
        imageList = ArrayList()
        news2 = arguments?.getSerializable("news") as News2

        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)

//        binding.ivImage.setImageResource(news.image)
        binding.tvDate.text = news2.news.date
        binding.tvViews.text = news2.news.views.toString()
        binding.tvTitle.text = news2.news.title
        binding.tvDesc.text = news2.news.description
        imageList = news2.image
        binding.collapsingToolbar.setCollapsedTitleTextColor(R.color.white)
//        binding.collapsingToolbar.title = news2.news.title
        binding.toolbarLayout.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.viewPager2.adapter = ImageAdapter(imageList)
        TabLayoutMediator(
            binding.tabDots, binding.viewPager2
        ) { tab, position ->


        }.attach()
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })
    }
}