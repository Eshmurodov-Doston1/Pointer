package com.example.pointer.adapters.trainingAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.pointer.fragments.trainings.LastTrainingFragment
import com.example.pointer.fragments.trainings.NextTrainigFragment
import com.example.pointer.fragments.trainings.NowTrainingFragment


class TrainingViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int  = 3

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> LastTrainingFragment()
            1 -> NowTrainingFragment()
            2 -> NextTrainigFragment()
            else -> {
                NextTrainigFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "O'tgan"
            1 -> "Hozirgi"
            2 -> "Kutilyotgan"

            else -> {
                "O'tgan"
            }
        }
    }

}