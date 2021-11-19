package com.example.pointer.adapters.mainAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.fragments.mainAdapterFragments.*

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyCoursesViewPagerFragment()
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
//            6 -> {
//                ChatMainFragment()
//            }
//            7 -> {
//                PaymentAdapterFragment()
//            }
//            8 -> {
//                SettingsMainFragment()
//            }

            else -> {
                VideoCourseViewPagerFragment()
            }
        }
    }
}