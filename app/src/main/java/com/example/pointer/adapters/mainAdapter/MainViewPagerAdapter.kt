package com.example.pointer.adapters.mainAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.fragments.chat.ChatFragment
import com.example.pointer.fragments.mainAdapterFragments.*
import com.example.pointer.models.chat.ForViewFrag

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyCourcesViewPagerFragment()
            }
            1 -> {
                VideoCourseViewPagerFragment()
            }
            2 -> {
                NewsAdapterFragment()
            }
            3 -> {
                TraningPagerFragment()
            }
            4 -> {
                MyMainGroupFragment()
            }
            5 -> {
                LessonTableMainFragment()
            }
            6 -> {
                VideoCourseViewPagerFragment()
            }
            7 -> {
                VideoCourseViewPagerFragment()
            }
            8 -> {
                PaymiAdapterFragment()
            }

            9 -> {
                ForViewFrag()
            }

            else -> {
                VideoCourseViewPagerFragment()
            }
        }
    }
}