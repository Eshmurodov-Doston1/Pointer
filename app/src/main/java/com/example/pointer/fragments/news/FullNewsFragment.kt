package com.example.pointer.fragments.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import at.markushi.ui.CircleButton
import com.example.pointer.R
import com.example.pointer.adapters.news.ImageAdapter
import com.example.pointer.databinding.FragmentFullNewsBinding
import com.example.pointer.models.news.News2
import com.example.pointer.utils.InfoClass
import com.google.android.material.appbar.AppBarLayout
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

        requireActivity().findViewById<CircleButton>(R.id.main_menu_btn).visibility = View.GONE
        requireActivity().findViewById<ImageView>(R.id.line).visibility = View.GONE


        news2 = arguments?.getSerializable("news") as News2


        sharedElementEnterTransition = MaterialContainerTransform()
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)


        binding.tvDate.text = news2.news.date
        binding.tvViews.text = news2.news.views.toString()
        binding.tvTitle.text = news2.news.title
        binding.tvDesc.text = news2.news.description
        binding.tvToolbarTitle.text = news2.news.title
        imageList = news2.image
      binding.bacKIcon.setOnClickListener {
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

        binding.appbar.addOnOffsetChangedListener(object : InfoClass() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.COLLAPSED -> {
                        binding.tvTitle.visibility = View.INVISIBLE
                        binding.tvToolbarTitle.visibility = View.VISIBLE
                    }

//                    State.EXPANDED -> {
//                        binding.tvTitle.visibility = View.VISIBLE
//                        binding.tvToolbarTitle.visibility = View.INVISIBLE
//                    }
                    State.IDLE->{
                        binding.tvTitle.visibility=View.VISIBLE
                        binding.tvToolbarTitle.visibility=View.INVISIBLE
                    }
                }
            }

        })
    }
}