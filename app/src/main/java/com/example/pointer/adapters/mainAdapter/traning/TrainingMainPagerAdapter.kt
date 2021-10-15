package com.example.pointer.adapters.mainAdapter.traning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pointer.databinding.ItemTrainingBinding
import com.example.pointer.fragments.mainAdapterFragments.LastTraningMainFragment
import com.example.pointer.fragments.trainings.LastTrainingFragment
import com.example.pointer.fragments.trainings.NextTrainigFragment
import com.example.pointer.fragments.trainings.NowTrainingFragment
import com.example.pointer.models.Training


class TrainingMainPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LastTraningMainFragment()
            1 -> LastTraningMainFragment()
            2 -> LastTraningMainFragment()
            else -> {
                LastTraningMainFragment()
            }
        }
    }

}