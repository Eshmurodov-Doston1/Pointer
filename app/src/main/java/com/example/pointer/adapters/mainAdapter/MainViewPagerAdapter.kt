package com.example.pointer.adapters.mainAdapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.adapters.mainAdapter.group.MyMainGroupAdapter
import com.example.pointer.fragments.mainAdapterFragments.*
import com.example.pointer.fragments.videoCources.VideoCourcesFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 9
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0->{
                VideoCourseViewPagerFragment()
           }
           1->{
               MyCourcesViewPagerFragment()
           }
           2->{
               NewsAdapterFragment()
           }
           3->{
               TraningPagerFragment()
           }
           4->{
               MyMainGroupFragment()
           }
           5->{
               LessonTableMainFragment()
           }
           6->{
               VideoCourseViewPagerFragment()
           }
           7->{
               VideoCourseViewPagerFragment()
           }
           8->{
               VideoCourseViewPagerFragment()
           }
           else->{
               VideoCourseViewPagerFragment()
           }
        }
    }
}