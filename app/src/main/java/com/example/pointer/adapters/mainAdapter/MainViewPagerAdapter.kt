package com.example.pointer.adapters.mainAdapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.fragments.mainAdapterFragments.VideoCourseViewPagerFragment
import com.example.pointer.fragments.videoCources.VideoCourcesFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                VideoCourseViewPagerFragment()
            }
           1->{
               VideoCourseViewPagerFragment()
           }
           2->{
               VideoCourseViewPagerFragment()
           }
           3->{
               VideoCourseViewPagerFragment()
           }
           4->{
               VideoCourseViewPagerFragment()
           }
           else->{
               VideoCourseViewPagerFragment()
           }
        }
    }

}